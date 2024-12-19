package Fitness;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramExplorer {
    private boolean onProgramExplorationPage;
   private ProgramExplorer programExplorer;
    private List<Program> programs;
    private List<Program> filteredPrograms;
    private List<Program> allPrograms;



    public void testUserIsOnProgramExplorationPage() {

        programExplorer.navigateToProgramExplorationPage();


        assertTrue(programExplorer.isOnProgramExplorationPage(), "The user is not on the program exploration page.");
    }
    public ProgramExplorer(List<Program> programs) {
        this.programs = programs;
        this.filteredPrograms = programs;
    }
    public List<Program> filterProgramsByDifficulty(String difficultyLevel) {
        filteredPrograms = programs.stream()
                .filter(program -> program.getDifficultyLevel().equalsIgnoreCase(difficultyLevel))
                .collect(Collectors.toList());
        return filteredPrograms;
    }
    public List<Program> filterProgramsByFocusArea(String focusArea) {
        filteredPrograms = filteredPrograms.stream()
                .filter(program -> program.getFocusArea().equalsIgnoreCase(focusArea))
                .collect(Collectors.toList());
        return filteredPrograms;
    }


    public ProgramExplorer() {

        this.onProgramExplorationPage = false;
    }

    public void navigateToProgramExplorationPage() {

        this.onProgramExplorationPage = true;
    }

    public boolean isOnProgramExplorationPage() {
        return this.onProgramExplorationPage;
    }
    public List<Program> getPrograms() {
        return programs;
    }
    public void clearFilters() {
        filteredPrograms = programs;
    }
    public List<Program> getFilteredPrograms() {
        return filteredPrograms;
    }
    public boolean clickClearFiltersButton() {

        this.filteredPrograms = new ArrayList<>(allPrograms);
        System.out.println("Filters cleared.");
        return true;
    }
}
