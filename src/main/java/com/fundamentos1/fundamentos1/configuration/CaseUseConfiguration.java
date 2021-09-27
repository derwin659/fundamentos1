package com.fundamentos1.fundamentos1.configuration;

import com.fundamentos1.fundamentos1.caseuse.GetPhone;
import com.fundamentos1.fundamentos1.caseuse.GetPhoneImplement;
import com.fundamentos1.fundamentos1.caseuse.GetUser;
import com.fundamentos1.fundamentos1.caseuse.GetUserImplement;
import com.fundamentos1.fundamentos1.service.PhoneService;
import com.fundamentos1.fundamentos1.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){

        return new GetUserImplement(userService);
    }

    @Bean
    GetPhone getPhone(PhoneService phoneService){

        return new GetPhoneImplement(phoneService);
    }
}
