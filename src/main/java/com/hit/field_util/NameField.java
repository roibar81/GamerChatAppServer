package com.hit.field_util;

import com.hit.dm.User;

public class NameField implements UserField{

    @Override
    public String getUserField(User user) {
        return user.getName();
    }
    
}
