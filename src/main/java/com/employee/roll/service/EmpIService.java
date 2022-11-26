package com.employee.roll.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.employee.roll.dto.EmployDto;
import com.employee.roll.model.EmpModel;

@Service
public interface EmpIService {
	
	String addEmploy(EmpModel employ);

	Optional<EmpModel> getid(int empid);

	Optional<EmpModel> getname(String name);

	

	Optional<EmpModel> delete(int empid);

	EmpModel update(EmpModel emp, String name);

	EmpModel update(EmpModel emp, int empid);

	EmpModel register(EmpModel employ);

	EmpModel save(EmpModel employ);

	List<EmpModel> getAllemploy();

}
