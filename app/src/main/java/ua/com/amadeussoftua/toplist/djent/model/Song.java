package ua.com.amadeussoftua.toplist.djent.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "songs")
public class Song {
    @DatabaseField(id = true)
    private int id;
    @DatabaseField()
    private String objectId;
    @DatabaseField
    private String song_name;
    @DatabaseField
    private String link_youtube;
    @DatabaseField
    private String link_last_fm;
    @DatabaseField
    private String link_play;
    @DatabaseField
    private String artist_id;
    @DatabaseField
    private Integer likes;
    @DatabaseField
    private Integer dislikes;

    public Song() {
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getLink_youtube() {
        return link_youtube;
    }

    public void setLink_youtube(String link_youtube) {
        this.link_youtube = link_youtube;
    }

    public String getLink_last_fm() {
        return link_last_fm;
    }

    public void setLink_last_fm(String link_last_fm) {
        this.link_last_fm = link_last_fm;
    }

    public String getLink_play() {
        return link_play;
    }

    public void setLink_play(String link_play) {
        this.link_play = link_play;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }

    public float getRate() {
        return (float) likes/(float)dislikes;
    }

}