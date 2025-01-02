package Fitness.AdminPackage;

/**
 * Enum representing the different roles in the fitness system.
 * The roles define the types of users within the system, each with different permissions and responsibilities.
 * <ul>
 *     <li>{@link Role#Admin} - Represents an admin user with full access and control.</li>
 *     <li>{@link Role#Instructor} - Represents an instructor user who manages programs and discussions.</li>
 *     <li>{@link Role#Client} - Represents a client user who participates in programs and discussions.</li>
 * </ul>
 *
 * @author Ibrahim Mashaqi
 */
public enum Role {
    /** Role for an admin with full system access and control. */
    Admin,

    /** Role for an instructor who manages programs and discussions. */
    Instructor,

    /** Role for a client who participates in programs and discussions. */
    Client;
}
