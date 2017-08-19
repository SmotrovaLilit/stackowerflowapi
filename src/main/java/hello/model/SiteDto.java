package hello.model;


public class SiteDto {
    private String favicon_url;
    private String site_url;
    private String name;
    private String audience;


    public String getName() {
        return name;
    }

    public String getAudience() {
        return audience;
    }

    public String getFavicon_url() {
        return favicon_url;
    }

    public String getSite_url() {
        return site_url;
    }
}
