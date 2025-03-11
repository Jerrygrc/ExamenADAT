package com.example.examengrc.repository;

import com.example.examengrc.model.Alquiler;
import com.example.examengrc.model.Coche;
import com.example.examengrc.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

}
