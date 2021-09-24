package com.fundamentos1.fundamentos1.controller;

import com.fundamentos1.fundamentos1.caseuse.CreateUser;
import com.fundamentos1.fundamentos1.caseuse.GetUser;
import com.fundamentos1.fundamentos1.caseuse.UpdateUser;
import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//vamos a crear todos los servicios rest contenidos por un cliente
@RestController//permite que todos los metodos se formateen con el formato JSON
@RequestMapping("/api/users")
public class UserRestController {
    //Crearemos una capa relacionada con los servicios que vamos a desplegar
    //create,get,delete,update
    private GetUser getUser;
    private CreateUser createUser;

    private UpdateUser updateUser;
    private UserRepository userRepository;

    public UserRestController(GetUser getUser,CreateUser createUser,UpdateUser updateUser,UserRepository userRepository) {
        this.getUser = getUser;
        this.createUser=createUser;

        this.updateUser=updateUser;
        this.userRepository=userRepository;
    }
    @GetMapping("/")

    List<User> get(){

        return getUser.getAll();
    }

    @PostMapping(
            consumes = {"application/xml", "application/json"},
            produces = {"application/xml", "application/json"}
    )
    public ResponseEntity<User> newUser(@RequestBody User newUser, Phone newPhone) {


        User usurious = new User();
        Phone phone = new Phone();
        usurious.setName(newUser.getName());
        usurious.setPassword(newUser.getEmail());
        phone.setNumber(newPhone.getNumber());
        phone.setCityCode(newPhone.getCityCode());
        phone.setCountryCode(newPhone.getCountryCode());
        UUID User =UUID.randomUUID();
        // LocalDateTime fechaCreacion=LocalDateTime.of();
        //    LocalDateTime modified=LocalDateTime.of();
        // LocalDateTime last_time=LocalDateTime.of( );
        UUID token =UUID.randomUUID();
        Boolean isActive=true;
        return new ResponseEntity(usurious, HttpStatus.OK);

    }



     @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser,@PathVariable Long id){

       return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
     }

     @GetMapping("/pageable")
    List<User>getUserPageable(@RequestParam int page,@RequestParam int size){
            return userRepository.findAll(PageRequest.of(page,size)).getContent();
     }
}
