package Fitness.InstructorP;

import java.util.ArrayList;

public class Program
{
    private String programTitle;
    private String programDuration;
    private String programLevel;
    private String programGoals;
    private String programTutorialType;              //compare with tutorialTypeProgram - video,image or document
    private String programPrice;
    private int idProgram;
    private ArrayList sessions;
    private int numberOfSessions;


    //7 variables



//default constructor
    public Program()
    {
        this.setProgramTitle("");
        this.setProgramDuration("");
        this.setProgramLevel("");
        this.setProgramGoals("");
        this.setProgramTutorialType("");
        this.setProgramPrice("");
        this.setIdProgram(0);
        this.sessions = new ArrayList();
        this.numberOfSessions = 0;

    }

//user defined constructor
    public Program(int idProgram, String title, String duration, String level, String goals, String tutorial, String price, int numberOfSessions, ArrayList sessions)
    {

        this.setProgramTitle(title);
        this.setProgramDuration(duration);
        this.setProgramLevel(level);
        this.setProgramGoals(goals);
        this.setProgramTutorialType(tutorial);
        this.setProgramPrice(price);
        this.setIdProgram(idProgram);
        this.sessions = new ArrayList();
        this.numberOfSessions = numberOfSessions;
        this.sessions = sessions;


    }

    //setter and getter methods

    public String getProgramTitle()
    {
        return programTitle;
    }

    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }
    public String getProgramDuration() {
        return programDuration;
    }
    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }
    public String getProgramLevel() {
        return programLevel;
    }
    public void setProgramLevel(String programLevel) {
        this.programLevel = programLevel;
    }
    public String getProgramGoals() {
        return programGoals;
    }
    public void setProgramGoals(String programGoals) {
        this.programGoals = programGoals;
    }
    public String getProgramTutorialType() {
        return programTutorialType;
    }
    public void setProgramTutorialType(String programTutorialType) {
        this.programTutorialType = programTutorialType;
    }
    public String getProgramPrice() {
        return programPrice;
    }
    public void setProgramPrice(String programPrice) {
        this.programPrice = programPrice;
    }
    public int getIdProgram() {
        return idProgram;
    }
    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public ArrayList getSessions() {
        return sessions;
    }
    public void setSessions(ArrayList sessions) {
        this.sessions = sessions;
    }
    public int getNumberOfSessions() {
        return numberOfSessions;
    }
    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }



}
