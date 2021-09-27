package com.fundamentos1.fundamentos1;

import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.entity.User;
import org.springframework.beans.factory.*;
import com.fundamentos1.fundamentos1.repository.PhoneRepository;
import com.fundamentos1.fundamentos1.repository.UserRepository;
import com.fundamentos1.fundamentos1.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Fundamentos1Application implements CommandLineRunner {

	private final Log LOGGER= LogFactory.getLog(Fundamentos1Application.class);


	private UserRepository userRepository;
	private PhoneRepository phoneRepository;
	private UserService userService;


	public Fundamentos1Application(UserRepository userRepository,UserService userService,PhoneRepository phoneRepository) {

		this.phoneRepository=phoneRepository;
		this.userRepository=userRepository;
		this.userService=userService;
	}



	public static void main(String[] args) {

		SpringApplication.run(Fundamentos1Application.class, args);

	}

	public void run(String... args){

		//ejemplosAnteriores();
		saveUsersInDataBase();

	}



	private void saveUsersInDataBase(){

		Phone phone1=new Phone(1,"john@domain.com", "derwin","adrian");


		List<Phone> list= Arrays.asList(phone1);
	     list.stream().forEach(phoneRepository::save);
	}



}
