package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.domain.UsedGoods;

@RestController // @Controller + @ResponseBody
public class Lesson02Ex01RestController {
	
	// 시스템 분할 => 한 곳에 몰아서 만든 것보다 유지보수 용이함 => 오류가 어디서 발생했는지 한번에 확인가능함. => 에러발생시 에러 항상 확인
	
	@Autowired // DI(spring bean을 주입)
	private UsedGoodsBO usedGoodsBO;
	
	// 요청 URL: http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01 () {
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList; // json - response body
	}
}
