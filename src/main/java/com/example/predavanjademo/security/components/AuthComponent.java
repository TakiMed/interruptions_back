package com.example.predavanjademo.security.components;

import org.springframework.stereotype.Component;

@Component
public class AuthComponent {
    public boolean hasPermission(){
        return true;
    }

    public boolean hasPermissionWithArg(String key)
    {
        return key.equals("A12345") ? true : false;
    }
}
