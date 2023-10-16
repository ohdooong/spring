package com.example.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private UserBO userBO;
	
	// =====================  ex01 ==========================
	// 회원 정보 추가 화면 http://localhost/lesson06/ex01/add-user-view
	
	@GetMapping("/ex01/add-user-view")
	public String addUserView () {
		return "lesson06/addUser";
	}
	
	// 회원추가 기능 -- AJAX가 하는 요청 => 응답 값은 String이어야 한다.  :::::::::::::   AJAX의 끝은 항상 String이 return값으로 반환되고 끝난다.
	@PostMapping("/ex01/add-user")                    // Controller    => @ResponseBody반드시 있어야 함.
	@ResponseBody                                        
	public String addUser (
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// db insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "성공";
	}
	
	// 결과 페이지
	@GetMapping("/ex01/get-latest-user")
	public String getLatestUser(Model model) {
		
		User user = userBO.getLatestUser();
		model.addAttribute("user", user);
		
		return "lesson06/getLatestUser";
	}
	
	
	
	
	// ===================== ex01 끝 =========================
	
	
}
