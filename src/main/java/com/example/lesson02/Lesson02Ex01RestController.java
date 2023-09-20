package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController // @Controller + @ResponseBody
public class Lesson02Ex01RestController {
	
	// 시스템 분할 => 한 곳에 몰아서 만든 것보다 유지보수 용이함
	
	// 요청 URL: http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01 () {
		List<UsedGoods> usedGoodsList = ;
		
		return usedGoodsList; // json
	}
}
