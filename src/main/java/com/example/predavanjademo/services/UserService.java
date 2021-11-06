package com.example.predavanjademo.services;
import com.example.predavanjademo.entities.User;
import com.example.predavanjademo.repositories.UserRepository;
import com.example.predavanjademo.web.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

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
   /*
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
*/
    public User store(User user) {

        User savedUser = new User();
        savedUser.setId(78);
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        return savedUser;

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
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

    public List<User> findAllEntities() {
        return userRepository.findAll();
    }

    public Optional<User> findUserEntityById(Integer id){
        return userRepository.findById(id);
    }


    public User create(User user) {
        return userRepository.save(user); // ave radi insert ako nema id-a, ao nadje uradice update
    }

    public User updateUserEntity(User user) {
        return userRepository.save(user);
    }

    public User updateUserEntityById(Integer id, User user) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User updatedUser = userOptional.get();
            updatedUser.setFirstName(user.getFirstName());
            return userRepository.save(updatedUser);
        }
        throw new EntityNotFoundException("User with id " + id + " not found");
    }

    public void deleteEntityById(Integer id) {
        // userRepository.deleteById(id);
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(id);
        }
        throw new EntityNotFoundException("User with id " + id + " not found");
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsernameLike(username);
    }

    public List<User> findByIsActive() {
        return userRepository.findByIsActiveIsTrue();
    }

    public List<User> findByCreatedAt(Date createdAt) {
         return userRepository.findByCreatedAtBefore(createdAt);
    }

    public Boolean existingWithFirstNameStartingWith(String firstname) {
       return userRepository.existsByFirstNameStartingWith(firstname);
    }

}
