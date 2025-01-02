package Fitness.ClientPackage;

/**
 * Represents a filter for selecting the difficulty level of a fitness program.
 * This class allows setting and getting the difficulty level based on user selection.
 *
 * @author Abdulrhman M Sawalmeh
 */
public class FilterSelection {

    private String difficultyLevel;

    /**
     * Selects a difficulty level for the fitness program.
     *
     * @param level the difficulty level to set (e.g., "Easy", "Medium", "Hard")
     */
    public void selectDifficultyLevel(String level) {
        this.difficultyLevel = level;
    }
}
