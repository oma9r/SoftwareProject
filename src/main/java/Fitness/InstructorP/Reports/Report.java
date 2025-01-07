package Fitness.InstructorP.Reports;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;
import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;
import Fitness.InstructorP.Session.SessionCompleteStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Report} class represents a report for a fitness program, containing details such as the associated program,
 * instructor, client, session progress, comments, and the overall session completion ratio.
 * The report can generate a summary of completed sessions and includes methods for managing comments and replies.
 *
 * @author Omar Abumazen
 */
public class Report
{
    private Program program;
    private Instructor instructor;
    private Client client;
    private ArrayList<Session> sessionList;
    private double ratioProgress;
    private ArrayList<Session> CompletedSessionList;
    private ArrayList<Comment> commentList;
    private String name;
    private String ID;
    private ArrayList<Comment> replyList;

    /**
     * Default constructor for creating a {@code Report} instance with empty lists and a ratio progress of 0.
     */
    public Report()
    {
        sessionList = new ArrayList<Session>();
        ratioProgress = 0;
        CompletedSessionList = new ArrayList<Session>();
        commentList = new ArrayList<Comment>();
        replyList = new ArrayList<Comment>();
    }

    /**
     * Sets the client associated with this report.
     *
     * @param client the client for this report
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Sets the program associated with this report.
     *
     * @param program the program for this report
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * Sets the instructor associated with this report.
     *
     * @param instructor the instructor for this report
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Sets the list of sessions for this report.
     *
     * @param sessionList the list of sessions
     */
    public void setSession(ArrayList<Session> sessionList) {
        this.sessionList = sessionList;
    }

    /**
     * Sets the progress ratio for this report.
     *
     * @param ratioProgress the ratio of completed sessions to total sessions
     */
    public void setRatioProgress(double ratioProgress) {
        this.ratioProgress = ratioProgress;
    }

    /**
     * Returns the list of sessions for this report.
     *
     * @return the list of sessions
     */
    public ArrayList<Session> getSessionList()
    {
        return sessionList;
    }

    /**
     * Returns the progress ratio for this report.
     *
     * @return the ratio of completed sessions to total sessions
     */
    public double getRatioProgress() {
        return ratioProgress;
    }

    /**
     * Returns the program associated with this report.
     *
     * @return the program for this report
     */
    public Program getProgram() {
        return program;
    }

    /**
     * Returns the instructor associated with this report.
     *
     * @return the instructor for this report
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Returns the client associated with this report.
     *
     * @return the client for this report
     */
    public Client getClient() {
        return client;
    }

    /**
     * Returns the list of completed sessions for this report.
     *
     * @return the list of completed sessions
     */
    public ArrayList<Session> getCompletedSessionList() {
        return CompletedSessionList;
    }


    /**
     * Returns the name of the report.
     *
     * @return the name of the report
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the report.
     *
     * @param name the name of the report
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the report.
     *
     * @return the ID of the report
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the ID of the report.
     *
     * @param ID the ID of the report
     */
    public void setID(String ID) {
        this.ID = ID;
    }




    /**
     * Prints a summary report including the program title, instructor name, client name, completed sessions,
     * and the progress ratio.
     */
    public void printReport()
    {
        System.out.println("Program: " + this.getProgram().getProgramTitle());
        System.out.println("Instructor: " + this.getInstructor().getName());
        System.out.println("Client: " + this.getClient().getName());
        System.out.println("Completed Sessions: ");
        System.out.println("Session ID| Session Name| Session Date| Session Type");

        for(Session session : this.getCompletedSessionList())
        {
            System.out.println(session.getSessionID()+"| " + session.getSessionName()+"| " + session.getSessionDate()+"| " + session.getSessionType());
        }

        System.out.println("=========================================================================================================================");
        System.out.println("The ratio of sessions: " + this.getRatioProgress());
    }

    /**
     * Adds a comment to the report if it is not already in the list.
     *
     * @param comment the comment to add
     * @return {@code true} if the comment was added, {@code false} otherwise
     */
    public boolean addComment(Comment comment)
    {
        if(!commentList.contains(comment))
        {
            commentList.add(comment);
            return true;
        }
        return false;
    }


}
