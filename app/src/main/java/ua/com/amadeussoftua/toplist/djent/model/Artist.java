package ua.com.amadeussoftua.toplist.djent.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "artists")
public class Artist {
    @DatabaseField(id = true)
    private String objectId;
    @DatabaseField
    private String link_play;
    @DatabaseField
    private Date created;
    @DatabaseField
    private String name;
    @DatabaseField
    private String ownerId;
    @DatabaseField
    private String link_last_fm;
    @DatabaseField
    private Date updated;
    @DatabaseField
    private String image_url;
    @DatabaseField
    private Integer rate;

    public Artist() {
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getLink_play() {
        return link_play;
    }

    public void setLink_play(String link_play) {
        this.link_play = link_play;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getLink_last_fm() {
        return link_last_fm;
    }

    public void setLink_last_fm(String link_last_fm) {
        this.link_last_fm = link_last_fm;
    }
}