package model;

import com.google.gson.Gson;

public class ProjectDuration {
    private String name;
    private int duration;

    public ProjectDuration(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
