package com.home.project.service;


import java.lang.reflect.Field;
import java.util.*;

import static com.home.project.service.ClassInspector.*;

public class FillService implements Service{
    private MyArrayList<Object> mainCollection = new MyArrayList<>();
    private Validator validator = new Validator();

    public FillService(MyArrayList<Object> mainCollection){
        this.mainCollection = mainCollection;
    }
    public void execute(){

        showMenu();
    }

    // Вывод меню заполнения массива в консоль
    public void showMenu(){
        System.out.println("| You chose Fill-Service. Now, you can pick:");
        System.out.println("| 1. Add objects to collection manually");
        System.out.println("| 2. Add objects from file");
        System.out.println("| 3. Show what inside the collection right now");
        System.out.println("| 4. Exit the FillService menu");
        Scanner scanner = new Scanner(System.in);

        outerLoop:
        while(true){
            String choice = scanner.nextLine();
            Integer validatedChoice = validator.validateInteger(choice);

            switch(validatedChoice){
                case 0 -> System.out.println("Invalid. Please enter only the numbers listed above");
                case 1 -> {
                    fillManually();
                }
                case 2 -> {
                    fillFromFile();
                }
                case 3 -> {
                    showExistingArray();
                }
                case 4 ->{
                    System.out.println("Exiting the \"Fill-Service\" menu");
                    break outerLoop;
                }
                default -> System.out.println("Invalid number. Please enter only numbers listed above");
            }
        }
    }

    //Заполнить массив вручную
    public void fillManually(){
        System.out.println("Please enter new object with its properties in this format: <ClassName>, <property1>, <property2>, <property3>");
        ClassInspector.showClassesAndFields();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(validator.validateClass(input) && validator.validateClassAndFields(input)){
            System.out.println("Valid. Process and add");
            Object object = ClassInspector.transformStringtoObject(input);
            this.mainCollection.add(object);
        }else{
            System.out.println("Invalid");
        }
    }
    //Заполнить массив из файла
    public void fillFromFile() {
        String intChoice;
        Integer numberOfObjects;
        while (true) {
            System.out.println("Please enter number(1-100) of object that u want to add to collection from a file:");
            Scanner scanner = new Scanner(System.in);
            intChoice = scanner.nextLine();
            Integer validatedChoice = validator.validateInteger(intChoice);
            if (validatedChoice == 0) {
                System.out.println("Invalid number.");
            } else {
                numberOfObjects = Integer.valueOf(intChoice);
                break;
            }
        }
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < numberOfObjects; i++) {
            Object obj = createRandomObject();
            objects.add(obj);
        }

        serializeObjectsToFile(objects, "generated_classes.txt");
        List<Object> deserializedObjects = deserializeObjectsFromFile("generated_classes.txt");

        // Добавляем десереализованные обьекты в коллекцию
        if (deserializedObjects != null) {
            this.mainCollection.addAll(deserializedObjects);
            System.out.println("Objects have been added to the mainCollection.");
        }

        clearFileContents("generated_classes.txt");
    }

    //Показать какие данные есть в массиве сейчас
    public void showExistingArray(){
        if(this.mainCollection.isEmpty()){
            System.out.println("Collection is empty right now");
        }else{
            for(Object object : mainCollection){
                System.out.println("* " + object.getClass().getSimpleName());
                for(Field field : object.getClass().getDeclaredFields()){
                    field.setAccessible(true);
                    try {
                        System.out.println("* " + field.getName() + " - " + field.get(object));
                    }catch(IllegalAccessException e){
                        System.out.println(e + "- exception");
                    }
                }
                System.out.println(" ");
            }
        }
    }
}
