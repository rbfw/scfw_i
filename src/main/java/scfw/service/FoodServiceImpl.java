package scfw.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scfw.dao.FoodMapper;
import scfw.dao.OrderItemMapper;
import scfw.model.Food;
import scfw.model.OrderItem;
import scfw.service.model.FoodSrModel;
import scfw.service.model.UserSrModel;

@Service("foodService")
public class FoodServiceImpl implements FoodServiceI {
	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private OrderItemMapper itemMapper;

	@Override
	public Food getFoodById(int id) {
		return foodMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Food> queryFoods() {
		return foodMapper.queryFoods();
	}
	@Override
	public List<Food> todayOrderItems(int userId) {
		return foodMapper.todayOrderItems(userId);
	}

	@Override
	public int submitFood(FoodSrModel srModel) {
		return foodMapper.insert(null);
	}
	
	@Override
	public int submitFoodOrder(FoodSrModel srModel) {
		
		for (String foodId : srModel.getFoodIds()) {
			
			OrderItem item = new OrderItem();
			UserSrModel user = srModel.getUser();
			item.setUserId(user.getId());
			item.setUserName(user.getUserName());
			Food f = foodMapper.selectByPrimaryKey(Integer.parseInt(foodId));
			
			item.setFoodNumber(1);//先默认为1
			
			item.setFoodName(f.getFoodName());
			item.setFoodPrice(f.getFoodPrice());
			item.setFoodId(Integer.parseInt(foodId));
			item.setIsDelete("0");
			item.setCreateDate(new Date());
			itemMapper.insert(item);
		}
		return srModel.getFoodIds().length;
	}

	@Override
	public FoodSrModel editFood(int id) {
		return null;
	}

	@Override
	public int deleteFoodById(int id) {
		return 0;
	}
	
		
}
