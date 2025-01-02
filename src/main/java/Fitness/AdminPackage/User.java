package Fitness.AdminPackage;

import Fitness.InstructorP.Communicate.Message;
import Fitness.InstructorP.Communicate.Notification;
import Fitness.InstructorP.DiscussionFromP.Post;
import Fitness.InstructorP.ProgramPackage.Program;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a user in the fitness system, which can have various roles and properties.
 * The User class contains personal information, a list of messages, notifications, and posts,
 * and handles various user-related activities such as managing points, messages, and notifications.
 * It also supports user authentication and role management.
 * <p>
 * The class provides methods to manage personal information, including name, age, address, and password,
 * as well as user-specific data such as program participation, dietary preferences, and restrictions.
 * </p>
 *
 * @author Ibrahim Mashaqi
 */
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
    private ArrayList<Message> messageList;
    private ArrayList<Notification> notificationList;
    private ArrayList<Post> postList;
    private Program userProgram;
    private String dietaryPreferencesUser;
    private String dietaryRestrictions;

    /**
     * Constructs a new User with the specified details.
     *
     * @param name the name of the user
     * @param age the age of the user
     * @param gender the gender of the user
     * @param address the address of the user
     * @param email the email of the user
     * @param password the password for the user
     * @param role the role of the user (e.g., Admin, Instructor, Client)
     */
    public User(String name, int age, String gender, String address, String email, String password, Role role) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.role = role;
        this.points = 0;
        this.messageList = new ArrayList<Message>();
        this.notificationList = new ArrayList<Notification>();
        this.postList = new ArrayList<Post>();
    }

    /**
     * Default constructor for User with default values.
     */
    public User() {
        this.id = idCounter++;
        this.points = 0;
        this.setAddress("");
        this.setAge(0);
        this.setPass("");
        this.setName("");
        this.messageList = new ArrayList<Message>();
        this.notificationList = new ArrayList<Notification>();
        this.postList = new ArrayList<Post>();
    }

    /**
     * Constructs a new User with the specified username and password.
     *
     * @param userName the username of the user
     * @param password the password for the user
     */
    public User(String userName, String password) {
        this.setName(userName);
        this.id = idCounter++;
        this.points = new Random().nextInt(100);
        this.setAddress("");
        this.setAge(0);
        this.setPass(password);
        this.messageList = new ArrayList<Message>();
        this.notificationList = new ArrayList<Notification>();
        this.postList = new ArrayList<Post>();
    }

    // Getters and Setters

    /**
     * Gets the points of the user.
     *
     * @return the points of the user
     */
    public int getPoints() {
        return points;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password of the user
     */
    public String getPass() {
        return password;
    }

    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age of the user.
     *
     * @return the age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the gender of the user.
     *
     * @return the gender of the user
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the address of the user.
     *
     * @return the address of the user
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the age of the user.
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to set
     */
    public void setPass(String password) {
        this.password = password;
    }

    /**
     * Sets the address of the user.
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the gender of the user.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the role of the user.
     *
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Sets the points of the user.
     *
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Gets the ID of the user.
     *
     * @return the ID of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the list of messages for the user.
     *
     * @return the list of messages
     */
    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    /**
     * Sets the list of messages for the user.
     *
     * @param messageList the list of messages to set
     */
    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    /**
     * Gets the list of notifications for the user.
     *
     * @return the list of notifications
     */
    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }

    /**
     * Sets the list of notifications for the user.
     *
     * @param notificationList the list of notifications to set
     */
    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    /**
     * Gets the list of posts for the user.
     *
     * @return the list of posts
     */
    public ArrayList<Post> getPostList() {
        return postList;
    }

    /**
     * Sets the list of posts for the user.
     *
     * @param postList the list of posts to set
     */
    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    /**
     * Gets the program associated with the user.
     *
     * @return the program
     */
    public Program getUserProgram() {
        return userProgram;
    }

    /**
     * Sets the program associated with the user.
     *
     * @param userProgram the program to set
     */
    public void setUserProgram(Program userProgram) {
        this.userProgram = userProgram;
    }

    /**
     * Gets the dietary preferences of the user.
     *
     * @return the dietary preferences
     */
    public String getDietaryPreferencesUser() {
        return dietaryPreferencesUser;
    }

    /**
     * Sets the dietary preferences of the user.
     *
     * @param dietaryPreferencesUser the dietary preferences to set
     */
    public void setDietaryPreferencesUser(String dietaryPreferencesUser) {
        this.dietaryPreferencesUser = dietaryPreferencesUser;
    }

    /**
     * Gets the dietary restrictions of the user.
     *
     * @return the dietary restrictions
     */
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    /**
     * Sets the dietary restrictions of the user.
     *
     * @param dietaryRestrictions the dietary restrictions to set
     */
    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }

    /**
     * Adds a new message to the user's message list if it doesn't already exist.
     *
     * @param message the message to be added
     * @return true if the message was added, false if it already exists
     */
    public boolean addMessage(Message message) {
        if (!messageList.contains(message)) {
            messageList.add(message);
            return true;
        }
        return false;
    }

    /**
     * Removes a message from the user's message list.
     *
     * @param message the message to be removed
     * @return true if the message was removed, false if it wasn't found
     */
    public boolean removeMessage(Message message) {
        if (messageList.contains(message)) {
            messageList.remove(message);
            return true;
        }
        return false;
    }

    /**
     * Adds a new notification to the user's notification list if it doesn't already exist.
     *
     * @param notification the notification to be added
     * @return true if the notification was added, false if it already exists
     */
    public boolean addNotification(Notification notification) {
        if (!notificationList.contains(notification)) {
            notificationList.add(notification);
            return true;
        }
        return false;
    }

    /**
     * Removes a notification from the user's notification list.
     *
     * @param notification the notification to be removed
     * @return true if the notification was removed, false if it wasn't found
     */
    public boolean removeNotification(Notification notification) {
        if (notificationList.contains(notification)) {
            notificationList.remove(notification);
            return true;
        }
        return false;
    }

    /**
     * Adds a new post to the user's post list if it doesn't already exist.
     *
     * @param post the post to be added
     * @return true if the post was added, false if it already exists
     */
    public boolean addPost(Post post) {
        if (!postList.contains(post)) {
            postList.add(post);
            return true;
        }
        return false;
    }

    /**
     * Removes a post from the user's post list.
     *
     * @param post the post to be removed
     * @return true if the post was removed, false if it wasn't found
     */
    public boolean removePost(Post post) {
        if (postList.contains(post)) {
            postList.remove(post);
            return true;
        }
        return false;
    }

    /**
     * Increments the user's points by one.
     */
    public void incPoints() {
        this.points++;
    }

    /**
     * Returns a string representation of the user, including personal and account details.
     *
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address +
                ", email=" + email + ", password=" + password + ", role=" + role + "]";
    }
}
