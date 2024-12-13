package Fitness.InstructorP.DiscussionFromP;

import Fitness.Instructor;
import Fitness.InstructorP.Program;
import Fitness.User;
import io.cucumber.java.sl.In;

import java.util.ArrayList;

public class DiscussionForm
{
    private Program program;
    private Instructor instructor;
    private ArrayList<Post> postList;
    private ArrayList<User> clientsList;


    public DiscussionForm()
    {
        this.setProgram(null);
        this.setInstructor(null);

    }

    public DiscussionForm(Program program, Instructor instructor, ArrayList<Post> postList, ArrayList<User> clientsList)
    {
        this.setProgram(program);
        this.setInstructor(instructor);
        this.setPostList(postList);
        this.setClientsList(clientsList);

    }



    public void setProgram(Program program)
    {
        this.program = program;
    }

    public Program getProgram()
    {
        return this.program;
    }

    public void setInstructor(Instructor instructor)
    {
        this.instructor = instructor;
    }

    public Instructor getInstructor()
    {
        return this.instructor;
    }

    public ArrayList<Post> getPostList()
    {
        return this.postList;
    }

    public void setPostList(ArrayList<Post> postList)
    {
        this.postList = postList;
    }

    public ArrayList<User> getClientsList() {
        return this.clientsList;
    }

    public void setClientsList(ArrayList<User> clientsList) {
        this.clientsList = clientsList;
    }

    public boolean addClient(User user)
    {
        if(!this.clientsList.contains(user))
        {
            this.clientsList.add(user);
            return true;
        }
        return false;
    }

    public boolean removeClient(User user)
    {
        if(this.clientsList.contains(user))
        {
            this.clientsList.remove(user);
            return true;
        }
        return false;
    }

    public boolean addPost(Post post)
    {
        if(!this.postList.contains(post))
        {
            this.postList.add(post);
            return true;
        }
        return false;
    }

    public boolean removePost(Post post)
    {
        if(this.postList.contains(post))
        {
            this.postList.remove(post);
            return true;
        }
        return false;
    }
}
