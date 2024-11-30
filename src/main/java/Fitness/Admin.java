package Fitness;

public class Admin {
    private static int idCounter=0;
    private int id;
    private String name;
    private String address;
    private String email;
    private String password;
    public Admin( String name, String address, String email, String password) {
        this.id = idCounter;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        idCounter++;
    }

}
