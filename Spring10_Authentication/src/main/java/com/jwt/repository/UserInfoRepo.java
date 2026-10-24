package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entity.UserInfo;

public interface UserInfoRepo
        extends JpaRepository<UserInfo, Integer> {

    UserInfo findByName(String name);
}