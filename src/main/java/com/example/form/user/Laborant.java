package com.example.form.user;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(name = "laborants", uniqueConstraints = @UniqueConstraint(columnNames = { "labKimlik" }))
public class Laborant {

    @Id
    @GeneratedValue
    long id;

    String isim;

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
