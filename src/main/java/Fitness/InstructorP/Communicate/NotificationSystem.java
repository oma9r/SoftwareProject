package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;

import java.util.ArrayList;

/**
 * The {@code NotificationSystem} class manages notifications for both the instructor and the clients.
 * It stores lists of notifications for the instructor and clients, and provides methods to add or remove
 * notifications and clients. The system allows for specific notifications to be added to either the instructor
 * or client notification lists, as well as managing all notifications in a central list.
 *
 * <p>This class provides the following features:
 * <ul>
 *     <li>Ability to add or remove notifications for both instructors and clients</li>
 *     <li>Manage a list of clients associated with the instructor</li>
 *     <li>Access to the list of all notifications and specific notification lists for the instructor and clients</li>
 * </ul>
 *
 * Example usage:
 * <pre>
 * Instructor instructor = new Instructor(...);
 * Client client = new Client(...);
 * NotificationSystem system = new NotificationSystem();
 * system.addClient(client);
 * Notification notification = new Notification(...);
 * system.addNotification(notification);
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class NotificationSystem
{
    private Instructor instructor;
    private ArrayList<Client> clientList;
    private ArrayList<Notification> instructorNotificationList;
    private ArrayList<Notification> clientNotificationList;
    private ArrayList<Notification> NotificationsList;

    /**
     * Default constructor that initializes the instructor and the lists of notifications and clients.
     */
    public NotificationSystem()
    {
        instructor = new Instructor();
        this.clientList = new ArrayList<Client>();
        this.NotificationsList = new ArrayList<Notification>();
        this.instructorNotificationList = new ArrayList<Notification>();
        this.clientNotificationList = new ArrayList<Notification>();
    }

    // Setter and getter methods for instructor, clients, and notifications

    /**
     * Sets the list of clients for the system.
     *
     * @param client The list of clients to set
     */
    public void setClient(ArrayList<Client> client) {
        this.clientList = client;
    }

    /**
     * Sets the instructor for the system.
     *
     * @param instructor The instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Gets the instructor associated with the system.
     *
     * @return The instructor
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Gets the list of clients in the system.
     *
     * @return The list of clients
     */
    public ArrayList<Client> getClient() {
        return this.clientList;
    }

    /**
     * Gets the list of notifications for the instructor.
     *
     * @return The list of instructor notifications
     */
    public ArrayList<Notification> getInstructorNotificationList() {
        return this.instructorNotificationList;
    }



    /**
     * Gets the list of notifications for the clients.
     *
     * @return The list of client notifications
     */
    public ArrayList<Notification> getClientNotificationList() {
        return this.clientNotificationList;
    }



    /**
     * Gets the list of all notifications in the system.
     *
     * @return The list of all notifications
     */
    public ArrayList<Notification> getNotificationsList() {
        return this.NotificationsList;
    }



    // Methods to add and remove notifications

    /**
     * Adds a new notification to the system.
     *
     * @param Notification The notification to add
     * @return {@code true} if the notification was added successfully, {@code false} otherwise
     */
    public boolean addNotification(Notification Notification) {
        if (!this.NotificationsList.contains(Notification)) {
            this.NotificationsList.add(Notification);
            return true;
        }
        return false;
    }



    /**
     * Adds a notification specifically for a client.
     *
     * @param Notification The notification to add
     * @return {@code true} if the notification was added successfully, {@code false} otherwise
     */
    public boolean addClientNotification(Notification Notification) {
        if (!this.clientNotificationList.contains(Notification)) {
            this.clientNotificationList.add(Notification);
            return true;
        }
        return false;
    }



    /**
     * Adds a notification specifically for an instructor.
     *
     * @param Notification The notification to add
     * @return {@code true} if the notification was added successfully, {@code false} otherwise
     */
    public boolean addInstructorNotification(Notification Notification) {
        if (!this.instructorNotificationList.contains(Notification)) {
            this.instructorNotificationList.add(Notification);
            return true;
        }
        return false;
    }



    // Methods to add and remove clients

    /**
     * Adds a new client to the system.
     *
     * @param Client The client to add
     * @return {@code true} if the client was added successfully, {@code false} otherwise
     */
    public boolean addClient(Client Client) {
        if (!this.clientList.contains(Client)) {
            this.clientList.add(Client);
            return true;
        }
        return false;
    }


}
