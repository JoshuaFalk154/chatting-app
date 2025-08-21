package com.chatapplication.chatapplication.userService.internals;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
public class UserEntity {

    public UserEntity(Long id, String sub, String email, String userName) {
        this.id = id;
        this.sub = sub;
        this.email = email;
        this.userName = userName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @Column(unique=true, nullable=false)
    String sub;

    @Column(unique=true, nullable=false)
    String email;

    @Column(unique=true, nullable=false)
    String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
