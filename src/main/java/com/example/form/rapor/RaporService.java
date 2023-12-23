package com.example.form.rapor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.form.file.FileService;
import com.example.form.rapor.dto.RaporUpdate;

@Service
public class RaporService {

    @Autowired
    RaporRepository raporRepository;
    @Autowired
    FileService fileService;

    public void save(Rapor rapor) {
        if (rapor.getSelectedFile() != null && !rapor.getSelectedFile().isEmpty()) {
            // Base64 string'i dosyaya kaydet ve dosya adını al
            String fileName = fileService.saveBase64StringAsFile(rapor.getSelectedFile());
            rapor.setSelectedFile(fileName);
        }

        raporRepository.save(rapor);

    }

    public Page<Rapor> getRapors(Pageable page) {
        return raporRepository.findAll(page);
    }

    public Rapor getRapor(long id) {
        return raporRepository.getReferenceById(id);
    }

    public Rapor updateRapor(long id, RaporUpdate raporUpdate) {
        Rapor inDb = getRapor(id);
        inDb.setSelectedLaborant(raporUpdate.selectedLaborant());
        inDb.setDosyaNo(raporUpdate.dosyaNo());
        inDb.setHastaIsim(raporUpdate.hastaIsim());
        inDb.setHastaKimlik(raporUpdate.hastaKimlik());
        inDb.setHastaTani(raporUpdate.hastaTani());
        inDb.setTaniDetay(raporUpdate.taniDetay());
        inDb.setSelectedDate(raporUpdate.selectedDate());
        if (raporUpdate.selectedFile() != null) {
            String fileName=fileService.saveBase64StringAsFile(raporUpdate.selectedFile());
            inDb.setSelectedFile(fileName);
        }

        return raporRepository.save(inDb);
    }
}
