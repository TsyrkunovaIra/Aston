package src;

import java.util.Scanner;

public class Program {
    private Service service;

    //Метод в котором создается меню
    public void run(){
        Validator validator = new Validator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("| App is running. Choose option (1) for collection fill or (2) for collection sort, choose (3) if you want to exit...");

        outerLoop:
        while(true) {
            String choice = scanner.nextLine();
            Integer validatedChoice = validator.validateInteger(choice);

            switch(validatedChoice){
                case 0 -> System.out.println("Invalid. Please enter only the numbers listed above");
                case 1,2 -> {
                    setService(validatedChoice);
                    service.execute();
                }
                case 3 -> {
                    System.out.println("Exiting the program");
                    break outerLoop;
                }
                default -> System.out.println("Invalid number. Please enter only numbers listed above");
            }
        }
    }


    //Вызов одного из сервисов, либо на заполнение массива, либо на сортировку массива
    public void setService(Integer choice){
        switch(choice) {
            case 1:
                this.service = new FillService();
                break;
            case 2:
                this.service = new SortService();
                break;
        }
    }

}
