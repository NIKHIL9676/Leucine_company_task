package com.leucine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leucine.entity.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {

}
