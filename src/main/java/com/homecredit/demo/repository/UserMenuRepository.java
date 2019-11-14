package com.homecredit.demo.repository;

import com.homecredit.demo.entity.UserMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMenuRepository extends JpaRepository<UserMenu,Integer> {
    Optional<UserMenu> findByUserId(Integer userId);
}
