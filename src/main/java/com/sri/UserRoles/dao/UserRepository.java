package com.sri.UserRoles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sri.UserRoles.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
