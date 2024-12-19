package Fitness.InstructorP.ProgramPackage;

import Fitness.AdminPackage.Application;
import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;
import Fitness.InstructorP.DiscussionFromP.DiscussionForm;
import Fitness.InstructorP.Reports.Report;
import Fitness.InstructorP.Session.Session;

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
    private ArrayList<Session> sessions;
    private int numberOfSessions;
    private Instructor instructorProgram;
    private ProgramStatus programStatus;
    private String tutorialType;
    private ArrayList<DiscussionForm> discussionForms;
    private ArrayList<Client> ClientsList;
    private ArrayList<Report> reportList;
    float revenue;
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
        this.sessions = new ArrayList<Session>();
        this.numberOfSessions = 0;
        instructorProgram = new Instructor();
        this.instructorProgram = null;
        this.programStatus = null;
        this.setTutorialType("");
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);
        this.setNumberOfSessions(0);
        this.discussionForms = new ArrayList<DiscussionForm>();
        this.ClientsList = new ArrayList<Client>();
        this.reportList = new ArrayList<Report>();
         revenue = 0;





    }

//user defined constructor
    public Program(String title, String duration, String level, String goals,String tutorialType, String price,ProgramStatus programStatus,Instructor instructorProgram1)
    {

        this.setProgramTitle(title);
        this.setProgramDuration(duration);
        this.setProgramLevel(level);
        this.setProgramGoals(goals);
        this.setProgramPrice(price);
        this.sessions = new ArrayList<Session>();
        this.numberOfSessions = 0;
        instructorProgram = new Instructor();
        this.instructorProgram.setName(instructorProgram1.getName());
        this.programStatus = programStatus;
        this.setTutorialType(tutorialType);
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);
        this.setNumberOfSessions(0);
        this.discussionForms = new ArrayList<DiscussionForm>();
        this.ClientsList = new ArrayList<Client>();
        this.reportList = new ArrayList<Report>();
        revenue = 0;







    }

    public Program(String programTitle,String programDuration,String programLevel,String programGoals)
    {
        this.setProgramTitle(programTitle);
        this.setProgramDuration(programDuration);
        this.setProgramLevel(programLevel);
        this.setProgramGoals(programGoals);
        this.setProgramPrice("");
        this.sessions = new ArrayList<Session>();
        this.numberOfSessions = 0;
        this.instructorProgram = null;
        this.programStatus = null;
        this.setTutorialType("");
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);
        this.setNumberOfSessions(0);
        this.discussionForms = new ArrayList<DiscussionForm>();
        this.ClientsList = new ArrayList<Client>();
        this.reportList = new ArrayList<Report>();
        revenue = 0;
    }

    public Program(DiscussionForm discussionForm)
    {
        this.setProgramTitle("");
        this.setProgramDuration("");
        this.setProgramLevel("");
        this.setProgramGoals("");
        this.setProgramPrice("");
        this.sessions = new ArrayList<Session>();
        this.numberOfSessions = 0;
        instructorProgram = new Instructor();
        this.instructorProgram = null;
        this.programStatus = null;
        this.setTutorialType("");
        Application.currentProgramId++;
        this.setIdProgram(Application.currentProgramId);
        this.setNumberOfSessions(0);
        this.discussionForms = new ArrayList<DiscussionForm>();
        this.setDiscussionForms(discussionForms);
        this.ClientsList = new ArrayList<Client>();
        this.reportList = new ArrayList<Report>();
        revenue = 0;
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


    public ArrayList<Session> getSessions() {
        return sessions;
    }
    public void setSessions(ArrayList<Session> sessions) {
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

    public void setDiscussionForms(ArrayList<DiscussionForm> discussionForms)
    {
        this.discussionForms = discussionForms;
    }

    public ArrayList<DiscussionForm> getDiscussionForms()
    {
        return discussionForms;
    }

    public ArrayList<Client> getClientsList()
    {
        return this.ClientsList;
    }

    public void setClientsList(ArrayList<Client> clientsList) {
        this.ClientsList = clientsList;
    }

    public ArrayList<Report> getReportList() {
        return reportList;
    }
    public void setReportList(ArrayList<Report> reportList) {
        this.reportList = reportList;
    }

    public boolean addClient(Client client)
    {
        if(!this.ClientsList.contains(client))
        {
            this.ClientsList.add(client);
            return true;
        }
        else
            return false;
    }

    public boolean removeClient(Client client)
    {
        if(this.ClientsList.contains(client))
        {
            this.ClientsList.remove(client);
            return true;
        }
        else
            return false;
    }

    public boolean addSession(Session session)
    {

        if(!this.sessions.contains(session))
        {
            this.sessions.add(session);
            return true;
        }
        else
            return false;

    }

    public boolean removeSession(Session session)
    {

        if(this.sessions.contains(session))
        {
            this.sessions.remove(session);
            return true;
        }
        else
            return false;
    }

    public boolean addDiscussionForm(DiscussionForm discussionForm)
    {
        if(!this.discussionForms.contains(discussionForm))
        {
            this.discussionForms.add(discussionForm);
            return true;
        }
        return false;
    }

    public boolean removeDiscussionForm(DiscussionForm discussionForm)
    {
        if(this.discussionForms.contains(discussionForm))
        {
            this.discussionForms.remove(discussionForm);
            return true;
        }
        return false;
    }

    public boolean addReport(Report report)
    {
        if(!this.reportList.contains(report))
        {
            this.reportList.add(report);
            return true;
        }
        return false;

    }

    public boolean removeReport(Report report)
    {
        if(this.reportList.contains(report))
        {
            this.reportList.remove(report);
            return true;
        }
        return false;
    }

    public float getRevenue() {
        return revenue;
    }
    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public void setProgramStatus(ProgramStatus programStatus)
    {
        this.programStatus = programStatus;
    }
    public ProgramStatus getProgramStatus()
    {
        return programStatus;
    }




}
