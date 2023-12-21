package com.example.form.rapor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.form.file.FileService;

@Service
public class RaporService {

    @Autowired
    RaporRepository raporRepository;
    @Autowired
    FileService fileService;

    public void save(Rapor rapor) {

        String fileName = fileService.saveBase64StringAsFile(rapor.getSelectedFile());
        rapor.setSelectedFile(fileName);
        raporRepository.save(rapor);

    }

    public Page<Rapor> getRapors(Pageable page) {
        return raporRepository.findAll(page);
    }

}
