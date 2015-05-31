package scfw.service.model;


public class FoodSrModel {
	private UserSrModel user;
	private String [] foodIds;
	
	public String[] getFoodIds() {
		return foodIds;
	}
	public void setFoodIds(String[] foodIds) {
		this.foodIds = foodIds;
	}
	public UserSrModel getUser() {
		return user;
	}
	public void setUser(UserSrModel user) {
		this.user = user;
	}
	
}
