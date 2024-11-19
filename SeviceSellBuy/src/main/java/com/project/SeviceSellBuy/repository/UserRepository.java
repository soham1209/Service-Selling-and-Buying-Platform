package com.project.SeviceSellBuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SeviceSellBuy.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	User findFirstByEmail(String email);

}
