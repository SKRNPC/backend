package com.example.form.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class LaborantService {
    @Autowired
    UserRepository userRepository;

    public void save(Laborant laborant) {
        try{
            userRepository.save(laborant);
        }
        catch(DataIntegrityViolationException ex){
            throw new NotUniqueKimlikException();
        }
    }

}