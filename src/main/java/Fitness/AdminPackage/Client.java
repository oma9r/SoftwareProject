package Fitness.AdminPackage;

import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Reports.Report;
import Fitness.InstructorP.Session.Session;

import java.util.ArrayList;

public class Client extends User
{
    private Status status;
    private ArrayList<Session> sessionList;
    private ArrayList<Report> reportList;
    private ArrayList<Comment> replyList;
    private boolean premium;
    private Program program;


    public Client(String name, int age, String gender, String address, String email, String pass,Status status)
    {

        this.status = status;
        this.reportList = new ArrayList<Report>();
        this.replyList = new ArrayList<Comment>();
    }

    public Client(String clientName)
    {

        super();
        this.replyList = new ArrayList<Comment>();
    }

    public Client()
    {

        super();
        this.reportList = new ArrayList<Report>();
        this.replyList = new ArrayList<Comment>();
        status=Status.Active;
    }
    public Status getStatus()
    {

        return status;
    }

    public void setStatus(Status userStatus) {
        this.status = userStatus;
    }

    public void setSessionList(ArrayList<Session> sessionList)
    {
        this.sessionList = sessionList;
    }
    public ArrayList<Session> getSessionList()
    {
        return sessionList;
    }


    public void setReportList(ArrayList<Report> reportList)
    {
        this.reportList = reportList;
    }
    public ArrayList<Report> getReportList()
    {
        return reportList;
    }

    public void setReplyList(ArrayList<Comment> replyList) {
        this.replyList = replyList;
    }
    public ArrayList<Comment> getReplyList()
    {
        return replyList;
    }

    public boolean addSession(Session session)
    {
        if(!this.sessionList.contains(session))
        {
            this.sessionList.add(session);
            return true;
        }
        return false;
    }

    public boolean removeSession(Session session)
    {
        if(this.sessionList.contains(session))
        {
            this.sessionList.remove(session);
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

    public boolean addReply(Comment reply)
    {
        if(!this.replyList.contains(reply))
        {
            this.replyList.add(reply);
            return true;
        }
        return false;
    }

    public boolean removeReply(Comment reply) {
        if (this.replyList.contains(reply)) {
            this.replyList.remove(reply);
            return true;
        }
        return false;
    }
    public void submitFeedBack(String feed)
        {
        Application.notApprovedArticles.add(new Article(this.getName(),feed));
    }

    public boolean setPlan(String plan)
        {
        if(plan.equalsIgnoreCase("Premium"))
        {
            this.premium=true;
        }
        return premium;
    }

    public boolean isPremium()
    {
        return premium;
    }
    public String getPlan()
    {
        if(premium)
            return "Premium";
        return "Not Premium";

    }

    public void setProgram(Program program)
    {
        this.program = program;
    }
    public Program getProgram()
    {
        return program;
    }

    public boolean addProgram(Program program)
    {
        if(!this.program.equals(program))
        {
            this.setProgram(program);
            return true;

        }
        return false;
    }

    public boolean removeProgram(Program program)
    {
        if(this.program.equals(program))
        {
            this.setProgram(null);
            return true;

        }
        return false;
    }
}
