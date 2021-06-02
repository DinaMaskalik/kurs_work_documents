package it.academy.dao.interfaces;

import it.academy.entity.Document;
import it.academy.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, String> {
    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    List<User> findAllBy(Pageable pageable);
}
