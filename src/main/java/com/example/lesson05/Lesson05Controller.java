package com.example.lesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// List<Map<String, Object>>
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> user = new HashMap<>();
		
		user.put("name", "오리궁둥이");
		user.put("age", 17);
		user.put("hobby", "책읽기");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "복숭아");
		user.put("age", 24);
		user.put("hobby", "영화보기");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "포도");
		user.put("age", 97);
		user.put("hobby", "거북");
		list.add(user);
		
		user = new HashMap<>();
		user.put("name", "사과");
		user.put("age", 35);
		user.put("hobby", "멍때리기");
		list.add(user);
		
		model.addAttribute("users", list);
		
		return "lesson05/ex02";
	}
	
	
	
}
