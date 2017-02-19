package com.wondersoft.ndlp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wondersoft.ndlp.model.TUser;
import com.wondersoft.ndlp.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @RequestMapping(value = "/userLogin.do", method = RequestMethod.GET)
    public String login(String username,String password){
        String hql = "from TUser where username=:name and password=:pwd";
        Map<String,Object> params = new HashMap<>();
        params.put("name", username);
        params.put("pwd", password);
       
        List<TUser> userList = userService.find(hql,params);
        if(userList !=null && userList.size()>0){
            return "welcome";
        }
        
        return "fail";
    }
    
   
}
