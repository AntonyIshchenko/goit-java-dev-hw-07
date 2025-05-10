package model;

import com.google.gson.Gson;

public class ClientProjectCount {
    private String name;
    private int projectCount;

    public ClientProjectCount(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
