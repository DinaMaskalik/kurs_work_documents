package it.academy.service;

import it.academy.dao.interfaces.RoleDao;
import it.academy.dao.interfaces.UserDao;
import it.academy.entity.Document;
import it.academy.entity.Role;
import it.academy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @PersistenceContext
//    private EntityManager em;
    @Autowired
    UserDao userDao;

    @Autowired
    RoleDao roleDao;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }

    public User findUserById(String userId) {
        Optional<User> userFromDb = userDao.findById(userId);
        return userFromDb.orElse(new User());
    }

    public String getRole(User user){
        final User username = userDao.findByUsername(user.getUsername());
        if(username==null){
            return "";
        }

        if(username.getPassword().equals(user.getPassword())){
            return username.getRoles().get(0).getName();
        }
        return "";
    }

    public List<User> allUsers() {
        return userDao.findAll();
    }

    public boolean saveUser(User user) {
        User userFromDB = userDao.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(List.of(new Role("1", "ROLE_USER")));
        user.setPassword(user.getPassword());
//        user.setPassword((user.getPassword()));
        userDao.save(user);
        return true;
    }

    public boolean deleteUser(String userId) {
        if (userDao.findById(userId).isPresent()) {
            userDao.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<User> getAllAccount(String pageNumber, int countInPage) {
        Pageable pageable = PageRequest.of(
                Integer.parseInt(pageNumber) - 1,
                countInPage
        );
        return userDao.findAllBy(pageable);
    }

    public int getNumberOfPage(int countInPage) {
        long allDocumentCount = userDao.count();

        if (allDocumentCount % countInPage == 0) {
            return (int) Math.floor(allDocumentCount / countInPage);
        } else {
            return (int) (Math.floor(allDocumentCount / countInPage) + 1);
        }
    }

//    public List<User> usergtList(Long idMin) {
//        return em.createQuery("SELECT u FROM User u WHERE u.userId > :paramId", User.class)
//                .setParameter("paramId", idMin).getResultList();
//    }
}
