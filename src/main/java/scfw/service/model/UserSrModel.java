package scfw.service.model;

import java.util.List;
import java.util.Map;

import scfw.model.SysValSet;

public class UserSrModel {
	private Map<Integer, String> ballMap;
	private Map roleList;
	private Map<Integer, String> areaList;
	private List<SysValSet> svss;
	
	private int id;
	private String userName;
	private String nickName;
	private String userPwd;
	private Double myBanlance;
	private Integer sex;
	private String workarea;
	private Integer favoriteBall;
	private List<Integer> roles;
	
	
	public Map<Integer, String> getBallMap() {
		return ballMap;
	}
	public void setBallMap(Map<Integer, String> ballMap) {
		this.ballMap = ballMap;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Map getRoleList() {
		return roleList;
	}
	public void setRoleList(Map roleList) {
		this.roleList = roleList;
	}
	public Map<Integer, String> getAreaList() {
		return areaList;
	}
	public void setAreaList(Map<Integer, String> areaList) {
		this.areaList = areaList;
	}
	
	public Integer getFavoriteBall() {
		return favoriteBall;
	}
	public void setFavoriteBall(Integer favoriteBall) {
		this.favoriteBall = favoriteBall;
	}
	public List<Integer> getRoles() {
		return roles;
	}
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public List<SysValSet> getSvss() {
		return svss;
	}
	public void setSvss(List<SysValSet> svss) {
		this.svss = svss;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Double getMyBanlance() {
		return myBanlance;
	}
	public void setMyBanlance(Double myBanlance) {
		this.myBanlance = myBanlance;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getWorkarea() {
		return workarea;
	}
	public void setWorkarea(String workarea) {
		this.workarea = workarea;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
