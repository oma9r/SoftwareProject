package Fitness;

public class Admin {
   private int id;
   private String name;
   private String password;
   private String email;
   private String address;
   static private int idCounter=0;
    public Admin(String name,String addrees,String email,String password){
        this.id=idCounter;
        this.name=name;
        this.password=password;
        this.email=email;
        this.address=addrees;
        idCounter++;
    }
}
