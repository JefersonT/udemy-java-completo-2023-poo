package entities;

import java.time.LocalDate;

public class HourContract {
    private LocalDate dateTime;
    private Double valuePerHour;
    private Integer hours;

    public HourContract(LocalDate dateTime, Double valuePerHour, Integer hours) {
        this.dateTime = dateTime;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Double totalValue () {
        return valuePerHour * hours;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }
}
