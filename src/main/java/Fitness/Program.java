package Fitness;

public class Program {
    String title;
    String goals;
    int enrollments;
    int duration;
    String difficulty;
    boolean complete;
    float revenue=0;

    public Program(String title, String goals, int enrollments, int duration, String difficulty) {
        this.title = title;
        this.goals = goals;
        this.enrollments = enrollments;
        this.duration = duration;
        this.difficulty = difficulty;
        this.complete = false;

    }

    @Override
    public String toString() {
        return "[Title"+title+" Goals"+goals+" Enrollments"+enrollments+" Duration"+duration+" Difficulty"+difficulty+"]\n";
    }

    public String getTitle() {
        return title;
    }

    public float getRevenue() {
        return revenue;
    }
}
