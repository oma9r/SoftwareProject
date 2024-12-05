

package Fitness.InstructorP;

public class Session
{
    private String sessionID;
    private String sessionName;
    private String sessionDay;//friday and tue is holidays
    private String sessionTime;
    private String sessionLocation;
    private sessionType sessionType; //online or offline


    public Session()
    {
        this.setSessionID("");
        this.setSessionName("");
        this.setSessionDay("");
        this.setSessionTime("");
        this.setSessionLocation("");
        this.setSessionType(null);
    }

    public Session(String sessionID, String sessionName, String sessionDay, String sessionTime, String sessionLocation, sessionType sessionType)
    {
        this.setSessionID(sessionID);
        this.setSessionName(sessionName);
        this.setSessionDay(sessionDay);


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
    public String getSessionLocation() {
        return sessionLocation;
    }
    public void setSessionLocation(String sessionLocation) {
        this.sessionLocation = sessionLocation;
    }
    public sessionType getSessionType() {
        return sessionType;
    }
    public void setSessionType(sessionType sessionType) {
        this.sessionType = sessionType;
    }

}
