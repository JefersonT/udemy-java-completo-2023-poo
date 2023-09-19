package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private Double baseSalary;
    private WorkerLevel workerLevel;
    private Department department;
    private List<HourContract> hourContracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, Double baseSalary, WorkerLevel workerLevel, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.workerLevel = workerLevel;
        this.department = department;
    }

    public Worker(String name, Double baseSalary, WorkerLevel workerLevel, Department department, List<HourContract> hourContracts) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.workerLevel = workerLevel;
        this.department = department;
        this.hourContracts = hourContracts;
    }

    public void addContract(HourContract hourContract) {
        this.hourContracts.add(hourContract);
    }

    public void removeContract(HourContract hourContract) {
        this.hourContracts.remove(hourContract);
    }

    public Double income(Integer year, Integer month) {
        Double income = this.baseSalary;
        for (HourContract c : hourContracts) {
            if (c.getDateTime().getYear() == year && c.getDateTime().getMonthValue() == month) {
                income += c.totalValue();
            }
        }
        return income;
    }

    public String getName() {
        return name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public WorkerLevel getWorkerLevel() {
        return workerLevel;
    }

    public Department getDepartment() {
        return department;
    }

    public List<HourContract> getHourContracts() {
        return hourContracts;
    }
}
