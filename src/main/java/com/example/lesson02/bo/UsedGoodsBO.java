package com.example.lesson02.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;

@Service	// spring bean
public class UsedGoodsBO {
	
	// input(컨트롤러로부터 요청 받음): 아무런것도 주지않음 x
	// output(컨트롤러한테 돌려줌): List<UsedGoods>
	
	public List<UsedGoods> getUsedGoodsList () {
		
	}
	
}
