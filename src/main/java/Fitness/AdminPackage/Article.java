package Fitness.AdminPackage;

public class Article {
    private String author;
    private String content;
    private boolean approved = false;
    public Article(String author, String content)
    {
        this.author = author;
        this.content = content;
    }

    public void setApprove(boolean b) {
        approved = b;
    }
}
