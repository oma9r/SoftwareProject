package Fitness.ClientPackage;

import Fitness.InstructorP.ProgramPackage.Program;

import java.time.LocalDate;
import java.util.List;

public class ProgramData {
    public static List<Program> getPrograms()
    {
        return List.of
                (
                new Program("Yoga Basics", "Beginner", "Flexibility", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31),
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
                        LocalDate.of(2024, 5, 1),
                        LocalDate.of(2024, 12, 31),
                        List.of("07:00 AM - 08:00 AM", "01:00 PM - 02:00 PM"))
        );
    }
}
