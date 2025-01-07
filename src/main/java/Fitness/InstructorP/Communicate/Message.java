/**
 * Represents a message in the system, including metadata such as author, title, content, and timing details.
 */
package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Role;
import Fitness.AdminPackage.User;

public class Message {

    /**
     * The author of the message.
     */
    private User messageAuthor;

    /**
     * The title of the message.
     */
    private String messageTitle;

    /**
     * The content of the message.
     */
    private String messageContent;

    /**
     * The time the message was sent.
     */
    private String messageTime;

    /**
     * The date the message was sent.
     */
    private String messageDate;

    /**
     * The day the message was sent.
     */
    private String messageDay;

    /**
     * The role of the message author.
     */
    private Role authorRole;

    /**
     * The type of the message.
     */
    private MessageType messageType;



    /**
     * Constructor to initialize a message with the specified author, content, role, and type.
     *
     * @param messageAuthor the author of the message.
     * @param messageContent the content of the message.
     * @param authorRole the role of the message author.
     * @param messageType the type of the message.
     */
    public Message(User messageAuthor, String messageContent, Role authorRole, MessageType messageType) {
        this.setMessageAuthor(messageAuthor);
        this.setMessageContent(messageContent);
        this.setMessageTitle(null);
        this.setMessageTime(null);
        this.setMessageDate(null);
        this.setMessageDay(null);
        this.setRole(authorRole);
        this.setMessageType(messageType);
    }

    /**
     * Sets the author of the message.
     *
     * @param messageAuthor the author to set.
     */
    public void setMessageAuthor(User messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    /**
     * Sets the title of the message.
     *
     * @param messageTitle the title to set.
     */
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    /**
     * Sets the content of the message.
     *
     * @param messageContent the content to set.
     */
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    /**
     * Sets the time the message was sent.
     *
     * @param messageTime the time to set.
     */
    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    /**
     * Sets the date the message was sent.
     *
     * @param messageDate the date to set.
     */
    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    /**
     * Sets the day the message was sent.
     *
     * @param messageDay the day to set.
     */
    public void setMessageDay(String messageDay) {
        this.messageDay = messageDay;
    }

    /**
     * Gets the author of the message.
     *
     * @return the message author.
     */
    public User getMessageAuthor() {
        return messageAuthor;
    }


    /**
     * Gets the role of the message author.
     *
     * @return the author role.
     */
    public Role getRole() {
        return authorRole;
    }

    /**
     * Sets the role of the message author.
     *
     * @param role the role to set.
     */
    public void setRole(Role role) {
        this.authorRole = role;
    }


    /**
     * Sets the type of the message.
     *
     * @param messageType the message type to set.
     */
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}
