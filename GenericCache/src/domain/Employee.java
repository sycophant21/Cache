package domain;

import helper.Annotate;

import java.util.*;

public class Employee implements Value {

    private final String name;
    @Annotate(fieldName = "BRANCH", getter="getBranch")
    private final String branch;
    @Annotate(fieldName = "EMPLOYEEID", getter="getEmployeeID")
    private final EmployeeID employeeID;
    @Annotate(fieldName = "PHONENUMBER", getter="getPhoneNumber")
    private final String phoneNumber;
    @Annotate(fieldName = "AGE", getter="getAge")
    private final int age;
    public Employee(String name, String branch, String phoneNumber, int age) {
        this.name = name;
        this.branch = branch;
        this.employeeID = new EmployeeID(phoneNumber);
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public EmployeeID getID() {
        return employeeID;
    }

    public String getBranch() {
        return branch;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(getName(), employee.getName()) &&
                Objects.equals(getID(), employee.getID()) &&
                Objects.equals(getPhoneNumber(), employee.getPhoneNumber()) &&
                Objects.equals(getBranch(), employee.getBranch());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBranch(), getID(), getPhoneNumber(), getAge());
    }
}
