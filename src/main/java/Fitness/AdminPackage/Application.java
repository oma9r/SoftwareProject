/**
 * Represents the application that handles users, programs, sessions, and administrative tasks.
 * Provides functionalities for login, displaying programs, revenue, participants, and managing users.
 *
 * @author Ibrahim Mashaqi
 */
package Fitness.AdminPackage;

import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;

import java.awt.desktop.AppForegroundListener;
import java.util.ArrayList;
import java.util.List;

public  class Application {

    /**
     * The current logged-in user.
     */
    public static User currentUser;

    /**
     * List of all users in the application.
     */
    public static List<User> users = new ArrayList<User>();

    /**
     * The current section being accessed in the application.
     */
    public static String currentSection;

    /**
     * List of all programs available in the application.
     */
    public static List<Program> programs = new ArrayList<>();

    /**
     * List of all sessions available in the application.
     */
    public static List<Session> sessions = new ArrayList<>();

    /**
     * The current feature being accessed by the user.
     */
    String currentFeature;

    /**
     * List of all programs.
     */
    public static List<Program> programsList = new ArrayList<>();

    /**
     * ID of the current program being accessed.
     */
    public static int currentProgramId;

    /**
     * List of articles not approved yet.
     */
    public static List<Article> notApprovedArticles = new ArrayList<>();

    /**
     * List of wellness-related articles.
     */
    public static List<Article> wallness = new ArrayList<>();

    /**
     * The first admin user.
     */
    public static Admin admin1;

    /**
     * The second admin user.
     */


    public static Admin admin2;

    /**
     * The third admin user.
     */

    public static Admin admin3;

    /**
     * Constructs an instance of the Application class and initializes default administrators
     * and clients for the Fitness Management System.
     *
     * <p>This constructor performs the following actions:
     * <ul>
     *   <li>Initializes three administrator accounts with predefined data (name, age, gender, location, email, and password).</li>
     *   <li>Adds the administrators to the static list of users.</li>
     *   <li>Assigns clients to the first administrator with predefined data and statuses.</li>
     * </ul>
     *
     * <p>Predefined administrators:
     * <ul>
     *   <li><strong>Admin 1:</strong> "ibrahim", 20 years, "male", "yaseed", "mashaqi@gmail.com", "pass"</li>
     *   <li><strong>Admin 2:</strong> "admin", 22 years, "male", "palestine", "admin@gmail.com", "4865"</li>
     *   <li><strong>Admin 3:</strong> "Abood", 22 years, "male", "palestine", "Abood@gmail.com", "112233"</li>
     * </ul>
     *
     * <p>Predefined clients for Admin 1:
     * <ul>
     *   <li><strong>Client 1:</strong> "client", 18 years, "male", "yaseed", "client@gmail.com", "12345", Active</li>
     *   <li><strong>Client 2:</strong> "notActive", 18 years, "male", "yaseed", "not@gmail.com", "12345", DeActive</li>
     *   <li><strong>Client 3:</strong> "is", 18 years, "male", "yaseed", "is@gmail.com", "12345", Active</li>
     * </ul>
     *
     * <p>Note: This constructor ensures that the static list of users contains the predefined administrators,
     * and the first administrator manages a few initial clients.
     *
     */

    public Application()
    {
        String plaestineString = "Palestine";
        String yaseedString = "Yaseed";
        admin1 = new Admin("ibrahim", 20, "male", yaseedString, "mashaqi@gmail.com", "pass");
        admin2 = new Admin("admin", 22, "male", plaestineString, "admin@gmail.com", "4865");
        admin3 = new Admin("Abood", 22, "male", plaestineString, "Abood@gmail.com", "112233");
        users.add(admin1);
        users.add(admin2);
        users.add(admin3);
        Application.addUser(admin1);
        Application.addUser(admin2);
        Application.addUser(admin3);
        //Client client = new Client("client", 18, "male", yaseedString, "client@gmail.com", "12345", Status.Active);
        //Application.addUser(client);
        //admin1.addClient("client", 18, "male",yaseedString, "client@gmail.com", "12345", Status.Active);

        admin1.addClient("notActive", 18, "male", yaseedString, "not@gmail.com", "12345", Status.DeActive);
        admin1.addClient("is", 18, "male", yaseedString, "is@gmail.com", "12345", Status.Active);
        admin1.addClient("mo", 18, "male", "yaseed", "moh@gmail.com", "12345", Status.Active);

    }

    /**
     * Logs in a user by verifying their email and password.
     *
     * @param email The email of the user.
     * @param password The password of the user.
     * @return The logged-in user if successful, otherwise null.
     */
    public static User login(String email, String password) {
        //Application.init();
        for (User user : users) {
            if (user.getEmail() != null && user.getEmail().equals(email) && user.getPass().equals(password)) {
                return user;
            }
        }
        return null;
    }


    /**
     * Displays all available programs.
     */
    public static void showPrograms() {
        if (programs.isEmpty()) {
            System.out.println("No programs found");
            return;
        }
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    /**
     * Displays the revenue generated by each program.
     */
    public static void showRevenue() {
        if (programs.isEmpty()) {
            System.out.println("No programs found");
            return;
        }
        for (Program program : programs) {
            System.out.println(program.getProgramTitle() + "  " + program.getRevenue());
        }
    }



    /**
     * Sets the current feature being accessed.
     *
     * @param currentFeature The feature to set as current.
     */
    public void setCurrentFeature(String currentFeature) {
        this.currentFeature = currentFeature;
    }

    /**
     * Checks if a user exists with the given email.
     *
     * @param email The email to check.
     * @return True if the user exists, otherwise false.
     */
    public static boolean findUser(String email) {


        Application.login(email, "");
        for (User u : users)
        {
            if(u.getEmail() == null)
            {
                continue;
            }
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a user with the given email is active.
     *
     * @param email The email to check.
     * @return True if the user is active, otherwise false.
     */
    public boolean activeCheck(String email) {
        for (User u : users) {
            if(u.getEmail() == null) continue;
            if (u.getEmail().equals(email))
            {
                if (u instanceof Client)
                {
                    Client c = (Client) u;
                    return (c.getStatus() == Status.Active);
                } else if (u instanceof Instructor)
                {
                    Instructor i = (Instructor) u;
                    return (i.getStatus() == Status.Active);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a user with the given email is an admin.
     *
     * @param email The email to check.
     * @return True if the user is an admin, otherwise false.
     */
    public boolean isAdmin(String email) {
        for (User u : users) {
            if(u.getEmail() == null) continue;
            if (u.getEmail().equals(email) && u instanceof Admin) {

                    return true;

            }
        }
        return false;
    }

    /**
     * Initializes the application with default data.
     */
    public static void init() {


        admin1 = new Admin("ibrahim", 20, "male", "yaseed", "mashaqi@gmail.com", "pass");
        admin2 = new Admin("admin", 22, "male", "palestine", "admin@gmail.com", "4865");
        admin3 = new Admin("Abood", 22, "male", "palestine12", "Abood@gmail.com", "112233");
        users.add(admin1);
        users.add(admin2);
        users.add(admin3);
        Application.addUser(admin1);
        Application.addUser(admin2);
        Application.addUser(admin3);
        admin1.addClient("client", 18, "male", "yaseed", "client@gmail.com", "12345", Status.Active);
        admin1.addClient("notActive", 18, "male", "yaseed", "not@gmail.com", "12345", Status.DeActive);
        admin1.addClient("is", 18, "male", "yaseed", "is@gmail.com", "12345", Status.Active);
        admin1.addClient("mo", 18, "male", "yaseed", "moh@gmail.com", "12345", Status.Active);
    }

    public static boolean addUser(User user)
    {
        if(!users.contains(user))
        {
            //System.out.println(user.getEmail());
            users.add(user);
            return true;
        }
        return false;
    }
}
