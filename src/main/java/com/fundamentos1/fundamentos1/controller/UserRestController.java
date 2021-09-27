package com.fundamentos1.fundamentos1.controller;

import com.fundamentos1.fundamentos1.caseuse.*;
import com.fundamentos1.fundamentos1.dto.UserDto;
import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.repository.PhoneRepository;
import com.fundamentos1.fundamentos1.repository.UserRepository;
import com.fundamentos1.fundamentos1.service.PhoneService;
import com.fundamentos1.fundamentos1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//vamos a crear todos los servicios rest contenidos por un cliente
@RestController//permite que todos los metodos se formateen con el formato JSON
public class UserRestController {
    //Crearemos una capa relacionada con los servicios que vamos a desplegar
    //create,get,delete,update

    @Autowired
    private GetUser getUser;
    private GetPhone getPhone;
    private CreateUser createUser;
    private CreatePhone createPhone;
    private PhoneService phoneService;
    private UserService userService;
    private UpdateUser updateUser;
    private UserRepository userRepository;
    private PhoneRepository phoneRepository;

    public UserRestController(UserService userService,PhoneService phoneService,CreatePhone createPhone,GetUser getUser, GetPhone getPhone, CreateUser createUser, UpdateUser updateUser, UserRepository userRepository, PhoneRepository phoneRepository) {
        this.getUser = getUser;
        this.getPhone=getPhone;
        this.createUser=createUser;
        this.createPhone=createPhone;
        this.updateUser=updateUser;
        this.userRepository=userRepository;
        this.phoneRepository=phoneRepository;
        this.phoneService=phoneService;
        this.userService=userService;


    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping("/")

    List<User> getUser(){

        return getUser.getAll();
    }

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    @GetMapping("/")

    List<Phone> get(){

        return getPhone.getAll();
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<UserDto> newUser(@RequestBody User newUser, UserDto userDto) {

        userService.newUser(newUser);
        UserDto userDto1=new UserDto();
        User userCreated = new User();
        UUID id_uuid=UUID.randomUUID();
        UUID token=UUID.randomUUID();
        LocalDateTime createdDate=LocalDateTime.now();

       userDto1.setId(id_uuid);
       newUser.setId(id_uuid);

        userDto1.setCreated(createdDate);
        newUser.setCreated(createdDate);

        userDto1.setModified(createdDate);
        newUser.setCreated(createdDate);

        userDto1.setLast_login(createdDate);
        newUser.setLast_login(createdDate);

        userDto1.setToken(token);
        userCreated.setToken(token);

        userDto1.setIs_Active(true);
        userCreated.setActive(true);


        return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }


    @RequestMapping(value = "/createPhone", method = RequestMethod.POST)
    public ResponseEntity<Phone> newPhone(@RequestBody Phone newPhone) {


        //User usurious = new User();
        Phone phoneCreated=phoneService.newPhone(newPhone);
        return new ResponseEntity<>(phoneCreated,HttpStatus.CREATED);

        // usurious.setName(newUser.getName());
        //usurious.setPassword(newUser.getEmail());
        //phone.setNumber(newPhone.getNumber());
        //phone.setCityCode(newPhone.getCityCode());
        //phone.setCountryCode(newPhone.getCountryCode());
        //UUID User =UUID.randomUUID();
        // LocalDateTime fechaCreacion=LocalDateTime.of();
        //    LocalDateTime modified=LocalDateTime.of();
        // LocalDateTime last_time=LocalDateTime.of( );
        //UUID token =UUID.randomUUID();
      //  Boolean isActive=true;

       // return new ResponseEntity(usurious, HttpStatus.OK);

    }



     @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser,@PathVariable Long id){

       return new ResponseEntity<>(updateUser.update(newUser,id),HttpStatus.OK);
     }


}
