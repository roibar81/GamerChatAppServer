package com.hit.service;

import com.hit.Password_utils.Password_utils;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;

public class SignInService {
    
    private DbHandle dbHandle;
    private Password_utils password_utils;
    
    public SignInService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.password_utils = Password_utils.getInstance();
    }

    public boolean sign_in() {
        
        return true;
    }

}
