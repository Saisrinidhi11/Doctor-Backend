package com.mindtree.doctor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.doctor.exception.ResourceNotFoundException;
import com.mindtree.doctor.model.Doctor;
import com.mindtree.doctor.repository.DoctorRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	@PostMapping("/doctors")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorRepository.save(doctor);
	}
	//get doctor id rest API
		@GetMapping("/doctors/{id}")
		public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
			Doctor doctor=doctorRepository.findById(id).
			orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id:"+id));
			return ResponseEntity.ok(doctor);
		}	
		// update doctor rest API
				@PutMapping("/doctors/{id}")
				public ResponseEntity<Doctor> 
				updateDoctor(@PathVariable Long id,@RequestBody Doctor doctorDetails){
					
					Doctor doctor =doctorRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id:"+id));
					doctor.setname(doctorDetails.getname());
					doctor.setage(doctorDetails.getage());
					doctor.setgender(doctorDetails.getgender());
					doctor.setspecialistField(doctorDetails.getspecialistField());
					
					Doctor updatedDoctor=doctorRepository.save(doctor);
					return ResponseEntity.ok(updatedDoctor);
				}	
			
		//delete doctor rest API
				@DeleteMapping("/doctors/{id}")
				public ResponseEntity<Map<String,Boolean>> deleteDoctor(@PathVariable Long id){
					Doctor doctor=doctorRepository.findById(id)
							.orElseThrow(() -> new ResourceNotFoundException("Doctor not exist with id:"+id));
					
					doctorRepository.delete(doctor);
					Map<String,Boolean> response=new HashMap<>();
					response.put("deleted", Boolean.TRUE);
					return ResponseEntity.ok(response);
				}	
		}
