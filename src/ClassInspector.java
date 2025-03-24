package src;

import src.customs.Bus;
import src.customs.Student;
import src.customs.User;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    public static Object createRandomObject(){
        Random random = new Random();

        // Choose a random class (Bus, User, Student)
        int classChoice = random.nextInt(3); // 0 for Bus, 1 for User, 2 for Student
        Object createdObject = null;

        // Create a random Bus
        if (classChoice == 0) {
            Integer number = random.nextInt(100);
            String model = "Model" + random.nextInt(100);
            Integer mileage = random.nextInt(50000);
            createdObject = new Bus(number, model, mileage);
        }
        // Create a random User
        else if (classChoice == 1) {
            String name = "User" + random.nextInt(100);
            String password = "Password" + random.nextInt(1000);
            String mail = "user" + random.nextInt(1000) + "@gmail.com";
            createdObject = new User(name, password, mail);
        }
        // Create a random Student
        else if (classChoice == 2) {
            Integer groupNumber = random.nextInt(10);
            Integer averageGrade = random.nextInt(10) + 1;
            Integer gradeBookNumber = random.nextInt(1000);
            createdObject = new Student(groupNumber, averageGrade, gradeBookNumber);
        }

        return createdObject;
    }

    public static void serializeObjectsToFile(List<Object> objects, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(objects);
            System.out.println("Objects have been serialized to " + filename);
        } catch (IOException e) {
            System.err.println("Error serializing objects: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Object> deserializeObjectsFromFile(String filename) {
        List<Object> objects = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            objects = (List<Object>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing objects: " + e.getMessage());
            e.printStackTrace();
        }
        return objects;
    }

    public static void clearFileContents(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.write("");
            System.out.println("The contents of " + filename + " have been erased.");
        } catch (IOException e) {
            System.err.println("Error clearing file contents: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
