package com.leucine.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.leucine.entity.Faculty;
import com.leucine.repo.FacultyRepo;

@Service
public class FacultyService implements FacultyRepo {
	@Autowired
    private FacultyRepo facultyRepository;

    public List<Faculty> findByDepartmentName(String departmentName) {
        return facultyRepository.findByDepartment_Name(departmentName);
    }
    public Faculty findFacultyById(int id) {
    	return facultyRepository.findById(id).get();
    }
    
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends Faculty> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInBatch(Iterable<Faculty> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Faculty getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Faculty getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Faculty getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Faculty> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Faculty> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> S save(S entity) {
		// TODO Auto-generated method stub
		return facultyRepository.save(entity);
	}
	@Override
	public Optional<Faculty> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Faculty entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends Faculty> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Faculty> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<Faculty> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public <S extends Faculty> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends Faculty> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends Faculty> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <S extends Faculty, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Faculty> findByDepartment_Name(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Faculty findByUserId(int userId) {
		// TODO Auto-generated method stub
        return facultyRepository.findByUserId(userId); // Create this method if necessary
	}
	
}
