package Fitness.InstructorP.ProgramPackage;

/**
 * The {@code tutorialTypeProgram} class represents a tutorial type with different content formats.
 * It includes the options of a video, an image, or a document as tutorial materials.
 * The class provides methods for setting and getting the tutorial content in each format.
 * It supports multiple constructors for initializing the tutorial type and content based on the given input.
 *
 * @author Omar Abumazen
 */
public class tutorialTypeProgram
{
    private String video;
    private String image;
    private String document;

    /**
     * Default constructor that initializes all tutorial content (video, image, and document) as empty strings.
     */
    public tutorialTypeProgram()
    {
        this.setImage("");
        this.setVideo("");
        this.setDocument("");
    }

    /**
     * Constructs a {@code tutorialTypeProgram} instance with the specified tutorial content for video, image, and document.
     *
     * @param video the video tutorial content
     * @param image the image tutorial content
     * @param document the document tutorial content
     */
    public tutorialTypeProgram(String video, String image, String document)
    {
        this.setVideo(video);
        this.setImage(image);
        this.setDocument(document);
    }

    /**
     * Constructs a {@code tutorialTypeProgram} instance based on the specified tutorial and its type.
     * The type could be "video", "image", or "document", and only one of these content types will be initialized.
     *
     * @param tutorial the tutorial content
     * @param type the type of the tutorial content ("video", "image", or "document")
     */
    public tutorialTypeProgram(String tutorial, String type)
    {
        if(type.equals("video"))
        {
            this.setVideo(tutorial);
            this.setImage("");
            this.setDocument("");
        }
        else if(type.equals("image"))
        {
            this.setImage(tutorial);
            this.setDocument("");
            this.setVideo("");
        }
        else if (type.equals("document"))
        {
            this.setDocument(tutorial);
            this.setImage("");
            this.setVideo("");
        }
    }

    /**
     * Sets the video tutorial content.
     *
     * @param video the video tutorial content
     */
    public void setVideo(String video)
    {
        this.video = video;
    }

    /**
     * Returns the video tutorial content.
     *
     * @return the video tutorial content
     */
    public String getVideo()
    {
        return this.video;
    }

    /**
     * Sets the image tutorial content.
     *
     * @param image the image tutorial content
     */
    public void setImage(String image)
    {
        this.image = image;
    }

    /**
     * Returns the image tutorial content.
     *
     * @return the image tutorial content
     */
    public String getImage()
    {
        return this.image;
    }

    /**
     * Sets the document tutorial content.
     *
     * @param document the document tutorial content
     */
    public void setDocument(String document)
    {
        this.document = document;
    }

    /**
     * Returns the document tutorial content.
     *
     * @return the document tutorial content
     */
    public String getDocument()
    {
        return this.document;
    }
}
