package com.spring.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Prescription;
import com.spring.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

	@Autowired
    private PrescriptionRepository repository;

    public List<Prescription> findByDateRange(LocalDate start, LocalDate end){
        return repository.findByPrescriptionDateBetween(start, end);
    }

    public Prescription save(Prescription p) { return repository.save(p); }

    public void delete(Long id) { repository.deleteById(id); }

    public List<Prescription> findAll() { return repository.findAll(); }
    
    
    //prescription report   
    public Map<String, Long> getPrescriptionCountByDate() {
        List<Object[]> results = repository.getPrescriptionCountByDate();
        Map<String, Long> report = new LinkedHashMap<>();
        for (Object[] row : results) {
            report.put(row[0].toString(), (Long) row[1]);
        }
        return report;
    }
    
}
