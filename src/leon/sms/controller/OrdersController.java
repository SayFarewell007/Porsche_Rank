package leon.sms.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import leon.sms.service.GoodsService;
import leon.sms.service.OrdersService;

/** 
* @author Leon
* @date 创建时间：2018年5月4日 上午10:24:27
* @version 1.0
* 类说明 :
* 
*/
@Controller
@RequestMapping("")
public class OrdersController
{
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping("testOrder")
	public @ResponseBody HashMap<String, String>  getOrders()
	{
		
		HashMap<String, String> map = new HashMap<>();
		map.put("test1", "VALUE1");
		return map;
		
	}
	
	@RequestMapping("addOrder")
	public ModelAndView addOrders(@RequestParam("name") String name,
								  /*@RequestParam("model") String model , */
								  @RequestParam("modelId") String modelId , 
								  @RequestParam("accessory") String accessory , 
								  @RequestParam("notAccessory") String notAccessory , 
								  @RequestParam("payMode") String payMode , 
								  /*@RequestParam("secondHandCarType") String secondHandCarType ,*/
								  @RequestParam("secondHandCarTypeId") String secondHandCarTypeId , 
								  /*@RequestParam("secondHandCarDetail") String secondHandCarDetail ,*/
								  @RequestParam("secondHandCarDetailId") String secondHandCarDetailId , 
								  @RequestParam("tranDate") String tranDate  
								   )
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/orders");
		
		ordersService.addOrder(name, modelId, modelId,  accessory, notAccessory, payMode, secondHandCarTypeId, secondHandCarTypeId, secondHandCarDetailId, secondHandCarDetailId, tranDate);
		return mav;
	}
	
	
	@RequestMapping("updateOrder")
	public String updateOrders(
								  @RequestParam("id") String id,
			                      @RequestParam("name") String name,
								  @RequestParam("model") String model , 
								 // @RequestParam("modelId") String modelId ,  
								  @RequestParam("accessory") String accessory , 
								  @RequestParam("notAccessory") String notAccessory , 
								  @RequestParam("payMode") String payMode , 
								  @RequestParam("secondHandCarType") String secondHandCarType ,
								  /*@RequestParam("secondHandCarTypeId") String secondHandCarTypeId , */
								  @RequestParam("secondHandCarDetail") String secondHandCarDetail ,
								  /*@RequestParam("secondHandCarDetailId") String secondHandCarDetailId , */
								  @RequestParam("tranDate") String tranDate  
								   )
	{
		System.out.println("id:" + id + "controller====" + "name:" + name + " model:" +model + "accessory:"+ accessory + "notAccessory:" + notAccessory + "payMode:" + payMode  +"secondHandCarType:" + secondHandCarType + "secondHandCarDetail:" + secondHandCarDetail + "tranDate:" + tranDate);
		ordersService.updateOrder(Integer.valueOf(id), name, model, model,  accessory, notAccessory, payMode, secondHandCarType, secondHandCarType, secondHandCarDetail, secondHandCarDetail, tranDate);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/ordersManage");
		
		//mav.addObject("list", ordersService.getAllOrders(null, null, null));
		//return mav;
		return "redirect:ordersManage?beginDate=&endDate=&name=";
	}
	
	@RequestMapping("ordersManage")
	public ModelAndView ordersManage(@RequestParam(value="beginDate",required=false) String beginDate,
									 @RequestParam(value="endDate",required=false) String endDate,
									 @RequestParam(value="name",required=false) String name
			)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home/mainFrame/ordersManage");
		mav.addObject("list", ordersService.getAllOrders(beginDate, endDate, name));
		return mav;
	}
	
	@RequestMapping("deleteOrder")
	public String delete(@RequestParam("id") int id){
		
		ordersService.delete(id);
		return "redirect:ordersManage?beginDate-&endDate=&name=";
	}
}
