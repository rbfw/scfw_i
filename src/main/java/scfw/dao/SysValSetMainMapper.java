package scfw.dao;

import scfw.model.SysValSetMain;

public interface SysValSetMainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysValSetMain record);

    int insertSelective(SysValSetMain record);

    SysValSetMain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysValSetMain record);

    int updateByPrimaryKey(SysValSetMain record);
}