package com.example.predavanjademo.web.controllers;
import com.example.predavanjademo.entities.User;
import com.example.predavanjademo.services.UserService;
import com.example.predavanjademo.web.dto.UserDTO;
import com.example.predavanjademo.web.dto.UserSearchDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id)
    {
        User user = userService.getUserById(id);
        return user!=null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // /by-query-params?firstName=Janko&lastName=Jankovic
    @GetMapping(value = "/by-query-params")
    public ResponseEntity<List<User>> getByFirstAndLastName(@RequestParam(value = "firstName") String firstName,
                                                            @RequestParam(value = "lastName") String lastName)
    {
        List<User> users = userService.findByFistAndLastName(firstName, lastName);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        if(user.getId()==null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        User storedUser = userService.store(user);
        return storedUser!=null
                ? new ResponseEntity<>(storedUser, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "using-map")
    public ResponseEntity<Void> storeUsingMap(@RequestBody Map<String, Object> requestBody){
        ObjectMapper objectMapper = new ObjectMapper();
        UserDTO userDTO = objectMapper.convertValue(requestBody, UserDTO.class);
        LOGGER.info("After Mapping, {}", userDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer id,
                                           @RequestBody User user)
    {
        if(user.getId()!=null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        User updatedUser = userService.updateUser(id, user);
        return updatedUser!=null
                ? new ResponseEntity<>(updatedUser, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Integer id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/dto")
    public ResponseEntity<List<UserDTO>> getUserDTO(){
        List<UserDTO> userDTOs = userService.getAllUserDTOs();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "by-many-query-params")
    public ResponseEntity<List<User>> getByManyQueryParams(UserSearchDTO userSearchDTO)
    {
        LOGGER.info("QueryParams: {}", userSearchDTO.toString());
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "header")
    public ResponseEntity<Void> processOneRequestHeader(@RequestHeader(value = "authorization") String authHeader){
        LOGGER.info("Header: {}", authHeader);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/dto")
    public ResponseEntity<Void> storeUserDtoWithContacts(@RequestBody UserDTO userDTO)
    {
        LOGGER.info("payload: {}", userDTO.toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/entities/all")
    public ResponseEntity<List<User>> findAllEntities(){
        List<User> users = userService.findAllEntities();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping(value = "/entities/{id}")
    public ResponseEntity<User> findEntityById(@PathVariable(value = "id") Integer id){
        Optional<User> user = userService.findUserEntityById(id);
        return  user.isPresent()
                ? new ResponseEntity<>(user.get(), HttpStatus.OK) // 200
                : new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
    }

    @PostMapping(value = "/entities")
    public ResponseEntity<User> createUserEntity(@RequestBody User user){
       User persistedUser = userService.create(user);
       return new ResponseEntity<>(persistedUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "/entities")
    public ResponseEntity<User> updateUserEntity(@RequestBody User user){
        if(user.getId()==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        User updatedUser = userService.updateUserEntity(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @PutMapping(value = "/entities/{id}")
    public ResponseEntity<User> updateUserEntityById(@PathVariable(value = "id") Integer id, @RequestBody User user)
    {
        User updatedUser = userService.updateUserEntityById(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/entities/{id}")
    public ResponseEntity<Void> deleteUserEntity(@PathVariable(value = "id") Integer id)
    {
        // moras veze da raskines pa da obrises i iz rola
        userService.deleteEntityById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/entities/by-username") // /ent/by-username?username=asd
    public ResponseEntity<User> findEntityByUsername(@RequestParam(value = "username") String username){
        Optional<User> user = userService.findByUsername(username);
        return  user.isPresent()
                ? new ResponseEntity<>(user.get(), HttpStatus.OK) // 200
                : new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
    }

    @GetMapping(value = "/entities/by-isactive") // /ent/by-isactive?username=asd
    public ResponseEntity<List<User>> findActiveUser()
    {
        List<User> users = userService.findByIsActive();
        return new ResponseEntity<>(users, HttpStatus.OK); // 200
    }

    @GetMapping(value = "/entities/by-date-created") // ?created_at=2021-12-15T01:00:00 god-mm-ddThh:mm:ss
    // mora se string iz request parama konvertovati u datum
    public ResponseEntity<List<User>> findByCreatedAt(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") @RequestParam(value = "created_at") Date createdAt)
    {
        List<User> users = userService.findByCreatedAt(createdAt);
        return new ResponseEntity<>(users, HttpStatus.OK); // 200
    }

    @GetMapping(value = "/entities/existing-by-firstname")
    public ResponseEntity<Boolean> existsByFirstNameStartingWith(@RequestParam(value = "first_name") String firstnameSearchTerm){
        Boolean userBool = userService.existingWithFirstNameStartingWith(firstnameSearchTerm);
        return new ResponseEntity<>(userBool, HttpStatus.OK); // 200
    }


}
