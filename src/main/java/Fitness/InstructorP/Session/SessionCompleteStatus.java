package Fitness.InstructorP.Session;

/**
 * The {@code SessionCompleteStatus} enum represents the different possible states of a fitness session.
 * It helps track the progress of a session, whether it's completed, in progress, or not started yet.
 *
 * @author Omar Abumazen
 */
public enum SessionCompleteStatus
{
    /**
     * Indicates that the session has been completed.
     */
    completed,

    /**
     * Indicates that the session is currently in progress.
     */
    inProgress,

    /**
     * Indicates that the session has not been started yet.
     */
    notStarted;
}
