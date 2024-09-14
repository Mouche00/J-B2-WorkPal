package utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    public static List<Field> getAllDeclaredFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields;
    }
}
