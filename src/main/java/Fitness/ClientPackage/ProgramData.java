package Fitness.ClientPackage;

import Fitness.InstructorP.ProgramPackage.Program;
import java.time.LocalDate;
import java.util.List;

/**
 * The {@code ProgramData} class provides a static method to retrieve a list of fitness programs.
 * <p>
 * Each program includes details such as its name, difficulty level, type, schedule, and duration. The class
 * does not allow instantiation, as it is designed solely to offer utility methods related to fitness programs.
 * This class encapsulates a collection of predefined programs and serves as a central point to access that data.
 * </p>
 *
 * <p>
 * The class contains a private constructor to prevent instances from being created. Its only public method is
 * {@link #getPrograms()}, which returns a static list of fitness programs with their associated details.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * List&lt;Program&gt; programs = ProgramData.getPrograms();
 * </pre>
 * </p>
 *
 * @author Abdulrhman M Sawalmeh
 * @see Program
 */
public class ProgramData {

    /**
     * Private constructor to prevent instantiation of the {@code ProgramData} class.
     * <p>
     * This constructor is intentionally left empty. The class is designed to be used only through
     * its static method {@link #getPrograms()}, and it should never be instantiated.
     * </p>
     */
    private ProgramData() {

    }

    /**
     * Retrieves a list of predefined fitness programs with their associated details.
     * <p>
     * This method returns a list of {@link Program} objects. Each program represents a fitness program
     * with details such as its name, difficulty level, type, schedule, and duration. The programs returned
     * are hardcoded and represent sample fitness programs for various levels of difficulty and types of fitness.
     * </p>
     *
     * @return a list of {@link Program} objects representing various fitness programs.
     * Each program contains the following details:
     * <ul>
     *   <li><b>Name</b>: The name of the fitness program (e.g., "Yoga Basics")</li>
     *   <li><b>Difficulty Level</b>: The difficulty level of the program (e.g., "Beginner")</li>
     *   <li><b>Type</b>: The type or category of the program (e.g., "Flexibility", "Muscle Building")</li>
     *   <li><b>Schedule</b>: The list of available time slots for the program (e.g., "09:00 AM - 10:00 AM")</li>
     *   <li><b>Duration</b>: The duration of the program (start and end dates)</li>
     * </ul>
     *
     * @see Program
     */
    public static List<Program> getPrograms() {
        return List.of(
                new Program("Yoga Basics", "Beginner", "flexible", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31),
                        List.of("09:00 AM - 10:00 AM", "10:30 AM - 11:30 AM", "01:00 PM - 02:00 PM")),
                new Program("Advanced Weightlifting", "Advanced", "Muscle Building",
                        LocalDate.of(2024, 2, 1), LocalDate.of(2024, 12, 31),
                        List.of("06:00 AM - 07:00 AM", "11:00 AM - 12:00 PM")),
                new Program("Intermediate Pilates", "Intermediate", "Flexibility",
                        LocalDate.of(2024, 3, 1), LocalDate.of(2024, 12, 31),
                        List.of("08:00 AM - 09:00 AM", "10:30 AM - 11:30 AM")),
                new Program("Yoga for Flexibility", "Beginner", "Flexibility",
                        LocalDate.of(2024, 4, 1), LocalDate.of(2024, 12, 31),
                        List.of("09:00 AM - 10:00 AM", "11:00 AM - 12:00 PM")),
                new Program("Muscle Building for Strength", "Advanced", "Muscle Building",
                        LocalDate.of(2024, 5, 1), LocalDate.of(2024, 12, 31),
                        List.of("07:00 AM - 08:00 AM", "01:00 PM - 02:00 PM"))
        );
    }
}
