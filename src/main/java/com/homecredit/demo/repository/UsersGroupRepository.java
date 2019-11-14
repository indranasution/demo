package com.homecredit.demo.repository;

import com.homecredit.demo.entity.UsersGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersGroupRepository extends JpaRepository<UsersGroup,Integer> {
    Optional<UsersGroup> findByUserType(String userType);
}
