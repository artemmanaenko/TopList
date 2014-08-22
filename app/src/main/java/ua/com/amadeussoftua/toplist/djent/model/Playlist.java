package ua.com.amadeussoftua.toplist.djent.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "playlists")
public class Playlist {

    public static final String COLUMN_NAME_EN = "name_en";

    @DatabaseField(id = true)
    private int id;
    @DatabaseField()
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
    private Integer likes;
    @DatabaseField
    private Integer dislikes;
    @DatabaseField
    private Date created;
    @DatabaseField
    private String style;
    @DatabaseField
    private String name_en;

    public Playlist() {
    }

    public int getId() {
        return id;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public String getImageUrl() {
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

    public float getRate() {
        return (float) likes/(float)dislikes;
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