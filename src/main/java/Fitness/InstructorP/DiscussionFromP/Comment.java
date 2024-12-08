package Fitness.InstructorP.DiscussionFromP;


import Fitness.User;

public class Comment extends Post{

    private Post post;




    public Comment(String contentComment, User authorComment, String dateComment, String dayComment, String timePost , Post post)
    {

        super(contentComment,authorComment,dateComment,dayComment,timePost);
        this.setPost(post);

    }







    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }







}
