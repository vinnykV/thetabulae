package com.tabula.drugs.repository;

import com.tabula.drugs.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladyslav_Vinnyk on 1/19/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
