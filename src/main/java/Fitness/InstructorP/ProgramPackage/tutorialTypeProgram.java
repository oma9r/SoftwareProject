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
     * Sets the video tutorial content.
     *
     * @param video the video tutorial content
     */
    public void setVideo(String video)
    {
        this.video = video;
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
     * Sets the document tutorial content.
     *
     * @param document the document tutorial content
     */
    public void setDocument(String document)
    {
        this.document = document;
    }


}
