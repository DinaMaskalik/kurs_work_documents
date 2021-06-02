package it.academy.dao.interfaces;

import it.academy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role, String> {

    Role findByName(String name);
}

