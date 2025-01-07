package Fitness.ClientPackage;

import Fitness.InstructorP.ProgramPackage.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the Program Explorer, which allows users to explore and filter available fitness programs
 * based on various criteria such as difficulty level and focus area.
 *
 * @author Abdulrhman M Sawalmeh
 */
public class ProgramExplorer {

    private boolean onProgramExplorationPage;
    private ProgramExplorer programExplorer;
    private List<Program> programs;
    private List<Program> filteredPrograms;
    private List<Program> allPrograms;

    /**
     * Constructor to initialize the ProgramExplorer with a list of programs.
     *
     * @param programs the list of programs available for exploration.
     */
    public ProgramExplorer(List<Program> programs) {
        this.programs = programs;
        this.filteredPrograms = programs;
    }


    /**
     * Constructor to initialize the ProgramExplorer without any programs.
     * Sets the initial state to not being on the program exploration page.
     */
    public ProgramExplorer() {
        this.onProgramExplorationPage = false;
    }

    /**
     * Navigates to the program exploration page.
     */
    public void navigateToProgramExplorationPage() {
        this.onProgramExplorationPage = true;
    }

    /**
     * Checks if the user is currently on the program exploration page.
     *
     * @return true if the user is on the program exploration page, false otherwise.
     */
    public boolean isOnProgramExplorationPage() {
        return this.onProgramExplorationPage;
    }

    /**
     * Filters the list of programs based on the specified difficulty level.
     *
     * @param difficultyLevel the difficulty level to filter programs by (e.g., "Beginner", "Advanced").
     * @return a list of programs that match the specified difficulty level.
     */
    public List<Program> filterProgramsByDifficulty(String difficultyLevel) {
        filteredPrograms = programs.stream()
                .filter(program -> program.getProgramLevel().equalsIgnoreCase(difficultyLevel))
                .collect(Collectors.toList());
        return filteredPrograms;
    }

    /**
     * Filters the programs based on the specified focus area (e.g., "Flexibility", "Muscle Building").
     *
     * @param focusArea the focus area to filter programs by.
     * @return a list of programs that match the specified focus area.
     */
    public List<Program> filterProgramsByFocusArea(String focusArea) {
        filteredPrograms = filteredPrograms.stream()
                .filter(program -> program.getProgramGoals().equalsIgnoreCase(focusArea))
                .collect(Collectors.toList());
        return filteredPrograms;
    }

    /**
     * Gets the list of all available programs.
     *
     * @return the list of all programs.
     */
    public List<Program> getPrograms() {
        return programs;
    }

    /**
     * Clears all filters and shows all programs.
     */
    public void clearFilters() {
        filteredPrograms = programs;
    }

    /**
     * Gets the list of programs after filtering based on selected criteria.
     *
     * @return the list of filtered programs.
     */
    public List<Program> getFilteredPrograms() {
        return filteredPrograms;
    }


}
