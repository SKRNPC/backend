package com.example.form.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Laborant, Long> {
    Laborant findByLabKimlik(String labKimlik );
}
