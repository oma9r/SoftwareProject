package Fitness.AdminPackage;

import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.InstructorP.Reports.Report;
import Fitness.InstructorP.Session.Session;

import java.util.ArrayList;

/**
 * Represents a client in the fitness application.
 * A client can attend sessions, view reports, and provide feedback.
 * They may have a program and a premium plan.
 *
 * @author Ibrahim Mashaqi
 */
public class Client extends User {
    /**
     * The current status of the client.
     */
    private Status status;

    /**
     * List of sessions associated with the client.
     */
    private ArrayList<Session> sessionList;

    /**
     * List of reports associated with the client.
     */
    private ArrayList<Report> reportList;

    /**
     * List of replies (comments) made by the client.
     */
    private ArrayList<Comment> replyList;

    /**
     * Indicates whether the client is on a premium plan.
     */
    private boolean premium;

    /**
     * The program assigned to the client.
     */
    private Program program;

    /**
     * The client's current progress.
     */
    private double currentProgress;

    /**
     * Constructs a client with the specified details.
     *
     * @param name     the name of the client
     * @param age      the age of the client
     * @param gender   the gender of the client
     * @param address  the address of the client
     * @param email    the email of the client
     * @param pass     the password of the client
     * @param status   the initial status of the client
     */
    public Client(String name, int age, String gender, String address, String email, String pass, Status status) {
        this.status = status;
        this.reportList = new ArrayList<>();
        this.replyList = new ArrayList<>();
        this.currentProgress = 0;
        this.program = new Program();
    }

    /**
     * Constructs a client with a given name.
     *
     * @param clientName the name of the client
     */
    public Client(String clientName) {
        super();
        this.replyList = new ArrayList<>();
        this.currentProgress = 0;
        this.program = new Program();
    }

    /**
     * Default constructor for a client.
     * Initializes status to Active and sets progress to 0.
     */
    public Client() {
        super();
        this.reportList = new ArrayList<>();
        this.replyList = new ArrayList<>();
        status = Status.Active;
        this.currentProgress = 0;
        this.program = new Program();
    }

    /**
     * Gets the status of the client.
     *
     * @return the client's status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the client.
     *
     * @param userStatus the new status of the client
     */
    public void setStatus(Status userStatus) {
        this.status = userStatus;
    }




    /**
     * Gets the list of reports for the client.
     *
     * @return the report list
     */
    public ArrayList<Report> getReportList() {
        return reportList;
    }


    /**
     * Gets the list of replies for the client.
     *
     * @return the reply list
     */
    public ArrayList<Comment> getReplyList() {
        return replyList;
    }


    /**
     * Gets the client's current progress.
     *
     * @return the current progress
     */
    public double getCurrentProgress() {
        return currentProgress;
    }



    /**
     * Adds a report to the client's report list.
     *
     * @param report the report to add
     * @return true if added successfully, false otherwise
     */
    public boolean addReport(Report report) {
        if (!this.reportList.contains(report)) {
            this.reportList.add(report);
            return true;
        }
        return false;
    }



    /**
     * Adds a reply to the client's reply list.
     *
     * @param reply the reply to add
     * @return true if added successfully, false otherwise
     */
    public boolean addReply(Comment reply) {
        if (!this.replyList.contains(reply)) {
            this.replyList.add(reply);
            return true;
        }
        return false;
    }



    /**
     * Submits feedback as an article.
     *
     * @param feed the feedback content
     */
    public void submitFeedBack(String feed) {
        Application.notApprovedArticles.add(new Article(this.getName(), feed));
    }

    /**
     * Sets the client's plan.
     *
     * @param plan the plan name
     * @return true if the plan is premium, false otherwise
     */
    public boolean setPlan(String plan) {
        if (plan.equalsIgnoreCase("Premium")) {
            this.premium = true;
        }
        return premium;
    }

    /**
     * Checks if the client has a premium plan.
     *
     * @return true if premium, false otherwise
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * Gets the client's plan as a string.
     *
     * @return "Premium" if premium, "Not Premium" otherwise
     */
    public String getPlan() {
        if (premium)
            return "Premium";
        return "Not Premium";
    }

    /**
     * Sets the client's program.
     *
     * @param program the program to set
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * Gets the client's program.
     *
     * @return the program
     */
    public Program getProgram() {
        return program;
    }

    /**
     * Adds a program to the client.
     *
     * @param program the program to add
     * @return true if added successfully, false otherwise
     */
    public boolean addProgram(Program program) {
        if (!this.getProgram().equals(program)) {
            this.setProgram(program);
            return true;
        }
        return false;
    }


}
