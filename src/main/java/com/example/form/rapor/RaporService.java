package com.example.form.rapor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
        inDb.setHastaTani(raporUpdate.hastaTani());
        inDb.setTaniDetay(raporUpdate.taniDetay());
        inDb.setSelectedDate(raporUpdate.selectedDate());
        if (raporUpdate.selectedFile() != null && !raporUpdate.selectedFile().isEmpty()) {
            String fileName = fileService.saveBase64StringAsFile(raporUpdate.selectedFile());
            fileService.deleteImage(inDb.getSelectedFile());
            inDb.setSelectedFile(fileName); // Yeni resmin yolu ile güncelle
        }

        return raporRepository.save(inDb); // Güncellenmiş raporu kaydet
    
    }

    public void deleteRapor(long id) {
        raporRepository.deleteById(id);
    }

    public Page<Rapor> searchRaporlar(String hastaIsim, String hastaKimlik, Pageable page) {
        Specification<Rapor> spec = Specification.where(null);

        if (StringUtils.hasText(hastaIsim)) {
            spec = spec.and((root, query, builder) -> builder.like(root.get("hastaIsim"), "%" + hastaIsim + "%"));
        }

        if (StringUtils.hasText(hastaKimlik)) {
            spec = spec.and((root, query, builder) -> builder.like(root.get("hastaKimlik"), "%" + hastaKimlik + "%"));
        }

        return raporRepository.findAll(spec, page);
    }

    public Page<Rapor> getRaporsSortedByDate(Pageable page) {

        return raporRepository.findAllByOrderBySelectedDateAsc(page);

    }

}
