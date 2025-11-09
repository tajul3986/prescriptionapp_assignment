package com.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.spring.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

	List<Prescription> findByPrescriptionDateBetween(LocalDate start, LocalDate end);
	
	 @Query("SELECT p.prescriptionDate, COUNT(p) FROM Prescription p GROUP BY p.prescriptionDate ORDER BY p.prescriptionDate DESC")
	    List<Object[]> getPrescriptionCountByDate();
	    
}
