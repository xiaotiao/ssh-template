package com.wondersoft.ndlp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.wondersoft.ndlp.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {


    
    @RequestMapping(value = "/userLogin.do", method = RequestMethod.GET)
    @ResponseBody
    public String login(String username,String password){

        
        return "fail";
    }



    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestBody User user){

        System.out.println(user);

        return JSONObject.toJSONString(user);
    }
    
   
}
