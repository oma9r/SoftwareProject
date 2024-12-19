package Fitness.InstructorP.Reports;

import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;
import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Session.Session;
import Fitness.InstructorP.Session.SessionCompleteStatus;

import java.util.ArrayList;
import java.util.List;

public class Report
{
    private Program program;
    private Instructor instructor;
    private Client client;
    private List<Session> sessionList;
    private double ratioProgress;
    private List<Session> CompletedSessionList;
    private List<Comment> commentList;
    private String name;
    private String ID;
    private ArrayList<Comment> replyList;

    public Report()
    {
        sessionList = new ArrayList<Session>();
        ratioProgress = 0;
        CompletedSessionList = new ArrayList<Session>();
        commentList = new ArrayList<Comment>();
        replyList = new ArrayList<Comment>();

    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setProgram(Program program) {
        this.program = program;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public void setSession(ArrayList<Session> sessionList) {
        this.sessionList = sessionList;
    }
    public void setRatioProgress(double ratioProgress) {
        this.ratioProgress = ratioProgress;
    }

    public ArrayList<Session> getSessionList() {
        return sessionList;
    }
    public double getRatioProgress() {
        return ratioProgress;
    }
    public Program getProgram() {
        return program;
    }
    public Instructor getInstructor() {
        return instructor;
    }
    public Client getClient() {
        return client;
    }

    public ArrayList<Session> getCompletedSessionList() {
        return CompletedSessionList;
    }

    public void setCompletedSessionList(ArrayList<Session> completedSessionList) {
        CompletedSessionList = completedSessionList;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Comment> getReplyList() {
        return replyList;
    }
    public void setReplyList(ArrayList<Comment> replyList) {
        this.replyList = replyList;
    }

    public double calculateRatio()
    {

        for(Session session : this.getSessionList())
        {
            if(session.getSessionStatus().equals(SessionCompleteStatus.completed))
            {
                if(!CompletedSessionList.contains(session))
                {
                    CompletedSessionList.add(session);
                }
            }
        }

        this.setRatioProgress((double)CompletedSessionList.size() / (double)this.getSessionList().size());
        return this.getRatioProgress();
    }

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

    public boolean addComment(Comment comment)
    {
        if(!commentList.contains(comment))
        {
            commentList.add(comment);
            return true;
        }
        return false;
    }

    public boolean removeComment(Comment comment)
    {
        if(commentList.contains(comment))
        {
            commentList.remove(comment);
            return true;
        }
        return false;
    }

}
