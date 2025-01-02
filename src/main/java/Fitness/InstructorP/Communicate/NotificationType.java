package Fitness.InstructorP.Communicate;

/**
 * Enum representing the different types of notifications in the system.
 * These types define the categories of notifications that can be sent or received within the fitness system.
 *
 * <p>The available notification types are:</p>
 * <ul>
 *     <li><b>Message</b> - Represents a general message notification.</li>
 *     <li><b>CreateProgram</b> - Represents a notification related to creating a new program.</li>
 *     <li><b>Post</b> - Represents a notification related to a new post.</li>
 *     <li><b>Comment</b> - Represents a notification related to a new comment.</li>
 *     <li><b>Report</b> - Represents a notification related to a new report.</li>
 *     <li><b>Reply</b> - Represents a notification related to a reply to a message or post.</li>
 * </ul>
 *
 * Example usage:
 * <pre>
 * NotificationType type = NotificationType.Message;
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public enum NotificationType
{
    /**
     * Represents a direct message notification.
     */
    Message,

    /**
     * Represents a notification for the creation of a new fitness program.
     */
    CreateProgram,

    /**
     * Represents a notification for a new post on the platform.
     */
    Post,

    /**
     * Represents a notification for a new comment on a post or program.
     */
    Comment,

    /**
     * Represents a notification for a reported issue or violation.
     */
    Report,

    /**
     * Represents a notification for a reply to a message or comment.
     */
    Reply
}
