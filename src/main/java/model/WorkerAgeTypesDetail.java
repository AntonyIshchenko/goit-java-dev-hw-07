package model;

import com.google.gson.GsonBuilder;

import java.util.Date;

public class WorkerAgeTypesDetail {
    private String type;
    private String name;
    private Date birthday;

    public WorkerAgeTypesDetail(String type, String name, Date birthday) {
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(this);
    }
}
