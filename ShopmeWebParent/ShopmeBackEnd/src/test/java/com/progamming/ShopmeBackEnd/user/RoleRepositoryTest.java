package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole() {
        Role role = new Role("Admin", "Admin Description");
        Role savedRole = roleRepository.save(role);
        Assertions.assertThat(savedRole.getName()).isEqualTo("Admin");
    }

    @Test
    public void testCreateRestRoles() {
        Role roleAdmin = new Role("Admin", "manage anything");
        Role roleSalesperson = new Role("Salesperson", "manage product price, customers, " +
                "shipping, orders, sales report");
        Role roleEditor = new Role("Editor", "manage categories, brands, products," +
                "articles and menus");
        Role roleShipper = new Role("Shipper", "view products, view orders and update order status");
        Role roleAssistant = new Role("Assistant", "manage questions and review products");
        List<Role> roleList = (List<Role>) roleRepository.saveAll(List.of(roleAdmin, roleSalesperson, roleEditor, roleShipper, roleAssistant));
        Assertions.assertThat(roleList.size()).isEqualTo(5);
    }
}
