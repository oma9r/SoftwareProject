package Fitness.AdminPackage;

/**
 * Represents an article with an author and content that can be approved.
 *
 * <p>This class is used to manage articles, including their authorship, content, and approval status.
 * </p>
 *
 * @author Ibrahim Mashaqi
 */
public class Article {

    /**
     * The author of the article.
     */
    private String author;

    /**
     * The content of the article.
     */
    private String content;

    /**
     * The approval status of the article.
     * Defaults to {@code false}.
     */
    private boolean approved = false;

    /**
     * Constructs a new Article with the specified author and content.
     *
     * @param author the author of the article.
     * @param content the content of the article.
     */
    public Article(String author, String content) {
        this.author = author;
        this.content = content;
    }


}