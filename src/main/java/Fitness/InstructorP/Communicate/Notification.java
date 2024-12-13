package Fitness.InstructorP.Communicate;

import Fitness.Role;
import Fitness.User;

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

    public Notification(User NotificationAuthor, String NotificationContent,Role authorRole,NotificationType NotificationType)
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



    public void setNotificationAuthor(User NotificationAuthor) {
        this.NotificationAuthor = NotificationAuthor;
    }
    public void setNotificationTitle(String NotificationTitle) {
        this.NotificationTitle = NotificationTitle;
    }
    public void setNotificationContent(String NotificationContent) {
        this.NotificationContent = NotificationContent;
    }
    public void setNotificationTime(String NotificationTime) {
        this.NotificationTime = NotificationTime;
    }
    public void setNotificationDate(String NotificationDate) {
        this.NotificationDate = NotificationDate;
    }
    public void setNotificationDay(String NotificationDay) {
        this.NotificationDay = NotificationDay;
    }
    public User getNotificationAuthor() {
        return NotificationAuthor;
    }
    public String getNotificationTitle() {
        return NotificationTitle;
    }
    public String getNotificationContent() {
        return NotificationContent;
    }
    public String getNotificationTime() {
        return NotificationTime;
    }
    public String getNotificationDate() {
        return NotificationDate;
    }
    public String getNotificationDay() {
        return NotificationDay;
    }
    public Role getRole() {
        return authorRole;
    }
    public void setRole(Role role) {
        this.authorRole = role;
    }

    public NotificationType getNotificationType() {
        return NotificationType;
    }
    public void setNotificationType(NotificationType NotificationType) {
        this.NotificationType = NotificationType;
    }

}
