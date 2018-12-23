package org.sparkapi.app.persistence.entities;

import org.bson.Document;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String name;
    private Integer age;
    private String gender;

    public UserDto() {
    }

    public UserDto(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Document toBsonDocument(){
        Document user = new Document();
        user.put("name", this.getName());
        user.put("age", this.getAge());
        user.put("gender", this.getGender());

        return user;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
