package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;
import com.progamming.ShopmeCommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
