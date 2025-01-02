package Fitness.InstructorP.Communicate;

import Fitness.AdminPackage.Role;
import Fitness.AdminPackage.User;

/**
 * The {@code Notification} class represents a notification sent by a {@code User}, typically an instructor, to notify others.
 * It contains details such as the notification author, title, content, time, date, and the role of the author.
 * The notification can also have a specific type, defined by the {@code NotificationType}.
 *
 * <p>This class provides methods to set and get the notification's details, including:
 * <ul>
 *     <li>Author of the notification</li>
 *     <li>Title and content of the notification</li>
 *     <li>Time, date, and day when the notification was created</li>
 *     <li>Role of the author and type of the notification</li>
 * </ul>
 *
 * Example usage:
 * <pre>
 * User author = new User(...);
 * Notification notification = new Notification(author, "Content of the notification", Role.INSTRUCTOR, NotificationType.INFO);
 * notification.setNotificationTitle("New Announcement");
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class Notification
{
    private User NotificationAuthor;
    private String NotificationTitle;
    private String NotificationContent;
    private String NotificationTime;
    private String NotificationDate;
    private String NotificationDay;
    private Role authorRole;
    private NotificationType NotificationType;

    /**
     * Default constructor that initializes all fields to {@code null}.
     */
    public Notification()
    {
        this.setNotificationAuthor(null);
        this.setNotificationTitle(null);
        this.setNotificationContent(null);
        this.setNotificationTime(null);
        this.setNotificationDate(null);
        this.setNotificationDay(null);
        this.setRole(null);
        this.setNotificationType(null);
    }

    /**
     * Constructs a new {@code Notification} with the given author, content, role, and type.
     * The title, time, date, and day are initialized to {@code null}.
     *
     * @param NotificationAuthor The user who authored the notification
     * @param NotificationContent The content of the notification
     * @param authorRole The role of the author (e.g., INSTRUCTOR)
     * @param NotificationType The type of the notification (e.g., INFO)
     */
    public Notification(User NotificationAuthor, String NotificationContent, Role authorRole, NotificationType NotificationType)
    {
        this.setNotificationAuthor(NotificationAuthor);
        this.setNotificationContent(NotificationContent);
        this.setNotificationTitle(null);
        this.setNotificationTime(null);
        this.setNotificationDate(null);
        this.setNotificationDay(null);
        this.setRole(authorRole);
        this.setNotificationType(NotificationType);
    }

    // Getter and setter methods

    /**
     * Sets the author of the notification.
     *
     * @param NotificationAuthor The user to be set as the author
     */
    public void setNotificationAuthor(User NotificationAuthor) {
        this.NotificationAuthor = NotificationAuthor;
    }

    /**
     * Sets the title of the notification.
     *
     * @param NotificationTitle The title to be set
     */
    public void setNotificationTitle(String NotificationTitle) {
        this.NotificationTitle = NotificationTitle;
    }

    /**
     * Sets the content of the notification.
     *
     * @param NotificationContent The content to be set
     */
    public void setNotificationContent(String NotificationContent) {
        this.NotificationContent = NotificationContent;
    }

    /**
     * Sets the time of the notification.
     *
     * @param NotificationTime The time to be set
     */
    public void setNotificationTime(String NotificationTime) {
        this.NotificationTime = NotificationTime;
    }

    /**
     * Sets the date of the notification.
     *
     * @param NotificationDate The date to be set
     */
    public void setNotificationDate(String NotificationDate) {
        this.NotificationDate = NotificationDate;
    }

    /**
     * Sets the day of the notification.
     *
     * @param NotificationDay The day to be set
     */
    public void setNotificationDay(String NotificationDay) {
        this.NotificationDay = NotificationDay;
    }

    /**
     * Returns the author of the notification.
     *
     * @return The author of the notification
     */
    public User getNotificationAuthor() {
        return NotificationAuthor;
    }

    /**
     * Returns the title of the notification.
     *
     * @return The title of the notification
     */
    public String getNotificationTitle() {
        return NotificationTitle;
    }

    /**
     * Returns the content of the notification.
     *
     * @return The content of the notification
     */
    public String getNotificationContent() {
        return NotificationContent;
    }

    /**
     * Returns the time when the notification was created.
     *
     * @return The time of the notification
     */
    public String getNotificationTime() {
        return NotificationTime;
    }

    /**
     * Returns the date when the notification was created.
     *
     * @return The date of the notification
     */
    public String getNotificationDate() {
        return NotificationDate;
    }

    /**
     * Returns the day when the notification was created.
     *
     * @return The day of the notification
     */
    public String getNotificationDay() {
        return NotificationDay;
    }

    /**
     * Returns the role of the notification's author.
     *
     * @return The role of the author
     */
    public Role getRole() {
        return authorRole;
    }

    /**
     * Sets the role of the notification's author.
     *
     * @param role The role to be set for the author
     */
    public void setRole(Role role) {
        this.authorRole = role;
    }

    /**
     * Returns the type of the notification.
     *
     * @return The type of the notification
     */
    public NotificationType getNotificationType() {
        return NotificationType;
    }

    /**
     * Sets the type of the notification.
     *
     * @param NotificationType The type of the notification to be set
     */
    public void setNotificationType(NotificationType NotificationType) {
        this.NotificationType = NotificationType;
    }
}
