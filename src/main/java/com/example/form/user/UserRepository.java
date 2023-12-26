package com.example.form.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Laborant, Long>, JpaSpecificationExecutor<Laborant>{
    Laborant findByLabKimlik(String labKimlik );
}
