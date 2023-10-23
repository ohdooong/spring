package com.example.lesson04.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {
	
	@Autowired
	private StudentMapper studentMapper;    // Mybatis는 mapper에 요청  => XML 쿼리
	
	@Autowired
	private StudentRepository studentRepository; // JPA => 메소드 호출
	
	// Mybatis
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	public Student getStudentById(int id) {
		return studentMapper.selectStudent(id);
	}
	
	
	
	// JPA
	// input : 			 			
	// output : StudentEntity 			 			
	public StudentEntity addStudent(
			String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(ZonedDateTime.now())  // @UpdateTimestamp 있으면 생략가능 :  요즘 트렌트 Zoned~ 혹은 LocalDateTime (우리나라에서만 사용할 경우) 
				.build();
		
		return studentRepository.save(student);
	}
	
}
