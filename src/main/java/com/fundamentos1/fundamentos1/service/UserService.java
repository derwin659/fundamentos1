package com.fundamentos1.fundamentos1.service;

import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG= LogFactory.getLog(UserService.class);

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    //Gracias a transactional el mismo metodo puede realizar un rollback
    public void saveTransactional(List<User> users){

        users.stream()
                .peek(user->LOG.info("Usuario Insertado"+user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Registrandoen base de datos

    public User save(User newUser) {
        return userRepository.save(newUser);
    }



    public User update(User newUser, Long id) {
        return
            userRepository.findById(id)
                    .map(
                            user->{
                                       user.setEmail(newUser.getEmail());

                                       user.setName(newUser.getName());
                        return userRepository.save(user);
                                     }
                    ).get();

    }
}
