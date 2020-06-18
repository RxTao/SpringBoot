package com.example.demo.service;

import com.example.demo.dao.TestDao;
import com.example.demo.model.Test;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class TestService {
    @Autowired
    private TestDao testDao;


    public Test getById(Integer id){
        return testDao.getById(id);
    }

    /**
     * 批量插入
     * @param testList
     * @return
     */
    public int insertList(List<Test> testList){
        return testDao.getinsertList(testList);
    }

    /**
     * 批量查询
     * @param list
     * @return
     */
    public List<Test> batchselect (List<Long> list){
        return testDao.batchselect(list);
    }

    public Map<String,Object> getmap(Integer id){
        return testDao.getmap(id);
    }
}
