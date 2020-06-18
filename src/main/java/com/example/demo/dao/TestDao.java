package com.example.demo.dao;

import com.example.demo.model.Test;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface TestDao extends Mapper<Test> {
    /**
     * <!-- 根据主键查询-->
     * @param id
     * @return
     */
    Test getById(Integer id);

    /**
     * 批量插入
     * @param testList
     * @return
     */
    int  getinsertList(List<Test> testList);

    /**
     * 批量查询
     * @param list
     * @return
     */
    List<Test> batchselect (List<Long> list);

    Map<String,Object> getmap(Integer id);
}
