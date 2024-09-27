package com.leucine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucine.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	Student findByUserId(int id);
}
