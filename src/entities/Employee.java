package entities;

public class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double initialSalary) {
        this.id = id;
        this.name = name;
        this.salary = initialSalary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }
    public void increaseSalary(double percent) {
        this.salary *= (percent/100)+1;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }

}
