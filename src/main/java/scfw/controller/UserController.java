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

import scfw.model.SysUser;
import scfw.model.SysValSet;
import scfw.model.comm.JsonBean;
import scfw.model.comm.CT;
import scfw.service.UserServiceI;
import scfw.service.ValSetServiceI;
import scfw.service.model.UserSrModel;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UserServiceI userSerive;
	@Autowired
	private ValSetServiceI valSetService;
	/**
	 * 根据id显示用户信息
	 * @param id
	 * @param req
	 * @return
	 */
	//http://localhost:8080/scfw/userController/a20be73568bd4bbe8d081e5d0fc99378/showUser.do
	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable int id,HttpServletRequest req){
		
		SysUser su = userSerive.getUserById(id);
		
		req.setAttribute("su", su);
		
		return "showUser";
	}
	/**
	 * 查询用户列表
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/queryUsers")
	public String queryUsers(HttpServletRequest req){
		
		List<SysUser> users = userSerive.querySysUser();
		
		req.setAttribute("users", users);
		
		return "queryUsers";
	}
	/**
	 * 进入添加用户
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/addUserOld")
	public String addUser(Map<String, Object> map){
		//返回数据对象
		UserSrModel srModel = new UserSrModel();
		//加载角色
		Map<Integer, String> roleList = new HashMap<Integer, String>();
		roleList.put(1, "项目经理");
		roleList.put(2, "部门经理");
		roleList.put(3, "归档管理员");
		roleList.put(4, "专家抽取员");
		roleList.put(5, "公司总经理");
		srModel.setRoleList(roleList);
		
		//加载最喜爱的运动球类
		Map<Integer, String> ballMap = new HashMap<Integer, String>();
		//第一种方式，通过map封装 缺点-无序
		ballMap = valSetService.queryValSetMap("ball");
		srModel.setBallMap(ballMap);
		//第二种方式，通过list封装
		List<SysValSet> svss = valSetService.queryValSetList("ball");
		srModel.setSvss(svss);
		
		/*LinkedHashMap<K, V>();*/
		
		Map<Integer, String> areaList = new HashMap<Integer, String>();
		/*areaList.put(0, "北京");
		  areaList.put(1, "上海");
		  areaList.put(2, "深圳");
		  areaList.put(3, "广州");
		  areaList.put(4, "其他");*/
		areaList = valSetService.queryValSetMap("province");
		srModel.setAreaList(areaList);
		
		//给表单元素赋默认值
		srModel.setUserName("zhangsan");
		srModel.setNickName("张三");
		//srModel.setPasswd("123456");
		srModel.setSex(1);
		srModel.setMyBanlance(0.0);
		srModel.setFavoriteBall(1);
		srModel.setWorkarea("1");
		List<Integer> roles = new ArrayList<>();
		roles.add(1);
		srModel.setRoles(roles);
		
		map.put("srModel", srModel);
		
		return "addUser";
	}
	/**
	 * 进入添加用户
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/addUser")
	public String addUserNew(Map<String, Object> map){
		
		UserSrModel srModel = userSerive.addUser();
		
		map.put("srModel", srModel);
		
		return "addUser";
	}
	/**
	 * 进入编辑用户
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/{id}/editUser")
	public String editUser(@PathVariable int id,Map<String, Object> map){
		
		UserSrModel srModel = userSerive.editUser(id);
		
		map.put("srModel", srModel);
		
		return "editUser";
	}
	/**
	 * 测试
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/testFtl")
	public String testFtl(Map<String, Object> map){
		
		map.put("username", "qiyang");
		
		return "testFtl";
	}
	/**
	 * 提交添加用户信息
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/submitUser")
	@ResponseBody
	public ModelAndView submitUser(@ModelAttribute("srModel")UserSrModel srModel,JsonBean json){
		try {
			int id = userSerive.submitUser(srModel);
			json.addObject("id", id);
			json.setIsSuccess(CT.SUCCESS);
			json.setMsgInfo(CT.SUCCESS_INFO);
		} catch (Exception e) {
			json.setIsSuccess(0);
			e.printStackTrace();
		}
		System.out.println(JSON.toJSON(srModel));
		return json;
	}
	/**
	 * 删除用户
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/{id}/deleteUser")
	@ResponseBody
	public JsonBean deleteUser(@PathVariable int id,JsonBean json){
		
		try {
			userSerive.deleteUserById(id);
			json.setIsSuccess(CT.SUCCESS);
		} catch (Exception e) {
			json.setIsSuccess(CT.FAIL);
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 进入用户登录页面
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/login")
	public String toLogin(HttpServletRequest req){
		return "user/login";
	}
	/**
	 * 用户提交登录信息
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/submitLogin")
	@ResponseBody
	public JsonBean submitLogin(@ModelAttribute("loginForm") UserSrModel loginForm,HttpServletRequest req){
		
		JsonBean json = new JsonBean();
		
		try {
			UserSrModel user = userSerive.loginUser(loginForm);
			if(null != user){
				json.setIsSuccess(CT.SUCCESS);
				req.getSession().setAttribute("user", user);
			}else{
				json.setIsSuccess(CT.FAIL);				
				json.setMsgInfo("用户名或密码错误！");
			}
		} catch (Exception e) {
			json.setIsSuccess(CT.FAIL);
			json.setMsgInfo(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 用户退出
	 * @param id
	 * @param req
	 * @return
	 */
	@RequestMapping("/loginOut")
	@ResponseBody
	public JsonBean loginOut(HttpServletRequest req){
		
		JsonBean json = new JsonBean();
		try {
			req.getSession().removeAttribute("user");
		} catch (Exception e) {
			json.setIsSuccess(CT.FAIL);
			json.setMsgInfo(e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
}
