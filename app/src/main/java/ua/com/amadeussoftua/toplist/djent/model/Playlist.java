package ua.com.amadeussoftua.toplist.djent.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "playlists")
public class Playlist {
    @DatabaseField(id = true)
    private String objectId;
    @DatabaseField
    private Date updated;
    @DatabaseField
    private String image_url;
    @DatabaseField
    private String link;
    @DatabaseField
    private Integer listeners;
    @DatabaseField
    private Integer rate;
    @DatabaseField
    private Date created;
    @DatabaseField
    private String style;
    @DatabaseField
    private String name_en;

    public Playlist() {
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getObjectId() {
        return objectId;
    }

    public Integer getListeners() {
        return listeners;
    }

    public void setListeners(Integer listeners) {
        this.listeners = listeners;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name_en;
    }
}