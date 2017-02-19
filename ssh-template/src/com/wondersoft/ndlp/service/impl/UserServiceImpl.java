package com.wondersoft.ndlp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersoft.ndlp.base.service.impl.BaseServiceImpl;
import com.wondersoft.ndlp.dao.IUserDao;
import com.wondersoft.ndlp.model.TUser;
import com.wondersoft.ndlp.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    
    @Override
    public boolean isExist(TUser user) {
        return false;
    }

}
