package com.wondersoft.ndlp.controller.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by zhuzhenghuan on 2017/7/12.
 */
public class User implements Serializable{

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {

        System.out.println(String.join(":","1","2"));
    }
}
