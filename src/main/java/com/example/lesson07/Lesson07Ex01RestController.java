package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {
	
	@Autowired
	private StudentBO studentBO;
	
	// C U D
		
	// C : Create, Insert
	@GetMapping("/1")
	public StudentEntity create() {
		
		String name = "오승환";
		String phoneNumber = "010-8845-1235";
		String email = "dijvsl@naver.com";
		String dreamJob = "프로그래머";
		
		// 지금 들어간 id 값도 바로 꺼낼 수 있다. getId();
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
	}
	
	// 강의 34분까지봄
	
}
