package com.fundamentos1.fundamentos1.caseuse;

import com.fundamentos1.fundamentos1.entity.Phone;
import com.fundamentos1.fundamentos1.service.PhoneService;
import com.fundamentos1.fundamentos1.service.UserService;

import java.util.List;

public class GetPhoneImplement implements GetPhone{

    private PhoneService phoneService;

    public GetPhoneImplement(PhoneService phoneService) {
        this.phoneService=phoneService;
    }

    @Override
    public List<Phone> getAll() {
        return phoneService.getAllPhones();
    }
}
