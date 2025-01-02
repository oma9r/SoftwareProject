package Fitness.AdminPackage;

import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Fitness.AdminPackage.Application.*;

/**
 * Represents an admin user in the fitness management system.
 * Admins can perform operations such as adding or deleting users, updating user details,
 * managing roles, generating reports, and monitoring system activity.
 *
 * @author Ibrahim Mashaqi
 */
public class Admin extends User {

    /**
     * Constructs a new Admin instance with the specified details.
     *
     * @param name     the name of the admin
     * @param age      the age of the admin
     * @param gender   the gender of the admin
     * @param address  the address of the admin
     * @param email    the email of the admin
     * @param password the password of the admin
     */
    public Admin(String name, int age, String gender, String address, String email, String password) {
        super(name, age, gender, address, email, password, Role.Admin);
    }

    /**
     * Default constructor for the Admin class.
     */
    public Admin() {}

    /**
     * Adds a new admin to the system.
     *
     * @param name   the name of the new admin
     * @param age    the age of the new admin
     * @param gender the gender of the new admin
     * @param address the address of the new admin
     * @param email  the email of the new admin
     * @param pass   the password of the new admin
     * @return true if the admin was added successfully; false otherwise
     */
    public boolean addAdmin(String name, int age, String gender, String address, String email, String pass) {
        if (Application.findUser(email)) return false;
        if (name == null || age < 16 || gender == null || address == null || email == null || pass == null) return false;
        Admin a = new Admin(name, age, gender, address, email, pass);
        return Application.users.add(a);
    }

    /**
     * Deletes a user from the system based on their email.
     *
     * @param deleted the email of the user to be deleted
     * @return true if the user was deleted successfully; false otherwise
     */
    public boolean deleteUser(String deleted) {
        for (int i = 0; i < Application.users.size(); i++) {
            if (Application.users.get(i).getEmail().equals(deleted) && !(Application.users.get(i) instanceof Admin)) {
                Application.users.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a new client to the system.
     *
     * @param name    the name of the client
     * @param age     the age of the client
     * @param gender  the gender of the client
     * @param address the address of the client
     * @param email   the email of the client
     * @param pass    the password of the client
     * @param status  the subscription status of the client
     * @return true if the client was added successfully; false otherwise
     */
    public boolean addClient(String name, int age, String gender, String address, String email, String pass, Status status) {
        if (Application.findUser(email)) return false;
        if (name == null || age < 16 || gender == null || address == null || email == null || pass == null) return false;
        Client c = new Client(name, age, gender, address, email, pass, status);
        return Application.users.add(c);
    }

    /**
     * Updates the details of a user.
     *
     * @param mail    the email of the user to be updated
     * @param age     the new age of the user
     * @param address the new address of the user
     * @param pass    the new password of the user
     * @return true if the user was updated successfully; false otherwise
     */
    public boolean updateUser(String mail, int age, String address, String pass) {
        for (int i = 0; i < Application.users.size(); i++) {
            if (Application.users.get(i).getEmail().equals(mail) && !(Application.users.get(i) instanceof Admin)) {
                Application.users.get(i).setAge(age);
                Application.users.get(i).setAddress(address);
                Application.users.get(i).setPass(pass);
                return true;
            }
        }
        return false;
    }

    /**
     * Upgrades a user to an instructor role based on their email.
     *
     * @param email the email of the user to be upgraded
     * @return true if the role was updated successfully; false otherwise
     */
    public boolean updateRole(String email) {
        for (int i = 0; i < Application.users.size(); i++) {
            if (Application.users.get(i).getEmail().equals(email) &&
                    !(Application.users.get(i) instanceof Admin) &&
                    !(Application.users.get(i) instanceof Instructor)) {

                String name = Application.users.get(i).getName();
                int age = Application.users.get(i).getAge();
                String gender = Application.users.get(i).getGender();
                String address = Application.users.get(i).getAddress();
                String pass = Application.users.get(i).getPass();

                Application.users.remove(i);
                Instructor instructor = new Instructor(name, age, gender, address, email, pass, Status.Active);
                Application.users.add(instructor);
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the status of a user (active or inactive).
     *
     * @param email  the email of the user
     * @param status the new status to set
     * @return true if the status was set successfully; false otherwise
     */
    public boolean setStatus(String email, Status status) {
        for (int i = 0; i < Application.users.size(); i++) {
            if (Application.users.get(i).getEmail().equals(email)) {
                if (Application.users.get(i) instanceof Client) {
                    Client c = (Client) Application.users.get(i);
                    c.setStatus(status);
                    return true;
                }
                if (Application.users.get(i) instanceof Instructor) {
                    Instructor instructor = (Instructor) Application.users.get(i);
                    instructor.setStatus(status);
                    return true;
                }
            }
        }
        return false;
    }



    /**
     * Displays the top 10 users based on engagement (points).
     *
     * @return an array of the top 10 most engaged users, or fewer if there are less than 10 users
     */
    public User[] displayEngagedUsers() {
        User x[] = Application.users.toArray(new User[0]);
        if (x.length <= 10) return x;

        // Sort users by points in ascending order
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length - 1; j++) {
                if (x[j].getPoints() > x[j + 1].getPoints()) {
                    User temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }

        // Extract the top 10 users
        User y[] = new User[10];
        for (int i = x.length - 1; i >= x.length - 10; i--) {
            y[x.length - i - 1] = x[i];
        }
        return y;
    }

    /**
     * Displays all inactive users (clients or instructors) in the system.
     */
    public void displayInActiveUsers() {
        for (int i = 0; i < Application.users.size(); i++) {
            if (Application.users.get(i) instanceof Instructor) {
                Instructor instructor = (Instructor) Application.users.get(i);
                if (instructor.getStatus() == Status.DeActive) {
                    System.out.println(instructor);
                }
            } else if (Application.users.get(i) instanceof Client) {
                Client c = (Client) Application.users.get(i);
                if (c.getStatus().equals(Status.DeActive)) {
                    System.out.println(c);
                }
            }
        }
    }

    /**
     * Generates a report of all users in the system and writes it to a file.
     *
     * @return true if the report was successfully created and written; false otherwise
     */
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

    /**
     * Approves an article and adds it to the approved articles list.
     *
     * @param article the article to be approved
     */
    public void approve(Article article) {
        article.setApprove(true);
        wallness.add(article);
    }

    /**
     * Returns the string representation of the Admin object.
     *
     * @return a string containing the admin's details
     */
    @Override
    public String toString() {
        return "[" + super.toString() + "]\n";
    }

    /**
     * Reviews all unapproved articles. Provides options to approve or reject them.
     */
    public void review() {
        for (int i = 0; i < notApprovedArticles.size(); i++) {
            System.out.println(notApprovedArticles.get(i).toString());
            System.out.println("1. Approve");
            System.out.println("2. Reject");
            // Uncomment and modify the logic below to handle user input during review
            /*
            Scanner sc = new Scanner(System.in);
            while (true) {
                int choice = sc.nextInt();
                if (choice == 1) {
                    approve(notApprovedArticles.get(i));
                    notApprovedArticles.remove(i);
                    sc.close();
                    break;
                } else if (choice == 2) {
                    notApprovedArticles.remove(i);
                    sc.close();
                    break;
                }
            }
            */
        }
    }

    /**
     * Adds a new instructor to the system.
     *
     * @param name    the name of the instructor
     * @param age     the age of the instructor
     * @param gender  the gender of the instructor
     * @param address the address of the instructor
     * @param email   the email of the instructor
     * @param pass    the password of the instructor
     * @param status  the subscription status of the instructor
     * @return true if the instructor was added successfully; false otherwise
     */
    public boolean addInstructor(String name, int age, String gender, String address, String email, String pass, Status status) {
        if (name.length() == 0 || age < 16 || gender.length() == 0 || address.length() == 0 || email.length() == 0 || pass.length() == 0) {
            System.out.println("Missed data");
            return false;
        }
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)) {
                System.out.println("Email already used");
                return false;
            }
        }
        users.add(new Client(name, age, gender, address, email, pass, status));
        return true;
    }

    /**
     * Displays the subscription details of all clients in the system.
     *
     * @return true if the operation was successful; false otherwise
     */
    public boolean viewSubscriptions() {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) instanceof Client) {
                    System.out.println(users.get(i).getName() + ((Client) users.get(i)).getPlan());
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Shows attendance details for the sessions of a specific program.
     *
     * @param program the program whose sessions' attendance is to be displayed
     * @return a list of sessions in the program
     */
    public List<Session> showAtetendance(Program program) {
        ArrayList<Session> sessions = program.getSessions();
        System.out.println("Program title: " + program.getProgramTitle());
        System.out.println("Session number\t Session attendance");

        for (int i = 0; i < sessions.size(); i++) {
            System.out.println(i + "\t" + sessions.get(i).getClientList());
        }
        return sessions;
    }

    /**
     * Displays the progress of a specific client.
     *
     * @param c the client whose progress is to be displayed
     * @return true if the operation was successful; false otherwise
     */
    public boolean clientProgress(Client c) {
        try {
            System.out.println(c.getName() + "\t" + c.getProgram().getProgramTitle() + "\t" + c.getCurrentProgress() + "\t");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Displays all active programs and their completion status.
     */
    public void getProgramsActive() {
        for (Program p : programs)
            System.out.println(p.getProgramTitle() + "\t" + p.getIsComplete());
    }




}
