package com.jsh.customAnnotation.component;

import com.jsh.customAnnotation.fruit.FruitColor;
import com.jsh.customAnnotation.fruit.FruitName;
import com.jsh.customAnnotation.fruit.FruitProvider;
import org.springframework.stereotype.Component;

@Component
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "JSH", address = "Seoul")
    private String appleProvider;
}
