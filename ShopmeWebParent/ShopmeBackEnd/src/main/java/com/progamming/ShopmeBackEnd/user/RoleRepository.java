package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
