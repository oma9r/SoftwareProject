package Fitness.InstructorP.DiscussionFromP;


import Fitness.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment extends Post{

    private Post post;
    //dateComment & dayComment are depends on post object, no need to set them again



    public Comment(User authorComment,String contentComment,String timeComment,Post post)
    {
        this.setAuthor(authorComment);
        this.setContent(contentComment);
        this.setTime(timeComment);
        setPost(post);
        this.setDate(this.getPost().getDate());
        this.setDay(this.getPost().getDay());
    }

    public Comment()
    {
        super();
        this.setPost(null);
    }







    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public boolean dateCompare(String dateString) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{

            Date date = dateFormat.parse(dateString);
            Date currentDate = dateFormat.parse(this.getDate());

            if(currentDate.before(date))
            {
                return true;
            }
            else if (currentDate.after(date))
            {
                return false;
            }
            else
            {
                return true;
            }


        }

        catch(ParseException e)
        {
            System.out.println("invalid input" + e.getMessage());
            return false;
        }
    }







}
