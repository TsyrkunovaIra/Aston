package com.home.project.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortService implements Service{
    private MyArrayList<Object> mainCollection = new MyArrayList<>();
    private Validator validator = new Validator();

    public SortService(MyArrayList<Object> mainCollection){
        this.mainCollection = mainCollection;
    }

    public void execute(){
        showMenu();
    }

    public void showMenu(){
        System.out.println("| You chose Sorting-Service. Now, you can pick:");
        System.out.println("| 1. Sort exisiting array");
        System.out.println("| 2. Show what inside the collection right now");
        System.out.println("| 3. Exit the Sorting-Service menu");
        Scanner scanner = new Scanner(System.in);

        outerLoop:
        while(true){
            String choice = scanner.nextLine();
            Integer validatedChoice = validator.validateInteger(choice);

            switch(validatedChoice){
                case 1 -> {
                    sortArray();
                }
                case 2 -> {
                    showExistingArray();
                }
                case 3 -> {
                    System.out.println("Exiting the \"Sorting-Service\" menu");
                    break outerLoop;
                }
                default -> System.out.println("Invalid number. Please enter only numbers listed above");
            }
        }
    }

    public void sortArray()
    {
        MySorting.quickSort(this.mainCollection, 0, this.mainCollection.size() - 1, new UniversalComparator());
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

}
