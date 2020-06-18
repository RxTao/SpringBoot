package com.example.demo.controller;

import com.example.demo.dao.TestDao;
import com.example.demo.model.Test;
import com.example.demo.service.TestService;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@Controller
public class UserController {

    public static final int MAX = 1000;
    private CountDownLatch countDownLatch = new CountDownLatch(MAX);

    @Autowired
    private TestService testService;
    @Autowired
    private TestDao testDao;

    AbstractController abstractController = new AbstractController();

    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object getHello(ModelMap map, Integer id) {

        if (id == null) {
            return abstractController.toResponsObject(400, "上传参数不能为空！", "");
        }


        List<Test> testList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Test test1 = new Test();
            test1.setFirstName("hhhh");
            test1.setLastName("lllll");
            test1.setMagicId(String.valueOf(i));
            testList.add(test1);

        }
//        Integer integer = testService.insertList(testList);   //批量插入

//         Integer integer = testDao.insert(test1);
//        if (integer == 0) {
//            return abstractController.toResponsFail(0, "增加成功");
//        }

//3333333333333
        List<Long> longList = new ArrayList<>();
        longList.add(1L);
        longList.add(2L);
        longList.add(3L);
        List<Test> testList1 = testService.batchselect(longList);
        map.put("test", testList1);
//        Test test = testService.getById(id);
//        if (test != null) {
//            List<Test> testuser = testDao.selectAll();
//            map.put("test", testuser);
//        } else {
//            map.put("test", test);
//        }

        return abstractController.toResponsSuccess(map);
    }


    @RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "index";
    }


    @RequestMapping(value = "/boottest",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json; charset=utf-8")
    public String hellohome() throws InterruptedException {

        for (int i = 0; i < MAX; i++) {
            Thread thread = new Thread(()->{
                try {
                    countDownLatch.countDown();
                    countDownLatch.await();
                    Map<String, Object> map1 = testService.getmap(1);
                    System.out.println(map1.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        Thread.sleep(2000);



        return "index";
    }

}
