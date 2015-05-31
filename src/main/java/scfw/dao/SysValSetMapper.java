package scfw.dao;

import java.util.List;

import scfw.model.SysValSet;

public interface SysValSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysValSet record);

    int insertSelective(SysValSet record);

    SysValSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysValSet record);

    int updateByPrimaryKey(SysValSet record);
    
    List<SysValSet> queryValSetList(String valSetCode);
}