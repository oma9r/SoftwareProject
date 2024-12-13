package Fitness.InstructorP.Communicate;

import Fitness.Role;
import Fitness.User;

public class Message
{
    private User messageAuthor;
    private String messageTitle;
    private String messageContent;
    private String messageTime;
    private String messageDate;
    private String messageDay;
    private Role authorRole;
    private MessageType messageType;


    public Message()
    {
        this.setMessageAuthor(null);
        this.setMessageTitle(null);
        this.setMessageContent(null);
        this.setMessageTime(null);
        this.setMessageDate(null);
        this.setMessageDay(null);
        this.setRole(null);
        this.setMessageType(null);

    }

    public Message(User messageAuthor, String messageContent,Role authorRole,MessageType messageType)
    {
        this.setMessageAuthor(messageAuthor);
        this.setMessageContent(messageContent);
        this.setMessageTitle(null);
        this.setMessageTime(null);
        this.setMessageDate(null);
        this.setMessageDay(null);
        this.setRole(authorRole);
        this.setMessageType(messageType);
    }

    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
    public void setMessageDay(String messageDay) {
        this.messageDay = messageDay;
    }
    public User getMessageAuthor() {
        return messageAuthor;
    }
    public String getMessageTitle() {
        return messageTitle;
    }
    public String getMessageContent() {
        return messageContent;
    }
    public String getMessageTime() {
        return messageTime;
    }
    public String getMessageDate() {
        return messageDate;
    }
    public String getMessageDay() {
        return messageDay;
    }
    public Role getRole() {
        return authorRole;
    }
    public void setRole(Role role) {
        this.authorRole = role;
    }

    public MessageType getMessageType() {
        return messageType;
    }
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

}
