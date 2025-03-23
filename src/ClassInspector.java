package src;

import src.customs.Bus;
import src.customs.Student;
import src.customs.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassInspector {

    public static void showClassesAndFields() {
        Class<?>[] classes = {Bus.class, Student.class, User.class};
        System.out.println("Classes avaliable: ");
        int i = 0;
        for (Class<?> clazz : classes) {
            i++;
            System.out.print(i + ")" + clazz.getSimpleName() + ",");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.print(" " + field.getName()+ "(" +field.getType().getSimpleName() + "),");
            }
            System.out.println("");
        }
    }

    public static Object transformStringtoObject(String input) {
        List<String> objectParts = Arrays.asList(input.split("\\s*,\\s*"));
        String className = objectParts.get(0);

        try {
            Class<?> clazz = Class.forName("src.customs." + className);
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();

            Constructor<?> constructor = constructors[0];
            Class<?>[] paramTypes = constructor.getParameterTypes();

            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                args[i] = convertToType(objectParts.get(i + 1), paramTypes[i]);
            }

            return constructor.newInstance(args);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException("Error creating object: " + e.getMessage(), e);
        }
    }

    private static Object convertToType(String value, Class<?> targetType) {
        if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else if (targetType == String.class) {
            return value;
        }
        throw new IllegalArgumentException("Unsupported type: " + targetType.getSimpleName());
    }
}
