package Fitness.AdminPackage;

/**
 * Enum representing the different status levels for users or entities in the fitness system.
 * This enum defines whether a user or entity is currently active or inactive.
 * <ul>
 *     <li>{@link Status#Active} - Indicates that the user or entity is active and functional within the system.</li>
 *     <li>{@link Status#DeActive} - Indicates that the user or entity is inactive and not currently functional within the system.</li>
 * </ul>
 *
 * @author Ibrahim Mashaqi
 */
public enum Status {
    /** Status indicating that the user or entity is active and functional. */
    Active,

    /** Status indicating that the user or entity is inactive and not functional. */
    DeActive;
}
