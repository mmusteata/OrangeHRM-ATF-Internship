package com.endava.utils;

import com.endava.context.DataKeys;
import com.endava.context.ScenarioContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;

public class ReflectionsUtils {

    public WebElement getWebElementByClass(String fieldName) throws IllegalAccessException {
        Class clazz = ScenarioContext.getData(DataKeys.CURRENT_PAGE).getClass();
        WebElement webElement = null;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals(fieldName)) {
                webElement = (WebElement) field.get(ScenarioContext.getData(DataKeys.CURRENT_PAGE));
            }
        }
        return webElement;
    }
}
