package Fitness.ClientPackage;

import Fitness.InstructorP.ProgramPackage.Program;

import java.time.LocalDate;
import java.util.List;

public class ProgramDetailPage {
    private boolean enrolled = false;
    private Program enrolledProgram;
    private Program program;
    private boolean isEnrolled = false;

    public void navigateToProgramDetailPage() {

        System.out.println("Navigating to program detail page...");
    }


    public boolean clickEnrollButton() {
        enrolled = true;
        System.out.println("User has enrolled in the program.");
        return enrolled;
    }
    


    public boolean isEnrolled() {
        return enrolled;
    }
    public void enrollInProgram(Program program) {
        this.enrolledProgram = program;
    }


    public Program getEnrolledProgram() {
        return enrolledProgram;
    }
    public ProgramDetailPage(Program program) {
        this.program = program;
    }
    public LocalDate getStartDate() {
        return program.getStartDate();
    }

    public LocalDate getEndDate() {
        return program.getEndDate();
    }

    public List<String> getAvailableTimeSlots() {
        return program.getTimeList();
    }

    public boolean clickViewScheduleButton() {
        System.out.println("User is viewing the schedule.");
        return true;
    }
    public void enroll() {
        this.enrolled = true;
    }
}
