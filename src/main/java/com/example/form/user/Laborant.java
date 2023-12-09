package com.example.form.user;

import com.example.form.user.validation.UniqueKimlik;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "laborants", uniqueConstraints = @UniqueConstraint(columnNames = { "labKimlik" }))
public class Laborant {

    @Id
    @GeneratedValue
    long id;

    @NotBlank
    String isim;

    @NotBlank
    @Size(min = 7, max = 7)
    @UniqueKimlik
    String labKimlik;

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
