package ua.com.amadeussoftua.toplist.djent.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Song
{
  private String ownerId;
  private String song_name;
  private java.util.Date updated;
  private String link_youtube;
  private java.util.Date created;
  private String link_last_fm;
  private String link_play;
  private String playlist_id;
  private String objectId;
  private String artist_id;
  private Integer rate;

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getSong_name()
  {
    return song_name;
  }

  public void setSong_name( String song_name )
  {
    this.song_name = song_name;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getLink_youtube()
  {
    return link_youtube;
  }

  public void setLink_youtube( String link_youtube )
  {
    this.link_youtube = link_youtube;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getLink_last_fm()
  {
    return link_last_fm;
  }

  public void setLink_last_fm( String link_last_fm )
  {
    this.link_last_fm = link_last_fm;
  }

  public String getLink_play()
  {
    return link_play;
  }

  public void setLink_play( String link_play )
  {
    this.link_play = link_play;
  }

  public String getPlaylist_id()
  {
    return playlist_id;
  }

  public void setPlaylist_id( String playlist_id )
  {
    this.playlist_id = playlist_id;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getArtist_id()
  {
    return artist_id;
  }

  public void setArtist_id( String artist_id )
  {
    this.artist_id = artist_id;
  }

  public Integer getRate()
  {
    return rate;
  }

  public void setRate( Integer rate )
  {
    this.rate = rate;
  }

                                                    
  public Song save()
  {
    return Backendless.Data.of( Song.class ).save( this );
  }

  public Future<Song> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Song> future = new Future<Song>();
      Backendless.Data.of( Song.class ).save(this, future);

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Song> callback )
  {
    Backendless.Data.of( Song.class ).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of( Song.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Song.class ).remove(this, future);

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Song.class ).remove(this, callback);
  }

  public static Song findById( String id )
  {
    return Backendless.Data.of( Song.class ).findById( id );
  }

  public static Future<Song> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Song> future = new Future<Song>();
      Backendless.Data.of( Song.class ).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Song> callback )
  {
    Backendless.Data.of( Song.class ).findById(id, callback);
  }

  public static Song findFirst()
  {
    return Backendless.Data.of( Song.class ).findFirst();
  }

  public static Future<Song> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Song> future = new Future<Song>();
      Backendless.Data.of( Song.class ).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Song> callback )
  {
    Backendless.Data.of( Song.class ).findFirst(callback);
  }

  public static Song findLast()
  {
    return Backendless.Data.of( Song.class ).findLast();
  }

  public static Future<Song> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Song> future = new Future<Song>();
      Backendless.Data.of( Song.class ).findLast(future);

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Song> callback )
  {
    Backendless.Data.of( Song.class ).findLast(callback);
  }

  public static BackendlessCollection<Song> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Song.class ).find( query );
  }

  public static Future<BackendlessCollection<Song>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Song>> future = new Future<BackendlessCollection<Song>>();
      Backendless.Data.of( Song.class ).find(query, future);

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Song>> callback )
  {
    Backendless.Data.of( Song.class ).find(query, callback);
  }
}