package Fitness.InstructorP.DiscussionFromP;

import Fitness.AdminPackage.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Comment class represents a comment on a post in the system.
 * It extends the {@link Post} class and adds additional functionality
 * for replies to a post, along with methods for comparing comment dates.
 *
 * <p>Each comment is associated with a post, and can have replies, which are stored
 * in a list of {@link Comment} objects. The comment also includes metadata such as the
 * comment's author, content, time, date, and day.</p>
 *
 * <p>The comment's date is automatically set to the date of the post to which it belongs,
 * and the reply list allows for tracking replies to the comment.</p>
 *
 * Example usage:
 * <pre>
 * Comment comment = new Comment(author, content, time, post);
 * comment.setReply(true);
 * </pre>
 *
 * @author Omar Abumazen
 * @version 1.0
 */
public class Comment extends Post {

    private Post post;
    private boolean isReply;
    private ArrayList<Comment> replyList;

    /**
     * Constructs a Comment object with the specified parameters.
     * The comment's date and day are inherited from the associated post.
     *
     * @param authorComment the author of the comment
     * @param contentComment the content of the comment
     * @param timeComment the time when the comment was posted
     * @param post the post to which this comment belongs
     */
    public Comment(User authorComment, String contentComment, String timeComment, Post post) {
        this.setAuthor(authorComment);
        this.setContent(contentComment);
        this.setTime(timeComment);
        setPost(post);
        this.setDate(this.getPost().getDate());
        this.setDay(this.getPost().getDay());
        replyList = new ArrayList<Comment>();
    }

    /**
     * Default constructor for the Comment object.
     * Initializes the post to null.
     */
    public Comment() {
        super();
        this.setPost(null);
    }

    /**
     * Returns the associated post of this comment.
     *
     * @return the post associated with this comment
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets the associated post of this comment.
     *
     * @param post the post to associate with this comment
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Returns whether this comment is a reply.
     *
     * @return true if this comment is a reply, false otherwise
     */
    public boolean isReply() {
        return isReply;
    }

    /**
     * Sets whether this comment is a reply.
     *
     * @param isReply true if this comment is a reply, false otherwise
     */
    public void setReply(boolean isReply) {
        this.isReply = isReply;
    }

    /**
     * Returns the list of replies to this comment.
     *
     * @return the list of replies to this comment
     */
    public ArrayList<Comment> getReplyList() {
        return replyList;
    }

    /**
     * Sets the list of replies to this comment.
     *
     * @param replyList the list of replies to this comment
     */
    public void setReplyList(ArrayList<Comment> replyList) {
        this.replyList = replyList;
    }

    /**
     * Compares the date of this comment to a given date string.
     *
     * @param dateString the date string to compare to
     * @return true if the comment's date is before or the same as the given date,
     *         false if it is after
     */
    public boolean dateCompare(String dateString) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(dateString);
            Date currentDate = dateFormat.parse(this.getDate());

            if (currentDate.before(date)) {
                return true;
            } else if (currentDate.after(date)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            System.out.println("invalid input" + e.getMessage());
            return false;
        }
    }
}
