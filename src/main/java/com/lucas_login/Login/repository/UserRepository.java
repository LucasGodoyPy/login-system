package com.lucas_login.Login.repository;

import com.lucas_login.Login.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CrudRepository <User, Long>{

    User findByUsername(String username);

}
