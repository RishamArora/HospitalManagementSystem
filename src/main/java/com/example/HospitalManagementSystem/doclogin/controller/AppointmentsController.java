package com.example.HospitalManagementSystem.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HospitalManagementSystem.doclogin.entity.Appointments;
import com.example.HospitalManagementSystem.doclogin.repository.AppointmentsRepository;

@CrossOrigin(origins="*")
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
	
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
	Appointments appointments=	appointmentsRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With This ID"));
	appointmentsRepository.delete(appointments);
	Map<String, Boolean> response = new HashMap<String,Boolean>();
	response.put("Deleted", Boolean.TRUE);
	
	return ResponseEntity.ok(response);
	}

}
