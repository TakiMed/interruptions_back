package com.example.predavanjademo.web.controllers;
import com.example.predavanjademo.entities.User;
import com.example.predavanjademo.services.UserService;
import com.example.predavanjademo.web.dto.UserDTO;
import com.example.predavanjademo.web.dto.UserSearchDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
        if(user.getId()!=null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
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
}
