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
