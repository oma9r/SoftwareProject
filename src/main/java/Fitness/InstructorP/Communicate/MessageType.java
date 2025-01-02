package Fitness.InstructorP.Communicate;

/**
 * The {@code MessageType} enum represents the type of message
 * in a communication system. It defines two possible types:
 * <ul>
 *     <li>{@code sent} - Represents a message that has been sent.</li>
 *     <li>{@code received} - Represents a message that has been received.</li>
 * </ul>
 * This enum can be used to categorize messages based on their direction in the system.
 *
 * <p>Example usage:</p>
 * <pre>
 * MessageType type = MessageType.sent;
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public enum MessageType
{
    /**
     * Represents a message that has been sent.
     */
    sent,

    /**
     * Represents a message that has been received.
     */
    received
}
