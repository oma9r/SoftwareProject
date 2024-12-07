package Fitness;

public class Client extends User {
    private UserStatus status;
    private boolean premium;

    public Client(String name, int age, String gender, String address, String email, String pass,UserStatus status) {
        super(name, age, gender, address, email, pass,Role.Client);
        this.status = status;
    }

    public Client() {
        super();
        status=UserStatus.Active;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus userStatus) {
        this.status = userStatus;
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
}
