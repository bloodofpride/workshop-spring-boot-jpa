package com.educandoweb.workshop.services;

import com.educandoweb.workshop.entities.User;
import com.educandoweb.workshop.repositories.UserRepository;
import com.educandoweb.workshop.services.exceptions.DatabaseException;
import com.educandoweb.workshop.services.exceptions.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        try {
            userRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User newUser){
        User user = findById(id);
        updateData(user,newUser);
        return userRepository.save(user);
    }

    private void updateData(User user, User newUser){
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setName(newUser.getName());
        user.setPhone(newUser.getPhone());
    }
}
