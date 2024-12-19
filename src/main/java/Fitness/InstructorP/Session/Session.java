

package Fitness.InstructorP.Session;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Session
{
    private String sessionID;
    private String sessionName;
    private String sessionDate;
    private String sessionDay;//friday and tue is holidays
    private String sessionTime;
    private String sessionType; //online or offline
    private SessionCompleteStatus sessionStatus;     //complete or not
    private List<Client> clientList;


    public Session()
    {
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionDay("");
        this.setSessionTime("");
        this.setSessionType("");
        this.setSessionDate("");
    }

    public Session(String sessionID, String sessionName,String sessionDate, String sessionDay, String sessionTime,String sessionType)
    {
        this.setSessionID(sessionID);
        this.setSessionName(sessionName);
        this.setSessionDay(sessionDay);
        this.setSessionTime(sessionTime);
        this.setSessionType(sessionType);
        this.setSessionDate(sessionDate);


    }

    public Session(String sessionDate,String sessionDay,String sessionType)
    {
        this.setSessionDate(sessionDate);
        this.setSessionType(sessionType);
        this.setSessionDay(sessionDay);
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionType("");


    }

    public Session(String sessionDate)
    {
        this.setSessionDate(sessionDate);
        this.setSessionDay("");
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionType("");
        this.setSessionTime("");
    }


    public String getSessionID()
    {
        return sessionID;
    }

    public void setSessionID(String sessionID)
    {
        this.sessionID = sessionID;
    }

    public String getSessionName()
    {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDay() {
        return sessionDay;
    }
    public void setSessionDay(String sessionDay) {
        this.sessionDay = sessionDay;
    }
    public String getSessionTime() {
        return sessionTime;
    }
    public void setSessionTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public String getSessionType() {
        return sessionType;
    }
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
    }
    public String getSessionDate() {
        return sessionDate;
    }

    public SessionCompleteStatus getSessionStatus() {
        return sessionStatus;
    }
    public void setSessionStatus(SessionCompleteStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
    public List<Client> getClientList() {
        return clientList;
    }


    public boolean isSessionDateValid(String dateString) {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

                LocalDate inputDate = LocalDate.parse(dateString, formatter);

                LocalDate today = LocalDate.now();

                return !inputDate.isBefore(today);
            }
            catch (DateTimeParseException e)
            {

                return false;
            }
        }


}
