package leon.sms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.sms.mapper.GoodsMapper;
import leon.sms.pojo.Goods;

/** 
* @author Leon
* @date ����ʱ�䣺2018��5��4�� ����10:28:31
* @version 1.0
* ��˵�� :
* 
*/
@Service
public class GoodsService
{
	@Autowired
	GoodsMapper goodsMapper;
	
	public void addGoods(String goodsName, String goodsNumber, String unitPrice)
	{
		Goods goods = new Goods(goodsName, Integer.parseInt(goodsNumber), Float.parseFloat(unitPrice));
		if (goodsMapper.get(goodsName) != null)
		{
			goodsMapper.update(goods);
		}
		else
		{
			goodsMapper.add(goods);
		}
	}
	
	public ArrayList<Goods> list()
	{
		ArrayList<Goods> list = goodsMapper.list();
		return list;
	}
	
}
