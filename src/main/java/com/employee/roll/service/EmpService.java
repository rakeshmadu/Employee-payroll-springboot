package com.employee.roll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.roll.repository.EmpRepository;
import com.employee.roll.dto.EmployDto;
import com.employee.roll.exception.UserException;
import com.employee.roll.model.EmpModel;

@Service
public class EmpService implements EmpIService {
	@Autowired
	EmpRepository empRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public String addEmploy(EmpModel employ) {

		empRepo.save(employ);
		return "emp added ";
	}

	@Override
	public Optional<EmpModel> getid(int empid) {
		Optional<EmpModel> getempid = empRepo.findById(empid);
		if (getempid.isEmpty()) {
			throw new UserException("emp doesn't exist");
		} else

			return getempid;
	}

	@Override
	public Optional<EmpModel> getname(String name) {

		Optional<EmpModel> getempName = empRepo.findByName(name);
		if (getempName.isEmpty()) {
			throw new UserException("User doesn't exist");
		} else
			return getempName;
	}

	@Override
	public Optional<EmpModel> delete(int empid) {

		Optional<EmpModel> empModel = empRepo.findById(empid);
		if (EmpModel.isEmpty()) {
			throw new UserException("Employee doesn't exist");
		} else
			empRepo.deleteById(empid);
		return empModel;

	}

	@Override
	public EmpModel update(EmpModel emp, String name) {
		emp.setEmpid(empRepo.findByName(name).get().getEmpid());
		return empRepo.save(emp);
	}

	@Override
	public EmpModel update(EmpModel emp, int empid) {
		emp.setEmpid(empid);
		return empRepo.save(emp);
	}

	@Override
	public EmpModel register(EmpModel name) {

		Optional<EmpModel> empModel = empRepo.findByName(name.getName());
		if (empModel.isPresent()) {
			throw new UserException("employee already exists");
		}
		EmpModel registeredEmploy = modelMapper.map(name, EmpModel.class);
		empRepo.save(registeredEmploy);
		System.out.println("Successfully registered");
		return name;

	}

	@Override
	public EmpModel save(EmpModel employ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpModel> getAllemploy() {

		List<EmpModel> employ = new ArrayList<EmpModel>();
		empRepo.findAll().forEach(emp1 -> employ.add(emp1));
		return employ;
	}
}
