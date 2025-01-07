package Fitness.InstructorP.ProgramPackage;

import Fitness.AdminPackage.Application;
import Fitness.AdminPackage.Client;
import Fitness.AdminPackage.Instructor;
import Fitness.InstructorP.DiscussionFromP.DiscussionForm;
import Fitness.InstructorP.Reports.Report;
import Fitness.InstructorP.Session.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a fitness program managed by an instructor.
 * The program includes various attributes such as title, duration, goals, level,
 * associated sessions, clients, reports, and discussion forms.
 *
 * <p>The Program class is used to define and manage the details of a fitness program,
 * including scheduling, client management, instructor assignment, and program status.</p>
 *
 * @author Omar Abumazen
 */
public class Program {

    /**
     * The title of the fitness program.
     * This represents the name or title of the program, such as "Yoga for Beginners".
     */
    private String programTitle;

    /**
     * The duration of the fitness program.
     * This indicates how long the program lasts, for example, "6 weeks".
     */
    private String programDuration;

    /**
     * The level of difficulty for the fitness program.
     * This could be values like "Beginner", "Intermediate", or "Advanced".
     */
    private String programLevel;

    /**
     * The goals or objectives of the fitness program.
     * This describes what the program aims to achieve, such as "Increase flexibility" or "Build muscle".
     */
    private String programGoals;

    /**
     * The type of tutorial content associated with the program.
     * This could be one of the values defined in the {@link tutorialTypeProgram} enum, such as "Video", "Image", or "Document".
     */
    private tutorialTypeProgram programTutorialType;

    /**
     * The price of the fitness program.
     * This represents the cost to enroll in the program, for example, "$100".
     */
    private String programPrice;

    /**
     * A unique identifier for the program.
     * This ID is used to differentiate this program from others.
     */
    private int idProgram;

    /**
     * A list of sessions associated with the program.
     * Each session represents a particular lesson or class in the program.
     */
    private ArrayList<Session> sessions;

    /**
     * The number of sessions in the program.
     * This integer indicates how many sessions the program includes.
     */
    private int numberOfSessions;

    /**
     * The instructor responsible for teaching the program.
     * This references the {@link Instructor} who manages or conducts the program.
     */
    private Instructor instructorProgram;

    /**
     * The current status of the program.
     * This can be values like {@link ProgramStatus #ACTIVE}, {@link ProgramStatus #COMPLETED}, etc.
     */
    private ProgramStatus programStatus;

    /**
     * The type of tutorial content, as a string.
     * This can be values like "Video", "Image", or "Document".
     */
    private String tutorialType;

    /**
     * A list of discussion forms related to the program.
     * These discussion forms may contain questions, comments, or feedback from clients.
     */
    private ArrayList<DiscussionForm> discussionForms;

    /**
     * A list of clients enrolled in the program.
     * These are the {@link Client} objects who are participating in the program.
     */
    private ArrayList<Client> ClientsList;

    /**
     * A list of reports generated for the program.
     * These are {@link Report} objects, which could include performance reports, feedback, etc.
     */
    private ArrayList<Report> reportList;

    /**
     * The total revenue generated from the program.
     * This float represents the monetary income from all enrolled clients.
     */
    float revenue;

    /**
     * The start date of the program.
     * This is the date when the program begins.
     */
    LocalDate startDate;

    /**
     * The end date of the program.
     * This is the date when the program finishes.
     */
    LocalDate endDate;

    /**
     * A list of time slots associated with the program.
     * This is a list of strings representing when the program's sessions take place, for example, "10:00 AM", "2:00 PM".
     */
    List<String> time;

    /**
     * Indicates whether the program is complete or not.
     * This field tracks whether the program has been finished or is still ongoing.
     */
    private isComplete isComplete;



    /**
     * Default constructor for creating a new Program with default values.
     * <p>This constructor initializes all fields with default values:
     * an empty string for title, duration, level, goals, and price;
     * null values for instructor, program status, and tutorial type;
     * an empty list for sessions, discussion forms, clients, and reports;
     * and a revenue of 0.</p>
     */
    public Program() {
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

    /**
     * User-defined constructor for creating a Program with specified details.
     *
     * @param title         The title of the program.
     * @param duration      The duration of the program.
     * @param level         The level of the program (e.g., Beginner, Intermediate, Advanced).
     * @param goals         The goals or objectives of the program.
     * @param tutorialType  The type of tutorial content (e.g., Video, Image, Document).
     * @param price         The price of the program.
     * @param programStatus The current status of the program (e.g., Active, Completed).
     * @param instructorProgram1 The instructor who will lead the program.
     * <p>This constructor initializes the Program with the given parameters, setting its title, duration, level,
     * goals, tutorial type, price, and status. It also assigns the specified instructor to the program.</p>
     */
    public Program(String title, String duration, String level, String goals, String tutorialType, String price,
                   ProgramStatus programStatus, Instructor instructorProgram1) {
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

    /**
     * Constructor for creating a Program with basic details and no price or instructor.
     *
     * @param programTitle  The title of the program.
     * @param programDuration The duration of the program.
     * @param programLevel The level of the program.
     * @param programGoals The goals or objectives of the program.
     * <p>This constructor is used to initialize a Program with basic details like title, duration, level, and goals.
     * The price, instructor, program status, and tutorial type are set to default values.</p>
     */
    public Program(String programTitle, String programDuration, String programLevel, String programGoals) {
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



    /**
     * Constructor for creating a Program with basic details and specific start and end dates.
     *
     * @param programName The title of the program.
     * @param programLevel The level of the program.
     * @param programGoals The goals or objectives of the program.
     * @param programStartDate The start date of the program.
     * @param programEndDate The end date of the program.
     * @param time A list of time slots for the program's sessions.
     * <p>This constructor initializes the Program with specific details such as title, level, goals, start and end dates,
     * and time slots. Other fields such as price, instructor, and tutorial type are set to default values.</p>
     */
    public Program(String programName, String programLevel, String programGoals, LocalDate programStartDate,
                   LocalDate programEndDate, List<String> time) {
        this.setProgramTitle(programName);
        this.setProgramLevel(programLevel);
        this.setProgramGoals(programGoals);
        this.setStartDate(programStartDate);
        this.setEndDate(programEndDate);
        this.setTimeList(time);
    }

    /**
     * Gets the title of the program.
     *
     * @return The title of the program.
     */
    public String getProgramTitle() {
        return programTitle;
    }

    /**
     * Sets the title of the program.
     *
     * @param programTitle The title of the program.
     */
    public void setProgramTitle(String programTitle) {
        this.programTitle = programTitle;
    }

    /**
     * Gets the duration of the program.
     *
     * @return The duration of the program.
     */
    public String getProgramDuration() {
        return programDuration;
    }

    /**
     * Sets the duration of the program.
     *
     * @param programDuration The duration of the program.
     */
    public void setProgramDuration(String programDuration) {
        this.programDuration = programDuration;
    }

    /**
     * Gets the level of the program (e.g., Beginner, Intermediate, Advanced).
     *
     * @return The level of the program.
     */
    public String getProgramLevel() {
        return programLevel;
    }

    /**
     * Sets the level of the program (e.g., Beginner, Intermediate, Advanced).
     *
     * @param programLevel The level of the program.
     */
    public void setProgramLevel(String programLevel) {
        this.programLevel = programLevel;
    }

    /**
     * Gets the goals or objectives of the program.
     *
     * @return The goals or objectives of the program.
     */
    public String getProgramGoals() {
        return programGoals;
    }

    /**
     * Sets the goals or objectives of the program.
     *
     * @param programGoals The goals or objectives of the program.
     */
    public void setProgramGoals(String programGoals) {
        this.programGoals = programGoals;
    }


    /**
     * Sets the price of the program.
     *
     * @param programPrice The price of the program.
     */
    public void setProgramPrice(String programPrice) {
        this.programPrice = programPrice;
    }

    /**
     * Gets the list of sessions for the program.
     *
     * @return The list of sessions for the program.
     */
    public ArrayList<Session> getSessions() {
        return sessions;
    }

    /**
     * Sets the list of sessions for the program.
     *
     * @param sessions The list of sessions to be set for the program.
     */
    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }


    /**
     * Sets the number of sessions for the program.
     *
     * @param numberOfSessions The number of sessions to be set for the program.
     */
    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }



    /**
     * Sets the instructor for the program.
     *
     * @param instructorProgram The instructor to be set for the program.
     */
    public void setInstructorProgram(Instructor instructorProgram) {
        this.instructorProgram.setName(instructorProgram.getName());
    }



    /**
     * Sets the tutorial type for the program (e.g., Video, Image, Document).
     *
     * @param tutorialType The tutorial type to be set for the program.
     */
    public void setTutorialType(String tutorialType) {
        this.tutorialType = tutorialType;
    }

    /**
     * Sets the program's unique ID.
     *
     * @param idProgram The unique ID to be set for the program.
     */
    public void setIdProgram(int idProgram) {
        this.idProgram = idProgram;
    }



    /**
     * Sets the tutorial type for the program (enum).
     *
     * @param programTutorialType The tutorial type (enum) to be set for the program.
     */
    public void setProgramTutorialType(tutorialTypeProgram programTutorialType) {
        this.programTutorialType = programTutorialType;
    }



    /**
     * Gets the list of clients enrolled in the program.
     *
     * @return The list of clients enrolled in the program.
     */
    public ArrayList<Client> getClientsList() {
        return this.ClientsList;
    }



    /**
     * Gets the list of reports related to the program.
     *
     * @return The list of reports related to the program.
     */
    public ArrayList<Report> getReportList() {
        return reportList;
    }





    /**
     * Gets the completion status of the program.
     *
     * @return The completion status of the program (e.g., COMPLETED, IN_PROGRESS).
     */
    public Fitness.InstructorP.ProgramPackage.isComplete getIsComplete() {
        return isComplete;
    }


    /**
     * Adds a client to the program's client list if not already present.
     *
     * @param client The client to be added to the program.
     * @return true if the client was successfully added, false if the client is already in the list.
     */
    public boolean addClient(Client client) {
        if(!this.ClientsList.contains(client)) {
            this.ClientsList.add(client);
            return true;
        } else {
            return false;
        }
    }



    /**
     * Adds a session to the program's session list if not already present.
     *
     * @param session The session to be added to the program.
     * @return true if the session was successfully added, false if the session is already in the list.
     */
    public boolean addSession(Session session) {
        if(!this.sessions.contains(session)) {
            this.sessions.add(session);
            return true;
        } else {
            return false;
        }
    }



    /**
     * Adds a discussion form to the program's list of discussion forms if not already present.
     *
     * @param discussionForm The discussion form to be added to the program.
     * @return true if the discussion form was successfully added, false if the discussion form is already in the list.
     */
    public boolean addDiscussionForm(DiscussionForm discussionForm) {
        if(!this.discussionForms.contains(discussionForm)) {
            this.discussionForms.add(discussionForm);
            return true;
        }
        return false;
    }



    /**
     * Adds a report to the program's list of reports if not already present.
     *
     * @param report The report to be added to the program.
     * @return true if the report was successfully added, false if the report is already in the list.
     */
    public boolean addReport(Report report) {
        if(!this.reportList.contains(report)) {
            this.reportList.add(report);
            return true;
        }
        return false;
    }



    /**
     * Retrieves the revenue generated by the program.
     *
     * @return The revenue of the program.
     */
    public float getRevenue() {
        return revenue;
    }


    /**
     * Sets the start date of the program.
     *
     * @param date The start date to be set for the program.
     */
    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    /**
     * Retrieves the start date of the program.
     *
     * @return The start date of the program.
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the end date of the program.
     *
     * @param date The end date to be set for the program.
     */
    public void setEndDate(LocalDate date) {
        this.endDate = date;
    }

    /**
     * Retrieves the end date of the program.
     *
     * @return The end date of the program.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the list of times for the program's sessions.
     *
     * @param listTime The list of time slots to be set for the program.
     */
    public void setTimeList(List<String> listTime) {
        this.time = listTime;
    }

    /**
     * Retrieves the list of times for the program's sessions.
     *
     * @return The list of time slots for the program.
     */
    public List<String> getTimeList() {
        return time;
    }

}
