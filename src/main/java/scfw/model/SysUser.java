package scfw.model;

import java.util.Date;

public class SysUser {
    private Integer id;

    private String isDisable;

    private String userName;

    private String userPwd;

    private String pwdType;

    private String nickName;

    private String trueName;

    private Double myBanlance;

    private String power;

    private Date createDate;

    private Date updateDate;

    private Integer sex;

    private Integer favoriteBall;

    private String workarea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(String isDisable) {
        this.isDisable = isDisable == null ? null : isDisable.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getPwdType() {
        return pwdType;
    }

    public void setPwdType(String pwdType) {
        this.pwdType = pwdType == null ? null : pwdType.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public Double getMyBanlance() {
        return myBanlance;
    }

    public void setMyBanlance(Double myBanlance) {
        this.myBanlance = myBanlance;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getFavoriteBall() {
		return favoriteBall;
	}

	public void setFavoriteBall(Integer favoriteBall) {
		this.favoriteBall = favoriteBall;
	}

	public String getWorkarea() {
        return workarea;
    }

    public void setWorkarea(String workarea) {
        this.workarea = workarea == null ? null : workarea.trim();
    }
}