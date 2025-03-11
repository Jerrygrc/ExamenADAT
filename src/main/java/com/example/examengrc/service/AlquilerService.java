package com.example.examengrc.service;

import com.example.examengrc.model.Alquiler;
import com.example.examengrc.model.Status;
import com.example.examengrc.repository.AlquilerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerRepository alquilerRepository;

    public AlquilerService(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    public Alquiler saveAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }
    public List<Alquiler> getAllAlquileres() {
        return alquilerRepository.findAll();
    }
    public Alquiler getAlquilerById(Long id) {
        return alquilerRepository.findById(id).orElse(null);
    }
    @Transactional
    public Alquiler updateAlquiler(Long id, Alquiler alquiler) {
        Alquiler alquilerToUpdate = alquilerRepository.findById(id).orElse(null);
        if (alquilerToUpdate == null) {
            return null;
        }

        if (alquiler.getReturnDate() != null) {
            alquilerToUpdate.setReturnDate(alquiler.getReturnDate());
            alquilerToUpdate.setStatus(Status.COMPLETED);
        }

        return alquilerRepository.save(alquilerToUpdate);
    }



}
