package com.example.form.rapor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RaporService {

    @Autowired
    RaporRepository raporRepository;

    public void save(Rapor rapor) {
        raporRepository.save(rapor);
    }

    public Page<Rapor> getRapors(Pageable page) {
        return raporRepository.findAll(page);
    }

}
