package Fitness;

import Fitness.InstructorP.Program;

import java.util.ArrayList;

public class Instructor extends User
{
    private UserStatus status;

    private ArrayList <Program> programs;
    public Instructor(String name,int age,String gender,String address,String email,String password,UserStatus status)
    {
        super(name,age,gender,address,email,password,Role.Instructor);
        this.status=status;
        programs = new ArrayList();
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

    public void addPrograms(Program program)
    {
        programs.add(program);
    }
}
