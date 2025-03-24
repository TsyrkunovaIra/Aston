package src.customs;

import java.io.Serializable;

public class Bus implements Serializable {
    private Integer number;
    private String model;
    private Integer mileage;

    public Bus(Integer number, String model, Integer mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }


}
