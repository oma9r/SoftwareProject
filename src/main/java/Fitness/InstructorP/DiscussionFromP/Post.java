package Fitness.InstructorP.DiscussionFromP;

import Fitness.User;

import java.util.ArrayList;

public class Post
{
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



    public Post()
    {

        //this.setAuthor(null);
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

    public Post(User authorPost,String titlePost, String contentPost,String datePost)
    {
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
    
    
    
    
    
    
    











    public String getContent()
    {
        return content;
    }

    public void setContent(String contentPost)
    {
        this.content = contentPost;
    }
    public User getAuthor()
    {
        return this.author;
    }

    public void setAuthor(User authorPost)
    {
        this.author = authorPost;
    }

    public String getDate()
    {
        return date;
    }
    public void setDate(String datePost)
    {
        this.date = datePost;
    }
    public String getDay()
    {
        return day;
    }
    public void setDay(String dayPost)
    {
        this.day = dayPost;
    }
    public String getTime()
    {
        return time;
    }
    public void setTime(String timePost)
    {
        this.time = timePost;
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

    public void setTitle(String titlePost) {
        this.title = titlePost;
    }
    public String getTitle() {
        return title;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }
    public PostType getPostType() {
        return postType;
    }

    public ArrayList<User> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(ArrayList<User> participantList) {
        this.participantList = participantList;
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

    public boolean addParticipant(User user)
    {
        if(!this.participantList.contains(user))
        {
            this.participantList.add(user);
            return true;
        }
        return false;

    }

    public boolean removeParticipant(User user)
    {
        if(this.participantList.contains(user))
        {
            this.participantList.remove(user);
            return true;
        }
        return false;
    }


}
