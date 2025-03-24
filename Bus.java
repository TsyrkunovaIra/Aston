import java.util.Objects;

public class Bus implements Comparable<Bus> {
    private String model;
    private int number;
    private int runned;

    private Bus(BusBuilder BB)
    {
        model = BB.model;
        number = BB.number;
        runned = BB.runned;
    }
    public Bus(String model, int number, int runned) {
        this.model = model;
        this.number = number;
        this.runned = runned;
    }
    @Override
    public int compareTo(Bus other)
    {
        if(this.number != other.number)
            return Integer.compare(this.number, other.number);
        if(!this.model.equals(other.model))
            return this.model.compareTo(other.model);
        return Integer.compare(this.runned, other.runned);
    }
    @Override
    public String toString()
    {
        return "Runned = " + runned + "\n" + "model = " + model + "\n" + "number = " + number + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return runned == bus.runned;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(runned);
    }

    public static class BusBuilder
    {
        private String model;
        private int number;
        private int runned;
        public BusBuilder(int runned)
        {
            this.runned = runned;
        }
        public BusBuilder setModel(String model)
        {
            this.model = model;
            return this;
        }
        public BusBuilder setNumber(int number)
        {
            this.number = number;
            return this;
        }
        public Bus build()
        {
            return new Bus(this);
        }

    }

}