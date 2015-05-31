package scfw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scfw.dao.SysValSetMapper;
import scfw.model.SysValSet;

@Service("valSetService")
public class ValSetServiceImpl implements ValSetServiceI {
	@Autowired
	private SysValSetMapper mapper;
	
	@Override
	public List<SysValSet> queryValSetList(String valSetCode) {
		return mapper.queryValSetList(valSetCode);
	}
	
	@Override
	public Map queryValSetMap(String valSetCode) {
		Map map = new HashMap<Integer, String>();
		List<SysValSet> svss = mapper.queryValSetList(valSetCode);
		for (SysValSet svs : svss) {
			map.put(svs.getVal(), svs.getValCn());
		}
		return map;
	}

	
}
