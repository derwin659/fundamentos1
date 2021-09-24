package com.fundamentos1.fundamentos1.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(
        name = "user"
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id_user",
            nullable = false,
            unique = true
    )
    private UUID id;

    @Column(
            length = 50
    )
    private String name;


    @Column(
            length = 50,
            unique = true
    )
    private String email;

    @Column(
            length = 50
    )
    private String password;
    @OneToMany(
            mappedBy = "user",
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER
    )
    private List<Phone> phones = new ArrayList();
    @Column(
            length = 50
    )
    private LocalDateTime created;
    @Column(
            length = 50
    )
    private LocalDateTime modified;
    @Column(
            length = 50
    )
    private LocalDateTime last_login;
    @Column(
            length = 50
    )
    private UUID token;
    @Column(
            length = 50
    )
    private Boolean isActive;

    public User() {
    }

    public User(UUID id, String name, String email, String password, List<Phone> phones, LocalDateTime created, LocalDateTime modified, LocalDateTime last_login, UUID token, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.isActive = isActive;
    }

    public User(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return this.modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLast_login() {
        return this.last_login;
    }

    public void setLast_login(LocalDateTime last_login) {
        this.last_login = last_login;
    }

    public UUID getToken() {
        return this.token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Boolean getActive() {
        return this.isActive;
    }

    public void setActive(Boolean active) {
        this.isActive = active;
    }
}
