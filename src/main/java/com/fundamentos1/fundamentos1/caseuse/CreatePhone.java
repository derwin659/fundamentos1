package com.fundamentos1.fundamentos1.caseuse;

import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.entity.User;
import com.fundamentos1.fundamentos1.service.PhoneService;
import com.fundamentos1.fundamentos1.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class CreatePhone {

    private PhoneService phoneService;
    public CreatePhone(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    public Phone save(Phone newPhone) {
        return phoneService.save(newPhone);
    }
}
