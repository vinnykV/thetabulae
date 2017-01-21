package com.tabula.drugs.repository;

import com.tabula.drugs.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vladyslav_Vinnyk on 1/19/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
