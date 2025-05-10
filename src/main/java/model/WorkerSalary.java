package model;

import com.google.gson.Gson;

public class WorkerSalary {
    private String name;
    private int salary;

    public WorkerSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
