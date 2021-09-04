package com.example.predavanjademo.services;

import com.example.predavanjademo.config.AdvanceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvanceService {

    private AdvanceConfiguration advanceConfiguration;

    @Autowired
    public void setAdvanceConfiguration(AdvanceConfiguration advanceConfiguration) {
        this.advanceConfiguration = advanceConfiguration;
    }

    public void getMeasurments() {
        isAuthorized(
                this.advanceConfiguration.getUsername(),
                this.advanceConfiguration.getPassword()
        );
    }

    public boolean isAuthorized(String username, String password) {
        return true;
    }

}
// SBC
// advanceConfiguration -> (STACK -> MEMORY)
    // HEAP
    // url -> https:...
    // port ->555
    // username ->dispecer
    // password ->dispecer