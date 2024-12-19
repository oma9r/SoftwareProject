package Fitness;

public class Program {
    String title;
    String goals;
    int enrollments;
    int duration;
    String difficulty;
    Status status;
    float revenue=0;
    Session [] sessions;

    public Program(String title, String goals, int enrollments, int duration, String difficulty) {
        this.title = title;
        this.goals = goals;
        this.enrollments = enrollments;
        this.duration = duration;
        this.difficulty = difficulty;
        this.status = Status.Active;

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

    public Session[] getSessions() {
        return sessions;
    }

    public int getTime() {
        return duration;
    }
    public Status isComplete() {
        return status;
    }
}
