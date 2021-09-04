package com.example.predavanjademo.web.dto;

public class UserSearchDTO extends UserDTO {

    private String age;
    private Double salary;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "UserSearchDTO{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                '}';
    }
}
