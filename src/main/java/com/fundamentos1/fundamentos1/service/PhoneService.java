package com.fundamentos1.fundamentos1.service;

import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.repository.PhoneRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    private final Log LOG= LogFactory.getLog(PhoneService.class);
    private PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAllPhones(){
        return phoneRepository.findAll();
    }

    public Phone save(Phone getPhone) {
        return phoneRepository.save(getPhone);
    }

    public Phone newPhone(Phone newPhone) {
        return phoneRepository.save(newPhone);
    }


    public Phone update(Phone newPhone, Long id) {
        return
               phoneRepository.findById(id)
                        .map(
                                phone->{
                                    phone.setCityCode(newPhone.getCityCode());


                                    return phoneRepository.save(phone);
                                }
                        ).get();

    }

   
}
