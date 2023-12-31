package com.example.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {
	
	@GetMapping("/ex01")
	public String ex01 () {
		return "lesson05/ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<String>
		List<String> fruits = List.of("apple","grape","orange","mango","strawberry");
		model.addAttribute("fruits", fruits);
		
		return "lesson05/ex02";
	}
	
	// URL : http://localhost/lesson05/ex03
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date today = new Date();
		model.addAttribute("today", today);
		
		return "lesson05/ex03";
	}
	
	// URL : http://localhost/lesson05/ex04
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
}
