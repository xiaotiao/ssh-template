package com.wondersoft.ndlp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class TUser {

    private Integer id;
    private String username;
    private String password;

    @Id
    @Column(name = "c_id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "c_username", unique = true, nullable = false, length = 50)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "c_password",  nullable = false, length = 50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    @Override
    public String toString() {
        return "TUser [username=" + username + ", password=" + password + "]";
    }
    
    
    
}
