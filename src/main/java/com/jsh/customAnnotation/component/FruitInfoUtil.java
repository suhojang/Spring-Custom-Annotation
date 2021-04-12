package com.jsh.customAnnotation.component;

import com.jsh.customAnnotation.fruit.FruitColor;
import com.jsh.customAnnotation.fruit.FruitName;
import com.jsh.customAnnotation.fruit.FruitProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class FruitInfoUtil {
    private static Logger logger    = LoggerFactory.getLogger(FruitInfoUtil.class);
    private static String _LINE     = System.getProperty("line.separator");

    public static String getFruitInfo(Class<?> clazz) {
        StringBuffer sb = new StringBuffer();

        String strFruitName     = " 과일 이름 :";
        String strFruitColor    = " 과일 색 :";
        String strFruitProvider = "과일 파는 곳";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName += fruitName.value();

                logger.info(strFruitName);
                sb.append(strFruitName).append(_LINE);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor += fruitColor.fruitColor().toString();

                logger.info(strFruitColor);
                sb.append(strFruitColor).append(_LINE);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = " 과일 파는 곳의 ID: " + fruitProvider.id() + ", 지점 이름 : " + fruitProvider.name() + ", 지점 주소 : " + fruitProvider.address();

                logger.info(strFruitProvider);
                sb.append(strFruitProvider);
            }
        }
        return sb.toString();
    }
}
