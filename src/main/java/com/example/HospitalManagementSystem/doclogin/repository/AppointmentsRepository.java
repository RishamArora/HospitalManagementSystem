package com.example.HospitalManagementSystem.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HospitalManagementSystem.doclogin.entity.Appointments;


@Repository
public interface AppointmentsRepository  extends JpaRepository<Appointments, Long>{

}
