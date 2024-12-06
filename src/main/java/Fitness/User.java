package Fitness;

import java.util.Random;

public class User {
    private int id;
    private String name;
    private int age;
    private static int idCounter = 0;
    private String gender;
    private String address;
    private String email;
    private String password;
    private Role role;
    private int points;

    public User( String name, int age, String gender, String address, String email, String password, Role role) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
        this.points = 0;


    }
    public User(){
        this.id = idCounter++;
        points=new Random().nextInt(100);
    }

public int getPoints(){
        return points;
}
    public String getEmail() {
        return email;
    }

    public String getPass() {
        return password;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getAddress() {
        return address;
    }
    protected void setAge(int age) {
        this.age = age;
    }
    public void setPass(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {this.name = name;}



    public void incPoints() {
        this.points++;
    }
}
