package com.leucine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucine.entity.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {
	List<Faculty> findByDepartment_Name(String departmentName);
	Faculty findByUserId(int userId);
}
