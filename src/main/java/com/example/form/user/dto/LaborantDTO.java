package com.example.form.user.dto;

import com.example.form.user.Laborant;


public class LaborantDTO {

    long id;

    String isim;

    String labKimlik;
    public LaborantDTO (Laborant laborant){
        setId(laborant.getId());
        setIsim(laborant.getIsim());
        setLabKimlik(laborant.getLabKimlik());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getLabKimlik() {
        return labKimlik;
    }

    public void setLabKimlik(String labKimlik) {
        this.labKimlik = labKimlik;
    }

}
