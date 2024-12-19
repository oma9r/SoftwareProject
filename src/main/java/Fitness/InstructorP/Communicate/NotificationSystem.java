package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;

import java.util.ArrayList;

public class NotificationSystem
{
    private Instructor instructor;
    private ArrayList<Client> clientList;
    private ArrayList<Notification> instructorNotificationList;
    private ArrayList<Notification> clientNotificationList;
    private ArrayList<Notification> NotificationsList;

    public NotificationSystem()
    {

        instructor = new Instructor();
        //this.setClient(client);
        this.clientList = new ArrayList<Client>();
        this.NotificationsList = new ArrayList<Notification>();
        this.instructorNotificationList = new ArrayList<Notification>();
        this.clientNotificationList = new ArrayList<Notification>();



    }

    public void setClient(ArrayList<Client> client) {
        this.clientList = client;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public Instructor getInstructor() {
        return this.instructor;
    }
    public ArrayList<Client> getClient() {
        return this.clientList;
    }
    public ArrayList<Notification> getInstructorNotificationList() {
        return this.instructorNotificationList;
    }
    public void setInstructorNotificationList(ArrayList<Notification> instructorNotificationList) {
        this.instructorNotificationList = instructorNotificationList;
    }
    public ArrayList<Notification> getClientNotificationList() {
        return this.clientNotificationList;
    }
    public void setClientNotificationList(ArrayList<Notification> clientNotificationList) {
        this.clientNotificationList = clientNotificationList;
    }
    public ArrayList<Notification> getNotificationsList() {
        return this.NotificationsList;
    }
    public void setNotificationsList(ArrayList<Notification> NotificationsList) {
        this.NotificationsList = NotificationsList;
    }

    public boolean addNotification(Notification Notification) {

        if(!this.NotificationsList.contains(Notification))
        {
            this.NotificationsList.add(Notification);
            return true;
        }
        return false;
    }
    public boolean removeNotification(Notification Notification) {

        if(this.NotificationsList.contains(Notification))
        {
            this.NotificationsList.remove(Notification);
            return true;
        }
        return false;
    }

    public boolean addClientNotification(Notification Notification) {
        if(!this.clientNotificationList.contains(Notification))
        {
            this.clientNotificationList.add(Notification);
            return true;
        }
        return false;
    }
    public boolean removeClientNotification(Notification Notification) {
        if(this.clientNotificationList.contains(Notification))
        {
            this.clientNotificationList.remove(Notification);
            return true;
        }
        return false;
    }
    public boolean addInstructorNotification(Notification Notification) {
        if(!this.instructorNotificationList.contains(Notification))
        {
            this.instructorNotificationList.add(Notification);
            return true;
        }
        return false;

    }
    public boolean removeInstructorNotification(Notification Notification) {
        if(this.instructorNotificationList.contains(Notification))
        {
            this.instructorNotificationList.remove(Notification);
            return true;
        }
        return false;
    }

    public boolean addClient(Client Client) {
        if(!this.clientList.contains(Client))
        {
            this.clientList.add(Client);
            return true;
        }
        return false;
    }

    public boolean removeClient(Client Client) {
        if(this.clientList.contains(Client))
        {
            this.clientList.remove(Client);
            return true;
        }
        return false;
    }
}
