package Fitness.AdminPackage;

import Fitness.InstructorP.Communicate.Message;
import Fitness.InstructorP.Communicate.Notification;
import Fitness.InstructorP.DiscussionFromP.Post;
import Fitness.InstructorP.ProgramPackage.Program;

import java.util.ArrayList;
import java.util.Random;

public class User
{
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

    public User( String name, int age, String gender, String address, String email, String password, Role role)
    {
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

    public User()
    {
        this.id = idCounter++;
        this.points =  0;
        this.setAddress("");
        this.setAge(0);
        this.setPass("");
        this.setName("");
        this.messageList = new ArrayList<Message>();
        this.notificationList = new ArrayList<Notification>();
        this.postList = new ArrayList<Post>();
    }


    public User(String userName,String password)
    {
        this.setName(userName);
        this.id = idCounter++;
        this.points=new Random().nextInt(100);
        this.setAddress("");
        this.setAge(0);
        this.setPass(password);
        this.messageList = new ArrayList<Message>();
        this.notificationList = new ArrayList<Notification>();
        this.postList = new ArrayList<Post>();

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
    public void setAge(int age) {
        this.age = age;
    }
    public void setPass(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setName(String name) {this.name = name;}

    public void setGender(String gender) {this.gender = gender;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(Role role) {this.role = role;}
    public void setPoints(int points) {this.points = points;}
    public int getId() {
        return id;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }
    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }
    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }
    public ArrayList<Post> getPostList() {
        return postList;
    }
    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public Program getUserProgram() {
        return userProgram;
    }
    public void setUserProgram(Program userProgram) {
        this.userProgram = userProgram;
    }

    public String getDietaryPreferencesUser() {
        return dietaryPreferencesUser;
    }
    public void setDietaryPreferencesUser(String dietaryPreferencesUser) {
        this.dietaryPreferencesUser = dietaryPreferencesUser;
    }

    public void setDietaryRestrictions(String dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
    public String getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public boolean addMessage(Message message)
    {
        if(!messageList.contains(message))
        {
            messageList.add(message);
            return true;
        }
        return false;
    }

    public boolean removeMessage(Message message)
    {
        if(messageList.contains(message))
        {
            messageList.remove(message);
            return true;
        }
        return false;

    }

    public boolean addNotification(Notification notification)
    {
        if(!notificationList.contains(notification))
        {
            notificationList.add(notification);
            return true;
        }
        return false;
    }

    public boolean removeNotification(Notification notification)
    {
        if(notificationList.contains(notification))
        {
            notificationList.remove(notification);
            return true;
        }
        return false;
    }

    public boolean addPost(Post post)
    {
        if(!postList.contains(post))
        {
            postList.add(post);
            return true;
        }
        return false;
    }

    public boolean removePost(Post post)
    {
        if(postList.contains(post))
        {
            postList.remove(post);
            return true;
        }
        return false;
    }




    public void incPoints() {
        this.points++;
    }

    @Override
    public String toString()
    {
        return "[id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender+", address=" + address + ", email=" + email + ", password=" + password + ", role=" + role + "]";
    }





}//end of class




