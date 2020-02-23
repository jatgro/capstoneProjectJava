package com.capstone.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.project.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByName(String name);

	Student findById(long id);

}
