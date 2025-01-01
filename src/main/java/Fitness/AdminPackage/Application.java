

package Fitness.AdminPackage;

import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;

import java.util.ArrayList;
import java.util.List;


public class Application
{
    public static User currentUser =null;
    public static List<User> users =new ArrayList<>();
    public static String currentSection;
    public static List<Program> programs =new ArrayList<Program>();
    public static List<Session> sessions=new ArrayList<>();
    String currentFeature;

    public static List<Program> programsList = new ArrayList<>();
    public static  int currentProgramId;


    public static List<Article> notApprovedArticles=new ArrayList<>();
    public static List<Article> wallness=new ArrayList<>();

    public static Admin admin1,admin2;




    public static User login(String string, String string2)
    {
        users =new ArrayList<>();

        for(User user : users) {
            if(user.getEmail().equals(string)&&user.getPass().equals(string2)) {
                currentUser = user;
                currentUser.incPoints();
                return user;
            }
        }
        return null;
    }

    public static void showPrograms() {
        if(programs.isEmpty()) {
            System.out.println("No programs found");
            return ;
        }
        for(Program program : programs) {
            System.out.println(program);
        }


    }

    public static void showRevenue() {
        if(programs.isEmpty()){
            System.out.println("No programs found");
            return ;}
        for(Program program : programs)
        {
            System.out.println(program.getProgramTitle()+"  "+program.getRevenue());
        }

    }

    public static void participants() {
        if(sessions.isEmpty()) {
            System.out.println("No session found");
            return;
        }
        for(Session session : sessions) {
            System.out.println(session);
        }

    }

    public void setCurrentFeature(String cF) {
        currentFeature = cF;
    }

    public static boolean findUser(String mail) {
        for(User u : users) {
            if(u.getEmail().equals(mail)) {
                return true;
            }
        }
        return false;
    }

    public boolean activeCheck(String mail) {
        for (User u : users) {
            if (u.getEmail().equals(mail)) {
                if (u instanceof Client) {
                    Client c = (Client) u;
                    return (c.getStatus() == Status.Active);
                }
                else if (u instanceof Instructor) {
                    Instructor i = (Instructor) u;
                    return (i.getStatus() == Status.Active);
                }
                return true;
            }

        }
        return false;
    }

    public boolean isAdmin(String mail) {
        for (User u : users) {
            if (u.getEmail().equals(mail)) {
                if (u instanceof Admin) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void init()
    {
        admin1 = null;
        admin2 = null;
        String message="";

        admin1 = new Admin("ibrahim", 20, "male", "yaseed", "mashaqi@gmail.com", "pass");
        admin2 = new Admin("admin", 22, "male", "palestine", "admin@gmail.com", "4865");
        users.add(admin1);
        users.add(admin2);
        admin1.addClient("client", 18, "male", "yaseed", "client@gmail.com", "12345", Status.Active);
        admin1.addClient("notActive", 18, "male", "yaseed", "not@gmail.com", "12345", Status.DeActive);
        admin1.addClient("is", 18, "male", "yaseed", "is@gmail.com", "12345", Status.Active);

    }


}
