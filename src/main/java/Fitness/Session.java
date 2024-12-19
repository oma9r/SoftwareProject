package Fitness;

public class Session {
    String program;
    int participants;

    @Override
    public String toString() {
        return "Session [program=" + program + ", participants=" + participants + "]";
    }


    public int getAttendance() {
        return participants;
    }
}
