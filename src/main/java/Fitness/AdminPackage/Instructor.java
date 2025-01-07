package Fitness.AdminPackage;

import Fitness.InstructorP.DiscussionFromP.Comment;
import Fitness.InstructorP.DiscussionFromP.DiscussionForm;
import Fitness.InstructorP.ProgramPackage.Program;

import java.util.ArrayList;

import static Fitness.AdminPackage.Application.notApprovedArticles;

/**
 * Represents an Instructor in the fitness system. An Instructor is a type of User with additional responsibilities
 * related to managing programs, discussion forms, and comment reports. The Instructor also has a status that defines
 * their current state in the system.
 * <p>
 * This class extends the {@link User} class and provides methods for managing programs, discussion forms, and comment reports.
 * It also provides functionality to add or remove these entities from the respective lists.
 * <p>
 * The instructor can also add wellness articles to a list of unapproved articles.
 * <p>
 * @author Ibrahim Mashaqi
 */
public class Instructor extends User {

    /** The current status of the instructor. */
    private Status status;

    /** List of programs assigned to the instructor. */
    private ArrayList<Program> programs;

    /** List of discussion forms managed by the instructor. */
    private ArrayList<DiscussionForm> discussionFormList;

    /** List of comment reports created by the instructor. */
    private ArrayList<Comment> commentReportList;

    /**
     * Constructs an Instructor with the specified details and an initial empty list for programs,
     * discussion forms, and comment reports.
     *
     * @param name    The name of the instructor.
     * @param age     The age of the instructor.
     * @param gender  The gender of the instructor.
     * @param address The address of the instructor.
     * @param email   The email of the instructor.
     * @param pass    The password of the instructor.
     * @param status  The status of the instructor.
     */
    public Instructor(String name, int age, String gender, String address, String email, String pass, Status status) {
        super(name, age, gender, address, email, pass, Role.Instructor);
        this.status = status;
        programs = new ArrayList<Program>();
        discussionFormList = new ArrayList<DiscussionForm>();
        commentReportList = new ArrayList<Comment>();
    }

    /**
     * Constructs an Instructor with empty lists for programs, discussion forms, and comment reports.
     */
    public Instructor() {
        programs = new ArrayList<Program>();
        discussionFormList = new ArrayList<DiscussionForm>();
        commentReportList = new ArrayList<Comment>();
    }

    /**
     * Returns the current status of the instructor.
     *
     * @return The status of the instructor.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the instructor.
     *
     * @param userStatus The new status for the instructor.
     */
    public void setStatus(Status userStatus) {
        this.status = userStatus;
    }

    /**
     * Returns the list of programs assigned to the instructor.
     *
     * @return The list of programs.
     */
    public ArrayList<Program> getPrograms() {
        return programs;
    }

    /**
     * Sets the list of programs assigned to the instructor.
     *
     * @param programs The new list of programs.
     */
    public void setPrograms(ArrayList<Program> programs) {
        this.programs = programs;
    }



    /**
     * Adds a program to the instructor's program list if it's not already present.
     *
     * @param program The program to be added.
     * @return True if the program was added, false otherwise.
     */
    public boolean addPrograms(Program program) {
        if (!programs.contains(program)) {
            programs.add(program);
            return true;
        }
        return false;
    }



    /**
     * Adds a discussion form to the instructor's discussion form list if it's not already present.
     *
     * @param discussionForm The discussion form to be added.
     * @return True if the discussion form was added, false otherwise.
     */
    public boolean addDiscussionForm(DiscussionForm discussionForm) {
        if (discussionFormList.isEmpty()) {
            discussionFormList.add(discussionForm);
            return true;
        } else if (!discussionFormList.contains(discussionForm)) {
            discussionFormList.add(discussionForm);
            return true;
        }
        return false;
    }



    /**
     * Adds a comment report to the instructor's comment report list if it's not already present.
     *
     * @param comment The comment report to be added.
     * @return True if the comment report was added, false otherwise.
     */
    public boolean addCommentReport(Comment comment) {
        if (!commentReportList.contains(comment)) {
            commentReportList.add(comment);
            return true;
        }
        return false;
    }


    /**
     * Returns a string representation of the instructor, including their basic user details and current status.
     *
     * @return A string representing the instructor.
     */
    @Override
    public String toString() {
        return "[" + super.toString() + ",status=" + status + "]\n";
    }

    /**
     * Adds an article to the list of unapproved articles.
     *
     * @param article The article to be added to the list of unapproved articles.
     */
    public void addWallness(Article article) {
        notApprovedArticles.add(article);
    }
}
