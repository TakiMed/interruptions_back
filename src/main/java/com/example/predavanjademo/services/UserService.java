package com.example.predavanjademo.services;


import com.example.predavanjademo.entities.User;
import com.example.predavanjademo.web.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Value(value = "${auth}")
    private boolean authBool;

    @Autowired
    private Environment environment;

    public void printCustomSecurityProperties(){
        // String username = environment.getProperty("${custom-security.username}");
        // String password = environment.getProperty("${custom-security.password}");
        String defaultUsername = environment.getProperty("${custom-security.username}","default-username");
        String defaultPassword = environment.getProperty("${custom-security.password}", "defaultPasswrod");
        // System.out.println("");
        LOGGER.info("Username is: {} and Password id: {}", defaultUsername, defaultPassword);
    }
    // tradicinalni nacin deklarises varijablu i kreiras objekat u kontruktoru userService-a
    /*
    private CustomerService customerService;
    public UserService(){
        this.customerService = new CustomerService();
    }

    // 1. nacin DI - ubrizgavanje zavisnosti - dependencyInjection - Autowired
    @Autowired   // SPC skrenira bean-ove i trazi objekat koji se zove ovako kako smo nazval promljenjivu
    private CustomerService customerService;
    */

    /*
    // 2. nacin DI - koristeci kontruktr

    private CustomerService customerService;

    public UserService(CustomerService customerService)
    {
        this.customerService = customerService;
    }
    */

    // 3. nacin DI - koristeci setter, ako imate ciklicne zavisnosti, jedan servis ukljucuje drugi i obratno
    //
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService  customerService){
        this.customerService  = customerService;
    }
    @Autowired
    @Qualifier(value = "CS2")
    private CustomerService cs1; // recimo kad imamo 2 objekta za isti servis


    public void printUsernameForCustomer(String customerName){
        this.customerService.findByName(customerName); // NullPointerException

    }

    public User store(User user) {
        User savedUser = new User();
        savedUser.setId(78);
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        return savedUser;

    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Marko");
        user1.setLastName("Markovic");
        users.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Zarko");
        user2.setLastName("Zarkovic");
        users.add(user2);
        return users;

    }

    public User getUserById(Integer id){
        List<User> users = getAllUsers();
        for (User user: users)
        {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findByFistAndLastName(String firstName, String lastName) {
        List<User> users = getAllUsers();
        List<User> filtered = new ArrayList<>();
        for(User user: users){
            if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)){
                filtered.add(user);
            }
        }
        return  filtered;
    }


    public User updateUser(Integer id, User user) {
        User foundUser = getUserById(id);
        if(foundUser!=null){
            foundUser.setFirstName(user.getFirstName());
            foundUser.setLastName(user.getFirstName());
            return foundUser;
        }
        return null;
    }

    public void delete(Integer id) {
        User foundUser = getUserById(id);
        if(foundUser!=null) {
            LOGGER.info("Delete entity with identifier: {}", id);
        }
    }


    public List<UserDTO> getAllUserDTOs() {
        List<User> users = getAllUsers(); // null | []
        List<UserDTO> userDTOs = new ArrayList<>();
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setFirstName(user.getFirstName());
                userDTO.setLastName(user.getFirstName());
                userDTOs.add(userDTO);
            }
        }
        return userDTOs;
    }
}

// @Comoponent - da springBeanContainer kreira objekat klase UserService i moze da se ubrizga u bilo koje druge klase
// sa svim svojim atributima
// @Service - da SBC kreira objekat klase te i te
// @Repository

// @RestController