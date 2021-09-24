package com.fundamentos1.fundamentos1.dto;

import java.time.LocalDate;
import java.util.UUID;

public class UserDto {
    private UUID id;
    private String created;
    private String modified;
    private String last_login;
    private UUID token;
    private Boolean is_Active;

    public UserDto(UUID id, String created, String modified, String last_login, UUID token, Boolean is_Active) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.last_login = last_login;
        this.token = token;
        this.is_Active = is_Active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Boolean getIs_Active() {
        return is_Active;
    }

    public void setIs_Active(Boolean is_Active) {
        this.is_Active = is_Active;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", last_login='" + last_login + '\'' +
                ", token=" + token +
                ", is_Active=" + is_Active +
                '}';
    }
}
