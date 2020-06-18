package com.example.demo;

import com.example.demo.service.TestService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class DemoApplicationTests {
    private static final int MAX = 1000;
    private CountDownLatch countDownLatch = new CountDownLatch(MAX);
    @Autowired
    private TestService testService;
    @Test
    public void contextLoads() throws InterruptedException {
//        for (int i = 0; i < MAX; i++) {
//
//            Thread thread = new Thread(()->{
//                try {
//                    countDownLatch.countDown();
//                    countDownLatch.await();
//                    Map<String, Object> map1 = testService.getmap(1);
//                    System.out.println(map1.toString());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
//        }
//        Thread.sleep(2000);


        System.out.println("xxxxxxxxxx");
    }

}
