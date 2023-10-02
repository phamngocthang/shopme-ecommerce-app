package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;
import com.progamming.ShopmeCommon.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void TestCreateUser() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("pntnoah1@gmail.com", "123456", "thang", "pham");
        user.addRole(roleAdmin);
        User savedUser = userRepository.save(user);
        Assertions.assertThat(savedUser.getId()).isGreaterThan(1);
    }
    @Test
    public void TestCreateUserWithTwoRole() {
        User user = new User("lehaidang@gmail.com", "123456", "Dang", "Le");
        Role roleAssistant = new Role(5);
        Role roleEditor = new Role(3);
        user.addRole(roleEditor);
        user.addRole(roleAssistant);
        User savedUser = userRepository.save(user);
        Assertions.assertThat(savedUser.getId()).isGreaterThan(1);
    }
    @Test
    public void TestGetAll() {
        List<User> userList = userRepository.findAll();
        Assertions.assertThat(userList.size()).isEqualTo(2);
    }
}
