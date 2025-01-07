package Fitness.InstructorP.DiscussionFromP;

import Fitness.AdminPackage.Instructor;
import Fitness.InstructorP.ProgramPackage.Program;
import Fitness.AdminPackage.User;

import java.util.ArrayList;

/**
 * The DiscussionForm class represents a discussion forum for a specific program.
 * It allows instructors to create posts and interact with clients.
 *
 * <p>The class stores information about the associated program, the instructor, the list
 * of posts, and the list of clients participating in the discussion. It also provides methods
 * for adding and removing clients and posts from the discussion.</p>
 *
 * <p>Each discussion form is associated with a particular program and instructor, and can
 * have multiple posts created by the instructor. Clients can be added to the discussion and
 * can interact by viewing and possibly replying to the posts.</p>
 *
 * Example usage:
 * <pre>
 * DiscussionForm discussion = new DiscussionForm(program, instructor, postList, clientList);
 * discussion.addClient(client);
 * discussion.addPost(post);
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class DiscussionForm {

    private Program program;
    private Instructor instructor;
    private ArrayList<Post> postList;
    private ArrayList<User> clientsList;

    /**
     * Constructs a DiscussionForm object with no associated program or instructor,
     * and initializes the post list and clients list as empty.
     */
    public DiscussionForm() {
        this.setProgram(null);
        this.setInstructor(null);
        this.clientsList = new ArrayList<User>();
        this.postList = new ArrayList<Post>();
    }



    /**
     * Sets the program associated with the discussion.
     *
     * @param program the program to associate with the discussion
     */
    public void setProgram(Program program) {
        this.program = program;
    }

    /**
     * Returns the program associated with the discussion.
     *
     * @return the program associated with the discussion
     */
    public Program getProgram() {
        return this.program;
    }

    /**
     * Sets the instructor leading the discussion.
     *
     * @param instructor the instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    /**
     * Returns the instructor leading the discussion.
     *
     * @return the instructor leading the discussion
     */
    public Instructor getInstructor() {
        return this.instructor;
    }

    /**
     * Returns the list of posts in the discussion.
     *
     * @return the list of posts in the discussion
     */
    public ArrayList<Post> getPostList() {
        return this.postList;
    }


    /**
     * Returns the list of clients participating in the discussion.
     *
     * @return the list of clients participating in the discussion
     */
    public ArrayList<User> getClientsList() {
        return this.clientsList;
    }



    /**
     * Adds a client to the discussion if they are not already part of it.
     *
     * @param user the client to add to the discussion
     * @return true if the client was successfully added, false otherwise
     */
    public boolean addClient(User user) {
        if (!this.clientsList.contains(user)) {
            this.clientsList.add(user);
            return true;
        }
        return false;
    }



    /**
     * Adds a post to the discussion if it is not already part of the discussion.
     *
     * @param post the post to add to the discussion
     * @return true if the post was successfully added, false otherwise
     */
    public boolean addPost(Post post) {
        if (!this.postList.contains(post)) {
            this.postList.add(post);
            return true;
        }
        return false;
    }


}
