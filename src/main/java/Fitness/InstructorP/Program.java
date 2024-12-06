package Fitness.InstructorP;

import Fitness.Application;
import Fitness.Instructor;

import java.util.ArrayList;

public class Program
{
    private String programTitle;
    private String programDuration;
    private String programLevel;
    private String programGoals;
    private tutorialTypeProgram programTutorialType;              //compare with tutorialTypeProgram - video,image or document
    private String programPrice;
    private int idProgram;
    private ArrayList sessions;
    private int numberOfSessions;
    private Instructor instructorProgram;
    private ProgramStatus programStatus;
    private String tutorialType;

;

    //7 variables



//default constructor
    public Program()
    {
        this.setProgramTitle("");
        this.setProgramDuration("");
        this.setProgramLevel("");
        this.setProgramGoals("");
        this.setProgramPrice("");
        this.sessions = new ArrayList();
        this.numberOfSessions = 0;
        this.instructorProgram = null;
        this.programStatus = null;
        this.setTutorialType("");
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);





    }

//user defined constructor
    public Program(String title, String duration, String level, String goals,String tutorialType, String price,ProgramStatus programStatus,Instructor instructorProgram)
    {

        this.setProgramTitle(title);
        this.setProgramDuration(duration);
        this.setProgramLevel(level);
        this.setProgramGoals(goals);
        this.setProgramPrice(price);
        this.sessions = new ArrayList();
        this.numberOfSessions = 0;
        this.instructorProgram.setName(instructorProgram.getName());
        this.programStatus = programStatus;
        this.setTutorialType(tutorialType);
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);







    }

    public Program(String programTitle,String programDuration,String programLevel,String programGoals)
    {
        this.setProgramTitle(programTitle);
        this.setProgramDuration(programDuration);
        this.setProgramLevel(programLevel);
        this.setProgramGoals(programGoals);
        this.setProgramPrice("");
        this.sessions = new ArrayList();
        this.numberOfSessions = 0;
        this.instructorProgram = null;
        this.programStatus = null;
        this.setTutorialType("");
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);
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

    public String getProgramPrice() {
        return programPrice;
    }
    public void setProgramPrice(String programPrice) {
        this.programPrice = programPrice;
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

    public String getInstructorProgramName() {

        return instructorProgram.getName();
    }

    public void setInstructorProgram(Instructor instructorProgram) {

        this.instructorProgram.setName(instructorProgram.getName());
;    }

    public String getTutorialType() {
        return tutorialType;
    }
    public void setTutorialType(String tutorialType) {
        this.tutorialType = tutorialType;
    }

    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }

    public int getIdProgram() {
        return idProgram;
    }

    public void setProgramTutorialType(tutorialTypeProgram programTutorialType)
    {
        this.programTutorialType = programTutorialType;
    }
    public tutorialTypeProgram getProgramTutorialType() {
        return programTutorialType;
    }


}
