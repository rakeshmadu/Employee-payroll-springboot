package com.employee.roll.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.roll.model.EmpModel;
@Repository
public interface EmpRepository extends JpaRepository<EmpModel, Integer> {
	
	Optional<EmpModel> findById(int empid);

	Optional<EmpModel> findByName(String name);
}
