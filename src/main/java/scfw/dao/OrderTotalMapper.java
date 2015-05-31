package scfw.dao;

import scfw.model.OrderTotal;

public interface OrderTotalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderTotal record);

    int insertSelective(OrderTotal record);

    OrderTotal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderTotal record);

    int updateByPrimaryKey(OrderTotal record);
}