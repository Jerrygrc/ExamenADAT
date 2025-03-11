package com.example.examengrc.service;

import com.example.examengrc.model.Coche;
import com.example.examengrc.repository.CocheRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheService {

    @Autowired
    private CocheRepository cocheRepository;

    public CocheService(CocheRepository cocheRepository) {
        this.cocheRepository = cocheRepository;
    }

    public Coche saveCoche(Coche coche) {
        return cocheRepository.save(coche);
    }

    public Coche getCocheById(Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    public List<Coche> getAllCoches() {
        return cocheRepository.findAll();
    }

    public void deleteCoche(Long id) {
        cocheRepository.deleteById(id);
    }

    @Transactional
    public Coche updateCoche(Long id, Coche coche) {
        Coche cocheToUpdate = cocheRepository.findById(id).orElse(null);
        if (cocheToUpdate == null) {
            return null;
        }
        cocheToUpdate.setBrand(coche.getBrand());
        cocheToUpdate.setModel(coche.getModel());
        cocheToUpdate.setYear(coche.getYear());
        cocheToUpdate.setRamallo_tiers(coche.getRamallo_tiers());
        cocheToUpdate.setPlateNumber(coche.getPlateNumber());
        cocheToUpdate.setAvailable(coche.getAvailable());
        return cocheToUpdate;
    }




}
