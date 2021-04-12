package com.jsh.customAnnotation.controller;

import com.jsh.customAnnotation.component.Apple;
import com.jsh.customAnnotation.component.FruitInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {
    @Autowired
    private FruitInfoUtil fruitInfoUtil;

    @GetMapping(value = "/getFruit")
    public String getFruit() {
        return fruitInfoUtil.getFruitInfo(Apple.class);
    }
}
