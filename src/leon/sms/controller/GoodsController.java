package leon.sms.controller;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.javafx.collections.MappingChange.Map;

import leon.sms.pojo.Goods;
import leon.sms.service.GoodsService;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:24:27
* @version 1.0
* 类说明 :
* 
*/
@Controller
@RequestMapping("")
public class GoodsController
{
	@Autowired
	GoodsService goodsService;
	
	@RequestMapping("addGoods")
	public ModelAndView addGoods(@RequestParam("goodsName") String goodsName,
			@RequestParam("goodsNumber") String goodsNumber, @RequestParam("unitPrice") String unitPrice)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/others");
		
		goodsService.addGoods(goodsName,goodsNumber,unitPrice);
		return mav;
	}
	
	
	@RequestMapping("listGoods")
	public @ResponseBody ArrayList<HashMap<String, String>> list()
	{
		ArrayList<HashMap<String, String>> goodsList = new ArrayList<>();
		
		int count = 0;
		ArrayList<Goods> list = goodsService.list();
		for (Goods goods : list) { 
			++count;
			String name = goods.getName();
			HashMap<String, String> map = new HashMap<>();
			map.put("id", Integer.toString(count));
			map.put("name", name);
			goodsList.add(map);
		}
		

		return goodsList;
		
		
	}
}
