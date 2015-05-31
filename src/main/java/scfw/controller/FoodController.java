package scfw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import scfw.model.Food;
import scfw.model.SysUser;
import scfw.model.SysValSet;
import scfw.model.comm.JsonBean;
import scfw.model.comm.CT;
import scfw.service.FoodServiceI;
import scfw.service.UserServiceI;
import scfw.service.ValSetServiceI;
import scfw.service.model.FoodSrModel;
import scfw.service.model.UserSrModel;

@Controller
@RequestMapping("/foodController")
public class FoodController {
	@Autowired
	private FoodServiceI foodService;
	/**
	 * 查询菜单列表
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/queryFoods")
	public String queryFoods(HttpServletRequest req){
		
		List<Food> list = foodService.queryFoods();
		
		req.setAttribute("foods", list);
		
		return "food/queryFoods";
	}
	/**
	 * 查询当前用户今日已点菜单列表
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/todayOrderItems")
	public String todayOrderItems(HttpServletRequest req){
		
		UserSrModel user = (UserSrModel) req.getSession().getAttribute("user");
		if(null != user){
			List<Food> list = foodService.todayOrderItems(user.getId());
			req.setAttribute("foods", list);
			return "food/todayOrderItems";
		}else{
			return "user/login";
		}
		
	}
	/**
	 *点餐
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/submitFoods")
	@ResponseBody
	public JsonBean submitFoods(HttpServletRequest req){
		JsonBean json = new JsonBean();
		try {
			FoodSrModel srModel = new FoodSrModel();
			UserSrModel user = (UserSrModel) req.getSession().getAttribute("user");
			srModel.setUser(user);
			String [] foodIds = req.getParameterValues("foodIds");
			srModel.setFoodIds(foodIds);
			if(null != user){
				foodService.submitFoodOrder(srModel);
				json.setIsSuccess(CT.SUCCESS);
			}else{
				json.setIsSuccess(CT.FAIL);
				json.setMsgInfo("请先登录系统");
			}
		} catch (Exception e) {
			json.setIsSuccess(CT.FAIL);
			json.setMsgInfo(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
}
