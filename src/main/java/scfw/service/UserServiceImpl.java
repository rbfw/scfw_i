package scfw.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import scfw.dao.SysRoleMapper;
import scfw.dao.SysUserMapper;
import scfw.model.SysRole;
import scfw.model.SysUser;
import scfw.model.SysValSet;
import scfw.model.comm.CT;
import scfw.service.model.UserSrModel;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private ValSetServiceI valSetService;
	
	@Override
	public SysUser getUserById(int id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<SysUser> querySysUser() {
		return sysUserMapper.querySysUser();
	}
	/**
	 * 初始化添加用户页面
	 */
	@Override
	public UserSrModel addUser(){
		//返回数据对象
		UserSrModel srModel = new UserSrModel();
		//加载角色--linked这个有序
		Map<Integer, String> roleMap = new LinkedHashMap<>();
		List<SysRole> roleList = roleMapper.queryRoles();
		for (SysRole item : roleList) {
			roleMap.put(item.getId(), item.getRoleName());
		}
		srModel.setRoleList(roleMap);

		//加载最喜爱的运动球类
		Map<Integer, String> ballMap = new HashMap<Integer, String>();
		//第一种方式，通过map封装 缺点-无序
		ballMap = valSetService.queryValSetMap("ball");
		srModel.setBallMap(ballMap);
		//第二种方式，通过list封装
		List<SysValSet> svss = valSetService.queryValSetList("ball");
		srModel.setSvss(svss);

		Map<Integer, String> areaList = new HashMap<Integer, String>();
		areaList = valSetService.queryValSetMap("province");
		srModel.setAreaList(areaList);
		
		//给表单元素赋默认值--begin
		srModel.setUserName("zhangsan");
		srModel.setNickName("张三");
		srModel.setSex(1);
		srModel.setMyBanlance(0.0);
		srModel.setFavoriteBall(1);
		srModel.setWorkarea("1");
		List<Integer> roles = new ArrayList<>();
		roles.add(1);
		srModel.setRoles(roles);
		//给表单元素赋默认值--end
		return srModel;
	}
	/**
	 * 初始化编辑用户页面
	 */
	@Override
	public UserSrModel editUser(int id){
		//返回数据对象
		UserSrModel srModel = new UserSrModel();
		//加载角色--linked这个有序
		Map<Integer, String> roleMap = new LinkedHashMap<>();
		List<SysRole> roleList = roleMapper.queryRoles();
		for (SysRole item : roleList) {
			roleMap.put(item.getId(), item.getRoleName());
		}
		srModel.setRoleList(roleMap);
		//加载最喜爱的运动球类
		Map<Integer, String> ballMap = new HashMap<Integer, String>();
		//第一种方式，通过map封装 缺点-无序
		ballMap = valSetService.queryValSetMap("ball");
		srModel.setBallMap(ballMap);
		//第二种方式，通过list封装
		List<SysValSet> svss = valSetService.queryValSetList("ball");
		srModel.setSvss(svss);
		
		Map<Integer, String> areaList = new HashMap<Integer, String>();
		areaList = valSetService.queryValSetMap("province");
		srModel.setAreaList(areaList);
		
		//给表单元素赋默认值--begin
		SysUser su = sysUserMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(su, srModel);
		
		List<Integer> roles = new ArrayList<>();
		String powers = su.getPower().substring(1, su.getPower().length()-1);
		if(powers.contains("|")){
		String [] power = StringUtils.split(powers, "|");
		for (String p : power) {
			if(!StringUtils.isEmpty(p)){
				roles.add(Integer.parseInt(p));
			}
		}}else{
			roles.add(Integer.parseInt(powers));
		}
		srModel.setRoles(roles);
		//给表单元素赋默认值--end
		return srModel;
	}

	@Override
	public int submitUser(UserSrModel srModel) {
		SysUser record = new SysUser();
		BeanUtils.copyProperties(srModel, record);
		
		record.setIsDisable(CT.NO);
		
		/*record.setUserPwd(srModel.getPasswd());*/
		
		String power = "|";
		for (Integer role : srModel.getRoles()) {
			power+=role+"|";
		}
		record.setPower(power);
		record.setTrueName(srModel.getNickName());
		if(0>= srModel.getId()){
			if(null == record.getUserPwd() || "".equals(record.getUserPwd())){record.setUserPwd("1234");}
			record.setPwdType("1");
			record.setCreateDate(new Date());
			sysUserMapper.insert(record);
		}else{
			Date d = CT.CURRENT_DATE;
			record.setUpdateDate(new Date());
			sysUserMapper.updateByPrimaryKeySelective(record);
		}
		//未完待续……
		int id = record.getId();
		return id;
	}

	/**
	 * 根据id删除用户
	 */
	@Override
	public int deleteUserById(int id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public UserSrModel loginUser(UserSrModel loginForm) {
		SysUser su = sysUserMapper.getUserByName(loginForm.getUserName());
		if(su != null && su.getUserPwd().equals(loginForm.getUserPwd())){
			BeanUtils.copyProperties(su, loginForm);
			return loginForm;
		}else{
			return null;
		}
	}
	
}
