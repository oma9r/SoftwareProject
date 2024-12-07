package Fitness;

public class Session {
    Program program;
    int participants;
    Session(Program program) {
        this.program = program;
        participants = 0;

    }
    @Override
    public String toString() {
        return "Session [program=" + program + ", participants=" + participants + "]";
    }
}
