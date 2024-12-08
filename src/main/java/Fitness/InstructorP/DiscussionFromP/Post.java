package Fitness.InstructorP.DiscussionFromP;

import Fitness.User;

import java.util.ArrayList;

public class Post
{
    private String contentPost;
    private User authorPost;
    private String datePost;
    private String dayPost;
    private String timePost;
    private ArrayList<Comment> comments;
    private DiscussionForm discussionForm;



    public Post()
    {
        this.setAuthorPost(null);
        this.setDatePost("");
        this.setDayPost("");
        this.setTimePost("");
        this.setContentPost("");
        comments = new ArrayList<Comment>();
        discussionForm = new DiscussionForm();

    }

    public Post(String contentPost,User authorPost,String datePost,String dayPost,String timePost)
    {
        this.setAuthorPost(authorPost);
        this.setDatePost(datePost);
        this.setDayPost(dayPost);
        this.setTimePost(timePost);
        this.setContentPost(contentPost);
        comments = new ArrayList<Comment>();
        discussionForm = new DiscussionForm();

    }











    public String getContentPost()
    {
        return contentPost;
    }

    public void setContentPost(String contentPost)
    {
        this.contentPost = contentPost;
    }
    public User getAuthorPost()
    {
        return authorPost;
    }

    public void setAuthorPost(User authorPost)
    {
        this.authorPost = authorPost;
    }

    public String getDatePost()
    {
        return datePost;
    }
    public void setDatePost(String datePost)
    {
        this.datePost = datePost;
    }
    public String getDayPost()
    {
        return dayPost;
    }
    public void setDayPost(String dayPost)
    {
        this.dayPost = dayPost;
    }
    public String getTimePost()
    {
        return timePost;
    }
    public void setTimePost(String timePost)
    {
        this.timePost = timePost;
    }

    public ArrayList<Comment> getComment()
    {
        return comments;
    }
    public void setComments(ArrayList<Comment> comments)
    {
        this.comments = comments;
    }

    public void setDiscussionForm(DiscussionForm discussionForm) {
        this.discussionForm = discussionForm;
    }

    public DiscussionForm getDiscussionForm() {
        return this.discussionForm;
    }

    public boolean addComment(Comment comment)
    {
        this.comments.add(comment);
        return true;

    }

    public boolean removeComment(Comment comment)
    {
        this.comments.remove(comment);
        return true;
    }


}
