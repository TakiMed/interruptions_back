package com.example.predavanjademo.services;

public class CustomerService {

    private String name;

    private String type;

    public CustomerService(){

    }

    public CustomerService(String name, String type)
    {
       this.name = name;
       this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CustomerService findByName(String name){
        if(name.equals("A")){
            return new CustomerService("A", "TYPE-A");
        }
        else return new CustomerService("UNKNOWN", "Type-UNKNOWN");
    }


}
