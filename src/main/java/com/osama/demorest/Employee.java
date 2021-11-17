package com.osama.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    private String firstName;
    private String LastName;
    private String age;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
