package co.com.bvc.nuam.service;

import co.com.bvc.nuam.persistence.entity.User;

import java.util.ArrayList;
import java.util.Optional;

public interface UserService {
    ArrayList<User> findAll();

    Optional<User> findById(Long id);

    User UpdateById(User user) throws Exception;

    void deteteById(Long id) throws Exception;

    User save(User ciudad) throws Exception;
}
