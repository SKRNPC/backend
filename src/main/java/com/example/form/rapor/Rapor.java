package com.example.form.rapor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "raporlar")
public class Rapor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raporlar_seq_gen")
    @SequenceGenerator(name = "raporlar_seq_gen", sequenceName = "RAPORLAR_SEQ", allocationSize = 1)
    long id;

    String selectedLaborant;
    String dosyaNo;

    String hastaIsim;

    String hastaKimlik;

    String hastaTani;
    String taniDetay;

    String selectedDate;

    String selectedFile;

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

    public String getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(String selectedDate) {
        this.selectedDate = selectedDate;
    }

    public String getSelectedLaborant() {
        return selectedLaborant;
    }

    public void setSelectedLaborant(String selectedLaborant) {
        this.selectedLaborant = selectedLaborant;
    }

}
