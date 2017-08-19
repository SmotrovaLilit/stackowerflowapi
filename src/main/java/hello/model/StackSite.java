package hello.model;


import hello.web.StacksiteController;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StackSite {

    @Id
    private String id;
    private String iconImageUrl;
    private String site;
    private String title;
    private String description;

    public StackSite(){

    }

    public StackSite(String id, String iconImageUrl, String site, String title, String description) {
        this.id = id;
        this.iconImageUrl = iconImageUrl;
        this.site = site;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getSite() {
        return site;
    }

    public String getIconImageUrl() {
        return iconImageUrl;
    }

    public String getId() {
        return id;
    }
}
