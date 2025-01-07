package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code MessagingSystem} class facilitates communication between an {@code Instructor} and a {@code Client}.
 * It manages the message lists for both the instructor and the client, and allows adding or removing messages.
 * The system handles a list of all messages as well as separate message lists for the instructor and client.
 *
 * <p>This class provides methods to:
 * <ul>
 *     <li>Add and remove messages to/from the system</li>
 *     <li>Manage messages specific to the instructor and client</li>
 * </ul>
 *
 * Example usage:
 * <pre>
 * Instructor instructor = new Instructor(...);
 * Client client = new Client(...);
 * MessagingSystem messagingSystem = new MessagingSystem(instructor, client);
 * Message message = new Message(...);
 * messagingSystem.addMessage(message);
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class MessagingSystem
{
    private Instructor instructor;
    private Client client;
    private ArrayList<Message> instructorMessageList;
    private ArrayList<Message> clientMessageList;
    private ArrayList<Message> messagesList;

    /**
     * Constructs a new {@code MessagingSystem} for the given instructor and client.
     *
     * @param instructor The instructor involved in the messaging system
     * @param client The client involved in the messaging system
     */
    public MessagingSystem(Instructor instructor, Client client)
    {
        this.setInstructor(instructor);
        this.setClient(client);
        this.messagesList = new ArrayList<Message>();
        this.instructorMessageList = new ArrayList<Message>();
        this.clientMessageList = new ArrayList<Message>();
    }

    // Getter and setter methods

    /**
     * Sets the client for this messaging system.
     *
     * @param client The client to be set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Sets the instructor for this messaging system.
     *
     * @param instructor The instructor to be set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Returns the instructor associated with this messaging system.
     *
     * @return The instructor
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Returns the client associated with this messaging system.
     *
     * @return The client
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Returns the list of messages sent or received by the instructor.
     *
     * @return The instructor's message list
     */
    public List<Message> getInstructorMessageList() {
        return this.instructorMessageList;
    }



    /**
     * Returns the list of messages sent or received by the client.
     *
     * @return The client's message list
     */
    public ArrayList<Message> getClientMessageList() {
        return this.clientMessageList;
    }



    /**
     * Returns the list of all messages in the system.
     *
     * @return The list of all messages
     */
    public ArrayList<Message> getMessagesList() {
        return this.messagesList;
    }



    // Message management methods

    /**
     * Adds a message to the system's main message list.
     *
     * @param message The message to be added
     * @return {@code true} if the message was added successfully, {@code false} if it already exists
     */
    public boolean addMessage(Message message) {
        if(!this.messagesList.contains(message)) {
            this.messagesList.add(message);
            return true;
        }
        return false;
    }



    /**
     * Adds a message to the instructor's message list.
     *
     * @param message The message to be added
     * @return {@code true} if the message was added successfully, {@code false} if it already exists
     */
    public boolean addInstructorMessage(Message message) {
        if(!this.instructorMessageList.contains(message)) {
            this.instructorMessageList.add(message);
            return true;
        }
        return false;
    }



    /**
     * Adds a message to the client's message list.
     *
     * @param message The message to be added
     * @return {@code true} if the message was added successfully, {@code false} if it already exists
     */
    public boolean addClientMessage(Message message) {
        if(!this.clientMessageList.contains(message)) {
            this.clientMessageList.add(message);
            return true;
        }
        return false;
    }


}
