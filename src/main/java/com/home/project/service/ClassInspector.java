package com.home.project.service;

import com.home.project.model.Bus;
import com.home.project.model.Student;
import com.home.project.model.User;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

        if (objectParts.isEmpty()) {
            throw new IllegalArgumentException("Invalid input: empty string");
        }

        String className = objectParts.get(0); // First element is the class name
        String builderClassName = "src.customs." + className + "$" + className + "Builder";  // Builder class name

        try {
            Class<?> clazz = Class.forName("src.customs." + className);  // Load class dynamically
            Class<?> builderClass = Class.forName(builderClassName);  // Load builder class dynamically
            Object builder = builderClass.getDeclaredConstructor().newInstance(); // Create builder object

            // Get all fields of the class
            Field[] fields = clazz.getDeclaredFields();

            // Start from index 1 because index 0 is the class name
            int fieldIndex = 0;
            for (int i = 1; i < objectParts.size(); i++) {
                if (fieldIndex >= fields.length) break;

                String fieldName = fields[fieldIndex].getName();  // Get field name (e.g., "number", "model")
                String methodName = "with" + capitalizeFirstLetter(fieldName); // Create method name (e.g., "withNumber", "withModel")

                String fieldValue = objectParts.get(i); // Field value

                // Find the appropriate method in the builder class
                Method[] methods = builderClass.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName) && method.getParameterCount() == 1) {
                        Class<?> paramType = method.getParameterTypes()[0];
                        Object convertedValue = convertToType(fieldValue, paramType); // Convert value to correct type
                        method.invoke(builder, convertedValue);
                        fieldIndex++;  // Move to the next field
                        break;
                    }
                }
            }

            // Call the final build method (assumed to be "buidBus", "buidUser", etc.)
            Method buildMethod = builderClass.getMethod("buid" + className);
            return buildMethod.invoke(builder);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException("Error creating object: " + e.getMessage(), e);
        }
    }

    private static Object convertToType(String value, Class<?> targetType) {
        if (targetType == int.class) {
            return Integer.parseInt(value);
        } else if (targetType == String.class) {
            return value;
        } else if (targetType == double.class) {
            return Double.parseDouble(value);
        }
        // Add more types as needed
        throw new IllegalArgumentException("Unsupported type: " + targetType.getName());
    }

    public static Object createRandomObject(){
        Random random = new Random();
        int classChoice = random.nextInt(3); // 0 for Bus, 1 for User, 2 for Student

        switch (classChoice) {
            case 0:
                return new Bus.BusBuilder()
                        .withNumber(random.nextInt(100))
                        .withModel("Model" + random.nextInt(100))
                        .withMileage(random.nextInt(50000))
                        .withYear(2000 + random.nextInt(24))
                        .buidBus();
            case 1:
                return new User.UserBuilder()
                        .withName("User" + random.nextInt(100))
                        .withPassword("Password" + random.nextInt(1000))
                        .withEmail("user" + random.nextInt(1000) + "@gmail.com")
                        .withYear(2000 + random.nextInt(24))
                        .buidUser();
            case 2:
                return new Student.StudentBuilder()
                        .withGroup("Group" + random.nextInt(10))
                        .withGradeBookNumber(random.nextInt(1000))
                        .withAverageGrade(random.nextInt(10) + 1)
                        .withYear(2000 + random.nextInt(24))
                        .buidStudent();
            default:
                return null;
        }
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

    private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}
