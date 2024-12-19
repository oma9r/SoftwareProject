package Fitness.InstructorP.ProgramPackage;

public class tutorialTypeProgram
{
    private String video;
    private String image;
    private String document;

    public tutorialTypeProgram()
    {
        this.setImage("");
        this.setVideo("");
        this.setDocument("");

    }

    public tutorialTypeProgram(String video, String image, String document)
    {
        this.setVideo(video);
        this.setImage(image);
        this.setDocument(document);
    }

    public tutorialTypeProgram(String tutorial,String type)
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



    public void setVideo(String video)
    {
        this.video = video;
    }

    public String getVideo()
    {
        return this.video;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
    public String getImage()
    {
        return this.image;
    }

    public void setDocument(String document)
    {
        this.document = document;
    }

    public String getDocument()
    {
        return this.document;
    }

}
