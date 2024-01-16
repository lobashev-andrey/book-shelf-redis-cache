package com.example.bookshelfrediscache.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;

@UtilityClass
public class BeanUtils {

    @SneakyThrows
    public void nonNullFieldsCopy (Object from, Object to){
        Field[] fields = from.getClass().getDeclaredFields();

        for(Field field : fields) {
            if(field != null){
                field.setAccessible(true);
                Object value = field.get(from);
                field.set(to, value);
            }
        }
    }
}
