package com.example.lesson02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // jsp를 뿌릴 때는 @ResponseBody가 없는 @Controller
public class Lesson01Ex02Controller {
	
	// 요청 URL: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")
	public String ex02() {
		//jsp 경로 리턴
		//return "/WEB-INF/jsp/lesson01/ex02.jsp";
		// 	/WEB-INF/jsp/ 중간 경로.jsp
		return "lesson01/ex02";
	}
	
	
}
