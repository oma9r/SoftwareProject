package Fitness;

import Fitness.InstructorP.DiscussionFromP.DiscussionForm;
import Fitness.InstructorP.Program;

import java.util.ArrayList;

public class Instructor extends User
{
    private UserStatus status;

    private ArrayList <Program> programs;
    private ArrayList <DiscussionForm> discussionFormList;
    public Instructor(String name,int age,String gender,String address,String email,String password,UserStatus status)
    {
        super(name,age,gender,address,email,password,Role.Instructor);
        this.status=status;
        programs = new ArrayList<Program>();
    }

    public Instructor()
    {
        programs = new ArrayList<Program>();
        discussionFormList = new ArrayList<DiscussionForm>();

    }
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus userStatus) {
        this.status = userStatus;
    }

    public ArrayList <Program> getPrograms() {
        return programs;
    }
    public void setPrograms(ArrayList <Program> programs) {
        this.programs = programs;
    }

    public ArrayList <DiscussionForm> getDiscussionFormList() {
        return discussionFormList;
    }
    public void setDiscussionFormList(ArrayList <DiscussionForm> discussionFormList) {
        this.discussionFormList = discussionFormList;
    }

    public boolean addPrograms(Program program)
    {
        if(!programs.contains(program))
        {
            programs.add(program);
            return true;
        }
        return false;
    }

    public boolean removePrograms(Program program)
    {
        if(programs.contains(program))
        {
            programs.remove(program);
            return true;
        }
        return false;
    }

    public boolean addDiscussionForm(DiscussionForm discussionForm)
    {
        if(!discussionFormList.contains(discussionForm))
        {
            discussionFormList.add(discussionForm);
            return true;
        }
        return false;
    }

    public boolean removeDiscussionForm(DiscussionForm discussionForm)
    {
        if(discussionFormList.contains(discussionForm))
        {
            discussionFormList.remove(discussionForm);
            return true;
        }
        return false;
    }
}
