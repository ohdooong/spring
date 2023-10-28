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
	
	// input: id, dreamJob			output:변경된 StudentEntity
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		StudentEntity student = studentRepository.findById(id).orElse(null);   // Optional 문법으로 기존 객체 가지고온다.
		if (student != null) {
			
			// 기존값은 유지하고 세팅된 일부의 값만 변경 => 내가 원하는 값만 변경한다. (dreamJob만 변경)
			// => toBuilder
			
			student = student.toBuilder()   // 기존값 유지
				.dreamJob(dreamJob)
				.build();
			
			// update
			studentRepository.save(student);	// db update 후 다시 select 된 결과!!!!!!!!
		}
		
		return student;	//    null 또는 변경된 데이터
	}
	
	
}
