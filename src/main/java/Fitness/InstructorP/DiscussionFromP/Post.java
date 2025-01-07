package Fitness.InstructorP.DiscussionFromP;

import Fitness.AdminPackage.User;

import java.util.ArrayList;

/**
 * The Post class represents a single post in a discussion forum.
 * It contains content, author, date, time, comments, and other related information for each post.
 * It is part of a larger discussion form and allows for interaction with comments and participants.
 *
 * <p>Each post is created by an author and can have multiple comments attached to it. It also tracks the participants
 * (users) that are involved in the discussion and has a title and post type.</p>
 *
 * Example usage:
 * <pre>
 * Post post = new Post(author, "Post Title", "This is a post content.", "2025-01-01");
 * post.addComment(new Comment(author, "This is a comment.", "2025-01-01", post));
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class Post {

    private String content;
    private User author;
    private String date;
    private String day;
    private String time;
    private ArrayList<Comment> comments;
    private DiscussionForm discussionForm;
    private String title;
    private PostType postType;
    private ArrayList<User> participantList;

    /**
     * Default constructor that initializes a new Post with default values.
     */
    public Post() {
        this.setAuthor(new User());
        this.setDate("");
        this.setDay("");
        this.setTime("");
        this.setContent("");
        comments = new ArrayList<Comment>();
        discussionForm = new DiscussionForm();
        this.setTitle("");
        this.setPostType(null);
        this.participantList = new ArrayList<User>();
    }

    /**
     * Constructs a new Post with the specified author, title, content, and date.
     *
     * @param authorPost the user who authored the post
     * @param titlePost the title of the post
     * @param contentPost the content of the post
     * @param datePost the date the post was created
     */
    public Post(User authorPost, String titlePost, String contentPost, String datePost) {
        this.setAuthor(authorPost);
        this.setDate(datePost);
        this.setDay("");
        this.setTime("");
        this.setContent(contentPost);
        comments = new ArrayList<Comment>();
        discussionForm = new DiscussionForm();
        this.setPostType(null);
        this.participantList = new ArrayList<User>();
    }

    /**
     * Returns the content of the post.
     *
     * @return the content of the post
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the post.
     *
     * @param contentPost the content of the post
     */
    public void setContent(String contentPost) {
        this.content = contentPost;
    }

    /**
     * Returns the author of the post.
     *
     * @return the user who authored the post
     */
    public User getAuthor() {
        return this.author;
    }

    /**
     * Sets the author of the post.
     *
     * @param authorPost the user to set as the author
     */
    public void setAuthor(User authorPost) {
        this.author = authorPost;
    }

    /**
     * Returns the date of the post.
     *
     * @return the date the post was created
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the post.
     *
     * @param datePost the date to set for the post
     */
    public void setDate(String datePost) {
        this.date = datePost;
    }

    /**
     * Returns the day of the week the post was created.
     *
     * @return the day of the week the post was created
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets the day of the week for the post.
     *
     * @param dayPost the day of the week to set for the post
     */
    public void setDay(String dayPost) {
        this.day = dayPost;
    }

    /**
     * Returns the time the post was created.
     *
     * @return the time the post was created
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time the post was created.
     *
     * @param timePost the time to set for the post
     */
    public void setTime(String timePost) {
        this.time = timePost;
    }

    /**
     * Returns the list of comments on the post.
     *
     * @return the list of comments on the post
     */
    public ArrayList<Comment> getComment() {
        return comments;
    }



    /**
     * Returns the title of the post.
     *
     * @return the title of the post
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the post.
     *
     * @param titlePost the title to set for the post
     */
    public void setTitle(String titlePost) {
        this.title = titlePost;
    }



    /**
     * Sets the type of the post.
     *
     * @param postType the type of the post to set
     */
    public void setPostType(PostType postType) {
        this.postType = postType;
    }




    /**
     * Adds a comment to the post.
     *
     * @param comment the comment to add
     * @return true if the comment was added successfully
     */
    public boolean addComment(Comment comment) {
        this.comments.add(comment);
        return true;
    }


    /**
     * Adds a participant to the post's discussion.
     *
     * @param user the user to add as a participant
     * @return true if the participant was added successfully
     */
    public boolean addParticipant(User user) {
        if (!this.participantList.contains(user)) {
            this.participantList.add(user);
            return true;
        }
        return false;
    }


}
