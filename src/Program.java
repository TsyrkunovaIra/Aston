package src;

import java.util.Scanner;

public class Program {
    private Service service;

    //Метож в котором создается меню
    public void run(){
        System.out.println("App is running");
        String choice;
        System.out.println("choose option (1) for collection fill or (2) for collection sort, choose (3) if you want to exit");

        while(true) {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine();
            if(choice.trim().isEmpty()){
                System.out.println("Nothing was typed, pls choose number from the menu");
            }else{
                try{
                    Integer intChoice = Integer.parseInt(choice);
                    if(intChoice == 1 || intChoice == 2){
                        setService(intChoice);
                        service.execute();
                    }else if(intChoice == 3){
                        System.out.println(intChoice + " - you picked. Exiting the program...");
                        break;
                    }else{
                        System.out.println("Please enter valid number listed above");
                    }
                }catch(NumberFormatException e){
                    System.out.println(e + " - Please enter valid number listed above");
                }
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
