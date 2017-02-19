package com.wondersoft.ndlp.service;

import com.wondersoft.ndlp.base.service.IBaseService;
import com.wondersoft.ndlp.model.TUser;

public interface IUserService extends IBaseService{

    public boolean isExist(TUser user);
}
