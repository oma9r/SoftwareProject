package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;

import java.util.ArrayList;

public class MessagingSystem
{
    private Instructor instructor;
    private Client client;
    private ArrayList<Message> instructorMessageList;
    private ArrayList<Message> clientMessageList;
    private ArrayList<Message> messagesList;

    public MessagingSystem(Instructor instructor, Client client)
    {

        this.setInstructor(instructor);
        this.setClient(client);
        this.messagesList = new ArrayList<Message>();
        this.instructorMessageList = new ArrayList<Message>();
        this.clientMessageList = new ArrayList<Message>();



    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public Instructor getInstructor() {
        return this.instructor;
    }
    public Client getClient() {
        return this.client;
    }
    public ArrayList<Message> getInstructorMessageList() {
        return this.instructorMessageList;
    }
    public void setInstructorMessageList(ArrayList<Message> instructorMessageList) {
        this.instructorMessageList = instructorMessageList;
    }
    public ArrayList<Message> getClientMessageList() {
        return this.clientMessageList;
    }
    public void setClientMessageList(ArrayList<Message> clientMessageList) {
        this.clientMessageList = clientMessageList;
    }
    public ArrayList<Message> getMessagesList() {
        return this.messagesList;
    }
    public void setMessagesList(ArrayList<Message> messagesList) {
        this.messagesList = messagesList;
    }

    public boolean addMessage(Message message) {

        if(!this.messagesList.contains(message))
        {
            this.messagesList.add(message);
            return true;
        }
        return false;
    }
    public boolean removeMessage(Message message) {

        if(this.messagesList.contains(message))
        {
            this.messagesList.remove(message);
            return true;
        }
        return false;
    }

    public boolean addClientMessage(Message message) {
        if(!this.clientMessageList.contains(message))
        {
            this.clientMessageList.add(message);
            return true;
        }
        return false;
    }
    public boolean removeClientMessage(Message message) {
        if(this.clientMessageList.contains(message))
        {
            this.clientMessageList.remove(message);
            return true;
        }
        return false;
    }
    public boolean addInstructorMessage(Message message) {
        if(!this.instructorMessageList.contains(message))
        {
            this.instructorMessageList.add(message);
            return true;
        }
        return false;

    }
    public boolean removeInstructorMessage(Message message) {
        if(this.instructorMessageList.contains(message))
        {
            this.instructorMessageList.remove(message);
            return true;
        }
        return false;
    }
}
