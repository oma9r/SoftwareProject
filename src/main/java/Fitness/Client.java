package Fitness;

public class Client extends User {
    private Status status;
    private boolean premium;
    private Program program;
    private int programTime;

    public Client(String name, int age, String gender, String address, String email, String pass, Status status) {
        super(name, age, gender, address, email, pass,Role.Client);
        this.status = status;
    }

    public Client() {
        super();
        status= Status.Active;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public void submitFeedBack(String feed) {
        Application.notApprovedArticles.add(new Article(this.getName(),feed));
    }

    public boolean setPlan(String plan) {
        if(plan.equalsIgnoreCase("Premium")) {
            this.premium=true;
        }
        return premium;
    }

    public boolean isPremium() {
        return premium;
    }
    public String getPlan() {
        if(premium)
            return "Premium";
        return "Not Premium";
    }

    public Program getProgram() {
        return program;
    }

    public float getProgress() {


        return programTime/program.getTime();
    }
}
