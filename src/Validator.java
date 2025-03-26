package src;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Validator
{
    public Integer validateInteger(String input){
        if(input == null || input.trim().isEmpty()){
            return 0;
        }
        try{
            Integer number = Integer.parseInt(input);
            return number;
        }catch (NumberFormatException e){
            return 0;
        }
    }

    public Boolean validateClass(String input){
        String regex = "^[A-Z][a-zA-Z0-9]*,\\s*(?:[A-Za-z][a-zA-Z0-9@.]*|\\d+)\\s*,\\s*(?:[A-Za-z][a-zA-Z0-9@.]*|\\d+)\\s*,\\s*(?:[A-Za-z][a-zA-Z0-9@.]*|\\d+)\\s*,\\s*(?:[A-Za-z][a-zA-Z0-9@.]*|\\d+)\\s*$";
        if (Pattern.matches(regex, input)) {
            return true;
        } else {
            System.out.println("Invalid format! Example: Person,name,age,email");
            return false;
        }
    }

    public Boolean validateClassAndFields(String input) {
        String[] objectParts = input.split("\\s*,\\s*");
        String className = objectParts[0];
        List<String> classFields = new ArrayList();

        for(int i = 1; i < objectParts.length; i++){
            classFields.add(objectParts[i]);
        }

        Class<?> clazz;
        try {
            clazz = Class.forName("src.customs." + className);
            Field[] fields = clazz.getDeclaredFields();
            for(int i = 0; i < fields.length; i++){
                if(fields[i].getType().equals(int.class)){
                    try{
                        Integer number = Integer.parseInt(classFields.get(i));
                    }catch(NumberFormatException e){
                        return false;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

}

