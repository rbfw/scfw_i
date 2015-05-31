package scfw.service;

import java.util.List;

import scfw.model.SysUser;
import scfw.service.model.UserSrModel;

public interface UserServiceI {
	
	public UserSrModel addUser();
	
	public SysUser getUserById(int id);
	
	public List<SysUser> querySysUser();

	public int submitUser(UserSrModel srModel);

	public UserSrModel editUser(int id);

	public int deleteUserById(int id);

	public UserSrModel loginUser(UserSrModel loginForm);
	
}
