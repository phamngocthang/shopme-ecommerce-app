package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;
import com.progamming.ShopmeCommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public User save(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        return userRepository.save(user);
    }
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    public boolean isEmailUnique(String email) {
        User user = userRepository.getUserByEmail(email);
        return user == null;
    }
}
