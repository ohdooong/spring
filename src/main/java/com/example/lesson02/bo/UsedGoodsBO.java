package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service	// spring bean
public class UsedGoodsBO {
	
	@Autowired // spring bean(객체) 가져오는 것 - DI(Dependency Injection) : 의존성 주입
	private UsedGoodsMapper usedGoodsMapper;
	
	// input(컨트롤러로부터 요청 받음): 아무런것도 주지않음 x
	// output(컨트롤러한테 돌려줌): List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList () {
		return usedGoodsMapper.selectUsedGoodsList();
	}
	
}
