package src;

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
        String regex = "^[A-Z][a-zA-Z0-9]*,\\s*(?:[a-z][a-zA-Z0-9]*|\\d+)\\s*,\\s*(?:[a-z][a-zA-Z0-9]*|\\d+)\\s*,\\s*(?:[a-z][a-zA-Z0-9]*|\\d+)\\s*$";
        if (Pattern.matches(regex, input)) {
            System.out.println("Valid input!");
            return true;
        } else {
            System.out.println("Invalid format! Example: Person,name,age,email");
            return false;
        }
    }

    public Boolean validateClassAndFields(String input){
        String[] objectParts = input.split("\\s*,\\s*");
        System.out.println(objectParts[0] + " - " + objectParts[1] + " - " + objectParts[2] + " - " + objectParts[3]);
        return true;
    }

}

