package com.home.project.service;

import java.lang.reflect.Field;
import java.util.Scanner;

public class SearchService implements Service{
    Validator validator = new Validator();
    MyArrayList<Object> mainCollection = new MyArrayList<>();

    public SearchService(MyArrayList<Object> mainCollection){
        this.mainCollection = mainCollection;
    }

    public void execute() {
        showMenu();
    }
    public void showMenu(){
        System.out.println("| You chose Search-Service. You find an element only if collection is not empty, collection was sorted. Please choose:");
        System.out.println("| 1. Search wanted object");
        System.out.println("| 2. Check collection if it is empty");
        System.out.println("| 3. Exit the Search-Service menu");
        Scanner scanner = new Scanner(System.in);

        outerLoop:
        while(true) {
            String choice = scanner.nextLine();
            Integer validatedChoice = validator.validateInteger(choice);

            switch (validatedChoice) {
                case 1 -> {
                    findTheElement();
                }
                case 2 -> {
                    showExistingArray();
                }
                case 3 -> {
                    System.out.println("Exiting the \"Search-Service\" menu");
                    break outerLoop;
                }
                default -> System.out.println("Invalid number. Please enter only numbers listed above");
            }
        }
    }

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
    public void findTheElement() {
        System.out.println("Please enter new object with its properties in this format: <ClassName>, <property1>, <property2>, <property3>");
        ClassInspector.showClassesAndFields();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (validator.validateClass(input) && validator.validateClassAndFields(input)) {
            System.out.println("Valid. Finding the element...");

            Object object = ClassInspector.transformStringtoObject(input);

            UniversalComparator comparator = new UniversalComparator();

            int index = MyBinarySearch.binarySearch(this.mainCollection, object, comparator);

            if (index != -1) {
                System.out.println("Found element at index " + index);
            } else {
                System.out.println("Element not found.");
            }
        } else {
            System.out.println("Invalid");
        }
    }
}
