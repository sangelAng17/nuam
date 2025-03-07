package co.com.bvc.nuam.service.impl;

import co.com.bvc.nuam.persistence.entity.User;
import co.com.bvc.nuam.persistence.repository.UserRepository;
import co.com.bvc.nuam.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class userServiceImpl implements UserService {

    private static Logger log = LogManager.getLogger(userServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArrayList<User>findAll(){
        return (ArrayList<User>) userRepository.findAll();
    }
    @Override
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override
    public User UpdateById(User user) throws Exception{
        try{
            userRepository.save(user);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return userRepository.findAllById(user.getId());
    }

    @Override
    public void deteteById(Long id) throws Exception{
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    @Override
    public User save(User user) throws Exception{
        try{
            userRepository.save(user);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return user;
    }

}
