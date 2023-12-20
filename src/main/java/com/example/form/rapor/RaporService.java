package com.example.form.rapor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RaporService {

    @Autowired
    RaporRepository raporRepository;

    public void save(Rapor rapor) {
        raporRepository.save(rapor);
    }

    public List<Rapor> getRapors() {
        return raporRepository.findAll();
    }

}
