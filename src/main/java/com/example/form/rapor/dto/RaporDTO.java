package com.example.form.rapor.dto;

import java.time.LocalDate;

import com.example.form.rapor.Rapor;

public class RaporDTO {

    long id;

    String selectedLaborant;

    

    String dosyaNo;

    String hastaIsim;

    String hastaKimlik;

    String hastaTani;

    String taniDetay;

    LocalDate selectedDate;

    String selectedFile;

    public RaporDTO(Rapor rapor) {
        setId(rapor.getId());
        setSelectedLaborant(rapor.getSelectedLaborant());
        setDosyaNo(rapor.getDosyaNo());
        setHastaIsim(rapor.getHastaIsim());
        setHastaKimlik(rapor.getHastaKimlik());
        setHastaTani(rapor.getHastaTani());
        setTaniDetay(rapor.getTaniDetay());
        setSelectedDate(rapor.getSelectedDate());
        setSelectedFile(rapor.getSelectedFile());
    

    }

    public String getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(String selectedFile) {
        this.selectedFile = selectedFile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHastaTani() {
        return hastaTani;
    }

    public void setHastaTani(String hastaTani) {
        this.hastaTani = hastaTani;
    }

    public String getTaniDetay() {
        return taniDetay;
    }

    public void setTaniDetay(String taniDetay) {
        this.taniDetay = taniDetay;
    }

    public String getHastaIsim() {
        return hastaIsim;
    }

    public void setHastaIsim(String hastaIsim) {
        this.hastaIsim = hastaIsim;
    }

    public String getDosyaNo() {
        return dosyaNo;
    }

    public void setDosyaNo(String dosyaNo) {
        this.dosyaNo = dosyaNo;
    }

    public String getHastaKimlik() {
        return hastaKimlik;
    }

    public void setHastaKimlik(String hastaKimlik) {
        this.hastaKimlik = hastaKimlik;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(LocalDate selectedDate) {
        this.selectedDate = selectedDate;
    }
    public String getSelectedLaborant() {
        return selectedLaborant;
    }

    public void setSelectedLaborant(String selectedLaborant) {
        this.selectedLaborant = selectedLaborant;
    }
}
