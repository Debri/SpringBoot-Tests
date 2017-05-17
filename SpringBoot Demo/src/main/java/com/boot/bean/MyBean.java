package com.boot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Liuqi
 * Date: 2017/5/16.
 */
@Component
public class MyBean {
    @Autowired
    public MyBean(ApplicationArguments args) {
        boolean debug = args.containsOption("debug");
        List<String> files = args.getNonOptionArgs();
        for (String str : files) {
            System.out.println(str);
        }
    }
}
