package Fitness.InstructorP.Session;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * The {@code Session} class represents a session in the fitness program.
 * It holds information about the session's ID, name, date, day, time, type, status, and associated clients.
 * This class also provides methods for validating session dates and managing session data.
 *
 * @author Omar Abumazen
 */
public class Session
{
    private String sessionID;
    private String sessionName;
    private String sessionDate;
    private String sessionDay; // Friday and Tuesday are holidays
    private String sessionTime;
    private String sessionType; // Online or offline
    private SessionCompleteStatus sessionStatus; // Complete or not
    private List<Client> clientList;



    /**
     * Constructs a new {@code Session} with specified session ID, name, date, day, time, and type.
     *
     * @param sessionID   The unique ID for the session.
     * @param sessionName The name of the session.
     * @param sessionDate The date of the session.
     * @param sessionDay  The day of the session.
     * @param sessionTime The time of the session.
     * @param sessionType The type of session (online or offline).
     */
    public Session(String sessionID, String sessionName, String sessionDate, String sessionDay, String sessionTime, String sessionType)
    {
        this.setSessionID(sessionID);
        this.setSessionName(sessionName);
        this.setSessionDay(sessionDay);
        this.setSessionTime(sessionTime);
        this.setSessionType(sessionType);
        this.setSessionDate(sessionDate);
    }

    /**
     * Constructs a new {@code Session} with specified session date, day, and type.
     *
     * @param sessionDate The date of the session.
     * @param sessionDay  The day of the session.
     * @param sessionType The type of session (online or offline).
     */
    public Session(String sessionDate, String sessionDay, String sessionType)
    {
        this.setSessionDate(sessionDate);
        this.setSessionType(sessionType);
        this.setSessionDay(sessionDay);
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionType("");
    }

    /**
     * Constructs a new {@code Session} with only the specified session date.
     *
     * @param sessionDate The date of the session.
     */
    public Session(String sessionDate)
    {
        this.setSessionDate(sessionDate);
        this.setSessionDay("");
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionType("");
        this.setSessionTime("");
    }

    /**
     * Gets the session ID.
     *
     * @return The session ID.
     */
    public String getSessionID()
    {
        return sessionID;
    }

    /**
     * Sets the session ID.
     *
     * @param sessionID The session ID.
     */
    public void setSessionID(String sessionID)
    {
        this.sessionID = sessionID;
    }

    /**
     * Gets the session name.
     *
     * @return The session name.
     */
    public String getSessionName()
    {
        return sessionName;
    }

    /**
     * Sets the session name.
     *
     * @param sessionName The session name.
     */
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }



    /**
     * Sets the session day.
     *
     * @param sessionDay The session day.
     */
    public void setSessionDay(String sessionDay) {
        this.sessionDay = sessionDay;
    }



    /**
     * Sets the session time.
     *
     * @param sessionTime The session time.
     */
    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    /**
     * Gets the session type (online or offline).
     *
     * @return The session type.
     */
    public String getSessionType() {
        return sessionType;
    }

    /**
     * Sets the session type (online or offline).
     *
     * @param sessionType The session type.
     */
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * Sets the session date.
     *
     * @param sessionDate The session date.
     */
    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }

    /**
     * Gets the session date.
     *
     * @return The session date.
     */
    public String getSessionDate() {
        return sessionDate;
    }

    /**
     * Gets the session status (completed or not).
     *
     * @return The session status.
     */
    public SessionCompleteStatus getSessionStatus() {
        return sessionStatus;
    }




    /**
     * Gets the client list associated with the session.
     *
     * @return The client list.
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Validates if the session date is a valid future date.
     *
     * @param dateString The date string to validate.
     * @return {@code true} if the date is valid and not before today, {@code false} otherwise.
     */
    public boolean isSessionDateValid(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate inputDate = LocalDate.parse(dateString, formatter);
            LocalDate today = LocalDate.now();
            return !inputDate.isBefore(today);
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }
}
