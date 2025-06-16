package aula10.Ex3;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private List<Double> meterReadings;

    public Customer(int customerId, List<Double> meterReadings, String name) {
        this.customerId = customerId;
        this.meterReadings = meterReadings;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Double> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(List<Double> meterReadings) {
        this.meterReadings = meterReadings;
    }
}
