package com.example.form.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.form.user.dto.LaborantUpdate;

@Service
public class LaborantService {
    @Autowired
    UserRepository userRepository;

    public void save(Laborant laborant) {
        try {
            userRepository.save(laborant);
        } catch (DataIntegrityViolationException ex) {
            throw new NotUniqueKimlikException();
        }
    }

    public Page<Laborant> getLaborants(Pageable page) {
        return userRepository.findAll(page);
    }

    public Laborant getLaborant(long id) {
        return userRepository.getReferenceById(id);
    }

    public Laborant updateLaborant(long id, LaborantUpdate laborantUpdate) {
        Laborant inDb = getLaborant(id);
        if (laborantUpdate.isim() != null && !laborantUpdate.isim().equals(inDb.getIsim())) {
            inDb.setIsim(laborantUpdate.isim());
        }

        // Güncellenen labKimlik değeri null değilse ve eski değeriyle aynı değilse
        // güncelle
        if (!laborantUpdate.labKimlik().equals(inDb.getLabKimlik())) {
            inDb.setLabKimlik(laborantUpdate.labKimlik());
        }
        return userRepository.save(inDb);
    }

}