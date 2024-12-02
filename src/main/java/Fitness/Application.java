package Fitness;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static User currentUser =null;
    public static List<User> users =new ArrayList<User>();
    String currentFeature;


    public static User login(String string, String string2) {
        for(User user : users) {
            if(user.getEmail().equals(string)&&user.getPass().equals(string2)) {
                currentUser = user;
                currentUser.incPoints();
                return user;
            }
        }
        return null;
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
                    return (c.getStatus() == UserStatus.Active);
                }
                else if (u instanceof Instructor) {
                    Instructor i = (Instructor) u;
                    return (i.getStatus() == UserStatus.Active);
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

}
