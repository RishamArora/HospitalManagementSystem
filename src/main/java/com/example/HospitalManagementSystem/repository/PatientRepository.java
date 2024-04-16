package com.example.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalManagementSystem.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
