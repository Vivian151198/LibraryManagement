package org.example;

public class User {

    private int id;
    private String name;
    private String idCardNumber;

    User(){

    }

    public User(int id, String name, String idCardNumber) {
        this.id = id;
        this.name = name;
        this.idCardNumber = idCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}
