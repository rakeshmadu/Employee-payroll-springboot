package com.employee.roll.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.employee.roll.ResponseEntity;
import com.employee.roll.model.EmpModel;
import com.employee.roll.service.EmpIService;

@RestController

public class EmpController {
	@Autowired
	EmpIService empService;

	@DeleteMapping("/delete/{empid}")
	public Optional<EmpModel> deleteEmp(@PathVariable int empid) {
		Optional<EmpModel> empModel = empService.delete(empid);
		System.out.println("employee deleted");
		return empModel;
	}

	@GetMapping("/findid/{empid}")
	public Optional<EmpModel> getById(@PathVariable int empid) {
		System.out.println("id found :" + empid);
		Optional<EmpModel> searchId = empService.getid(empid);
		return searchId;
	}

	@PutMapping("/update/{empid}")
	public ResponseEntity updateUser(@RequestBody EmpModel emp, @PathVariable int empid) {
		EmpModel empUpdate = empService.update(emp, empid);
		return new ResponseEntity(empUpdate, "employee updated successfully");
	}

	@PostMapping("/register")
	public ResponseEntity registerEmploy(@RequestBody EmpModel employ) {
		EmpModel empSave = empService.register(employ);
		return new ResponseEntity(empSave, "Registered successfully");
	}

	@GetMapping("/getAll")
	public List<EmpModel> getAllEmploy() {

		return empService.getAllemploy();
	}
}
