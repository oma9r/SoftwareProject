package Fitness.AdminPackage;

import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Fitness.AdminPackage.Application.*;

public class Admin extends User
{
    public Admin(String name, int age, String gender, String address, String email, String password)
    {
        super(name, age, gender, address, email, password, Role.Admin);


    }

    public Admin(){}

    public boolean addAdmin(String name, int age, String gender, String address, String email, String pass) {
        if(Application.findUser(email)==true)
            return false;
        if(name==null||age<16||gender==null||address==null||email==null||pass==null)
            return false;
        Admin a = new Admin(name, age, gender, address, email, pass);
        return Application.users.add(a);
    }

    public boolean deleteUser(String deleted) {
        for(int i=0; i<Application.users.size(); i++){
            if(Application.users.get(i).getEmail().equals(deleted)&&!(Application.users.get(i) instanceof Admin)) {
                Application.users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addClient(String name, int age, String gender, String address, String email, String pass, Status status) {
        if(Application.findUser(email)==true)
            return false;
        if(name==null||age<16||gender==null||address==null||email==null||pass==null)
            return false;
        Client c = new Client(name, age, gender, address, email, pass,status);
        return Application.users.add(c);
    }

    public boolean updateUser(String mail,int age,String address, String pass) {
        for(int i=0; i<Application.users.size(); i++){
            if(Application.users.get(i).getEmail().equals(mail)&&!(Application.users.get(i) instanceof Admin)) {
                Application.users.get(i).setAge(age);
                Application.users.get(i).setAddress(address);
                Application.users.get(i).setPass(pass);
                return true;
            }
        }
        return false;
    }

    public boolean updateRole(String email) {
        for(int i=0; i<Application.users.size(); i++){
            if(Application.users.get(i).getEmail().equals(email)&&!(Application.users.get(i) instanceof Admin)&&!(Application.users.get(i) instanceof Instructor)) {
                String name =Application.users.get(i).getName();
                int age =Application.users.get(i).getAge();
                String gender =Application.users.get(i).getGender();
                String address =Application.users.get(i).getAddress();
                String pass =Application.users.get(i).getPass();
                Application.users.remove(i);
                Instructor instructor=new Instructor(name,age,gender,address,email,pass,Status.Active);
                Application.users.add(instructor);
                return true;
            }
        }
        return false;
    }

    public boolean setStatus(String email,Status status) {
        for(int i=0; i<Application.users.size(); i++){
            if(Application.users.get(i).getEmail().equals(email)&&(Application.users.get(i) instanceof Client)) {
                Client c=(Client)Application.users.get(i);
                c.setStatus(status);
                return true;
            }
            if(Application.users.get(i).getEmail().equals(email)&&(Application.users.get(i) instanceof Instructor)) {
                Instructor instructor=(Instructor)Application.users.get(i);
                instructor.setStatus(Status.Active);
                return true;
            }


        }
        return false;
    }

    public User[] displayEngagedUsers() {

        User x[]= Application.users.toArray(new User[0]);
        if(x.length<=10)return x;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length-1; j++) {
                if(x[j].getPoints()>x[j+1].getPoints()){
                    User temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }
        for(User u : x){
            System.out.println(u.getPoints());
        }


        User y[]=new User[10];
        for(int i= x.length-1;i>=x.length-10;i--){
            y[x.length-i-1]=x[i];
        }
return y;


    }

    public void displayInActiveUsers() {
        for(int i=0; i<Application.users.size(); i++){
            if(Application.users.get(i) instanceof Instructor) {
                Instructor instructor=(Instructor)Application.users.get(i);
                if(instructor.getStatus()==Status.DeActive) {
                    System.out.println(instructor);
                }

            }
            else if(Application.users.get(i) instanceof Client) {
                Client c=(Client)Application.users.get(i);
                if(c.getStatus().equals(Status.DeActive)) {
                    System.out.println(c);
                }
            }
        }

    }

    public boolean report() {
        String filePath = "C:\\Users\\HP\\Desktop\\New folder\\SoftwareProject\\Report.txt";

        try {
            File file = new File(filePath);

            file.getParentFile().mkdirs();


            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists, writing to the existing file.");
            }

            try (FileWriter fw = new FileWriter(file)) {
                for (int i = 0; i < Application.users.size(); i++) {
                    fw.write(Application.users.get(i).toString() + System.lineSeparator());
                }
                System.out.println("Report written successfully.");
            }
            return true;

        } catch (IOException e) {
            System.out.println("An exception occurred:");
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public String toString() {
        return "["+super.toString()+"]\n";
    }

    public void approve(Article article) {
        article.setApprove(true);
        wallness.add(article);
    }

    public void review() {
        for(int i=0; i<notApprovedArticles.size(); i++){
            System.out.println(notApprovedArticles.get(i).toString());
            System.out.println("1.Approve");
            System.out.println("2.Reject");
           /* Scanner sc = new Scanner(System.in);
            while (true) {
                int choice = sc.nextInt();
                if (choice == 1){
                    approve(notApprovedArticles.get(i));
                    notApprovedArticles.remove(i);
                    sc.close();
                    break;
                }

                else if (choice == 2){
                    notApprovedArticles.remove(i);
                    sc.close();
                    break;
                }
            }*/
        }

    }

    public boolean addInstructor(String name, int age, String gender, String address, String email, String pass,Status status) {
        if(name.length()==0||age<16||gender.length()==0||address.length()==0||email.length()==0||pass.length()==0){
            System.out.println("Missed data");
            return false;
          }
        for (int i=0;i< users.size();i++){
            if(users.get(i).getEmail().equals(email)){
                System.out.println("email already used");
                return false;
            }
        }
        users.add(new Client(name,age,gender,address,email,pass,status));
        return true;
    }

    public boolean viewSubscriptions() {
        try {
            for(int i=0; i<users.size(); i++) {
                if (users.get(i) instanceof Client) {
                    System.out.println(users.get(i).getName() + ((Client) users.get(i)).getPlan());
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }




    }

    public List<Session> showAtetendance(Program program) {
        ArrayList<Session> sessions = program.getSessions();
        System.out.println("Program title:"+program.getProgramTitle());
        System.out.println("Session number\t Session attendance");

        for (int i=0; i<sessions.size(); i++) {
            System.out.println(i+"\t"+sessions.get(i).getClientList());
        }
        return sessions;
    }

    public boolean clientProgress(Client c) {
        try {

            System.out.println(c.getName() + "\t" + c.getProgram().getProgramTitle() + "\t" + c.getCurrentProgress() + "\t");
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }


    public void getProgramsActive() {
        for(Program p:programs)
            System.out.println(p.getProgramTitle()+"\t"+p.getIsComplete());


    }
}
