package com.jsh.customAnnotation.fruit;

import java.lang.annotation.*;

@Target({ElementType.FIELD})   //Annotation Target 지정
@Retention(RetentionPolicy.RUNTIME) //Annotation 유효 기간 지정
@Documented
public @interface FruitColor {
    enum Color{
        BLUE, RED, GREEN
    }

    Color fruitColor() default Color.GREEN;
}
