package com.example.form.rapor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RaporRepository extends JpaRepository<Rapor, Long>, JpaSpecificationExecutor<Rapor> {

    Page<Rapor> findAllByOrderBySelectedDateAsc(Pageable page);
}
