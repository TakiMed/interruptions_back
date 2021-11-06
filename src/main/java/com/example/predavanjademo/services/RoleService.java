package com.example.predavanjademo.services;

import com.example.predavanjademo.entities.Role;
import com.example.predavanjademo.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Transactional(readOnly = true)
    public List<Role> getAllRoles(){
        return this.roleRepository.findAll();
    }
}
