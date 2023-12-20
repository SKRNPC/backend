package com.example.form.rapor;

import com.example.form.user.Laborant;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "raporlar")
public class Rapor {
    @Id
    @GeneratedValue
    long id;

    @ManyToOne
    @JoinColumn(name = "laborant_id")
    private Laborant laborant;

    @Size(min = 5, max = 5)
    String dosyaNo;

    @NotBlank
    String hastaIsim;
    @Size(min = 11, max = 11)
    String hastaKimlik;

    @NotBlank
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

    // public Laborant getLaborant() {
    //     return laborant;
    // }

    // public void setLaborant(Laborant laborant) {
    //     this.laborant = laborant;
    // }
}
