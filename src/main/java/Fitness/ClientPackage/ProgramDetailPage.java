package Fitness.ClientPackage;

import Fitness.InstructorP.ProgramPackage.Program;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents the details page for a specific fitness program.
 * This class allows the user to view program details, enroll in a program, and view the schedule.
 *
 * @author Abdulrhman M Sawalmeh
 */
public class ProgramDetailPage {

    private boolean enrolled = false;
    private Program enrolledProgram;
    private Program program;

    /**
     * Constructs a new ProgramDetailPage with the given program.
     *
     * @param program the program to be displayed on this detail page.
     */
    public ProgramDetailPage(Program program) {
        this.program = program;
    }

    /**
     * Navigates to the program detail page.
     */
    public void navigateToProgramDetailPage() {
        System.out.println("Navigating to program detail page...");
    }

    /**
     * Simulates clicking the enroll button and enrolling the user in the program.
     *
     * @return true if the user successfully enrolled in the program.
     */
    public boolean clickEnrollButton() {
        enrolled = true;
        System.out.println("User has enrolled in the program.");
        return enrolled;
    }

    /**
     * Checks if the user is enrolled in the program.
     *
     * @return true if the user is enrolled in the program, false otherwise.
     */
    public boolean isEnrolled() {
        return enrolled;
    }

    /**
     * Enrolls the user in the provided program.
     *
     * @param program the program the user is enrolling in.
     */
    public void enrollInProgram(Program program) {
        this.enrolledProgram = program;
    }

    /**
     * Gets the enrolled program details.
     *
     * @return the program the user is enrolled in.
     */
    public Program getEnrolledProgram() {
        return this.enrolledProgram;
    }

    /**
     * Gets the start date of the program.
     *
     * @return the start date of the program.
     */
    public LocalDate getStartDate() {
        return program.getStartDate();
    }

    /**
     * Gets the end date of the program.
     *
     * @return the end date of the program.
     */
    public LocalDate getEndDate() {
        return program.getEndDate();
    }

    /**
     * Gets the available time slots for the program.
     *
     * @return a list of time slots available for the program.
     */
    public List<String> getAvailableTimeSlots() {
        return program.getTimeList();
    }

    /**
     * Simulates clicking the view schedule button to view the program's schedule.
     *
     * @return true if the schedule is being viewed.
     */
    public boolean clickViewScheduleButton() {
        System.out.println("User is viewing the schedule.");
        return true;
    }

    /**
     * Enrolls the user in the current program.
     */
    public void enroll() {
        this.enrolled = true;
    }
}
