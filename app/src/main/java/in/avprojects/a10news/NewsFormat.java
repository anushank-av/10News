package in.avprojects.a10news;

/**
 * Created by anushank_av on 6/4/17.
 */

public class NewsFormat {
    private String imgRes;
    private String headline;
    private String description;

    public NewsFormat(String imgRes, String headline, String description){
        this.imgRes = imgRes;
        this.headline = headline;
        this.description = description;

    }
    public String getImgRes(){return imgRes;}
    public String getHeadline(){return headline;}
    public String getDescription(){return description;}
}
