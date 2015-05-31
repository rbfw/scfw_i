package scfw.model;

import java.util.Date;

public class Food {
    private Integer id;

    private String foodName;

    private String foodImgPath;

    private String foodType;

    private String foodDetails;

    private String foodComment;

    private String isDelete;

    private Double foodPrice;

    private Integer totalCount;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public String getFoodImgPath() {
        return foodImgPath;
    }

    public void setFoodImgPath(String foodImgPath) {
        this.foodImgPath = foodImgPath == null ? null : foodImgPath.trim();
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType == null ? null : foodType.trim();
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails == null ? null : foodDetails.trim();
    }

    public String getFoodComment() {
        return foodComment;
    }

    public void setFoodComment(String foodComment) {
        this.foodComment = foodComment == null ? null : foodComment.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}