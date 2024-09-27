package com.leucine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucine.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	Department findById(int departmentId);
	List<Department> findByName(String department);
}
