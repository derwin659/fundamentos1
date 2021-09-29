package com.fundamentos1.fundamentos1.entity;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "phone"
)
public class Phone {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id_phone",
            nullable = false,
            unique = true
    )
    private int id;
    @Column(
            length = 50
    )
    private String number;
    @Column(
            length = 50
    )
    private String cityCode;
    @Column(
            length = 50
    )
    private String countryCode;
    @ManyToOne()
    private User user;




    public Phone() {
    }

    public Phone( String number, String cityCode, String countryCode) {

        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }




    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
