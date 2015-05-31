package scfw.dao;

import java.util.List;

import scfw.model.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

	List<Food> queryFoods();

	List<Food> todayOrderItems(int userId);
}