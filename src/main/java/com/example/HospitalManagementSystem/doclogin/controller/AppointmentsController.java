package com.example.HospitalManagementSystem.doclogin.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.doclogin.entity.Appointments;
import com.example.HospitalManagementSystem.doclogin.repository.AppointmentsRepository;

@RestController
@RequestMapping("/api/v2")
public class AppointmentsController {
	
	private AppointmentsRepository appointmentsRepository;

	public AppointmentsController(AppointmentsRepository appointmentsRepository) {
		super();
		this.appointmentsRepository = appointmentsRepository;
	}

	
	@PostMapping("/insert")
	public Appointments createAppointment(@RequestBody Appointments appointment) {
		return appointmentsRepository.save(appointment);
	}
	
	@GetMapping
	public List<Appointments> getAllAppointments(){
		return appointmentsRepository.findAll();
	}

}
