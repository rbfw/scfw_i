package scfw.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import scfw.model.SysUser;
import scfw.service.UserServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class TestMybatis {
	
	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
	final String dateFomat = "yyyy年MM月dd日 HH:mm:ss";
	
	/*@Qualifier("userService")*/
	@Autowired
	UserServiceI userService;
	
	/*ApplicationContext ac = null;
	
	@Before
	public void before(){
		ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-mybatis.xml"});
		userService = (UserServiceI) ac.getBean("userService");
	}*/
	
	@Test
	public void test1(){
		SysUser su = userService.getUserById(1);
		//System.out.println("=====>"+su.getUserName());
		logger.info("=====>"+JSON.toJSONString(su));
		logger.info("=====>"+JSON.toJSONStringWithDateFormat(su,dateFomat));
	}

	@Test
	public void test2(){
		List<SysUser> sus = userService.querySysUser();
		logger.info("=====>"+JSON.toJSONStringWithDateFormat(sus,dateFomat));
	
	}
}
