package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    private Double baseSalary;
    private WorkerLevel level;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, Double baseSalary, WorkerLevel level, Department department) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.level = level;
        this.department = department;
    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        Double income = this.baseSalary;
        for (HourContract c : contracts) {
            int cYear = c.getDateTime().getYear();
            int cMonthValue = c.getDateTime().getMonthValue();
            if (cYear == year && cMonthValue == month) {
                income += c.totalValue();
            }
        }
        return income;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public Department getDepartment() {
        return department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
}
