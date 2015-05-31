package scfw.service;

import java.util.List;

import scfw.model.Food;
import scfw.service.model.FoodSrModel;

public interface FoodServiceI {
	
	
	public Food getFoodById(int id);
	
	public List<Food> queryFoods();

	public List<Food> todayOrderItems(int userId);
	
	public int submitFood(FoodSrModel srModel);
	
	public int submitFoodOrder(FoodSrModel srModel);

	public FoodSrModel editFood(int id);

	public int deleteFoodById(int id);
	
}
