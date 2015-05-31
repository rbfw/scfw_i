package scfw.service;

import java.util.List;
import java.util.Map;

import scfw.model.SysUser;
import scfw.model.SysValSet;

public interface ValSetServiceI {
	
	List<SysValSet> queryValSetList(String valSetCode);
	
	//Map<Integer, String> queryValSetMap(String valSetCode);
	
	Map queryValSetMap(String valSetCode);
}
