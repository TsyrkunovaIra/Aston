package src;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FillService implements Service{
    private List<Object> mainCollection = new ArrayList<>();
    private Validator validator = new Validator();

    public void execute(){
        showMenu();
    }

    // Вывод меню заполнения массива в консоль
    public void showMenu(){
        System.out.println("| You chose FillService. Now, you can pick:");
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
                    System.out.println("Exiting the \"Fill Array\" menu");
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
    public void fillFromFile(){
        System.out.println("Add objects from file");
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
