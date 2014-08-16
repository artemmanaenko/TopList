package ua.com.amadeussoftua.toplist.djent.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Artist
{
  private java.util.Date updated;
  private String image_url;
  private Integer rate;
  private String objectId;
  private String link_play;
  private java.util.Date created;
  private String name;
  private String ownerId;
  private String link_last_fm;

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getImage_url()
  {
    return image_url;
  }

  public void setImage_url( String image_url )
  {
    this.image_url = image_url;
  }

  public Integer getRate()
  {
    return rate;
  }

  public void setRate( Integer rate )
  {
    this.rate = rate;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getLink_play()
  {
    return link_play;
  }

  public void setLink_play( String link_play )
  {
    this.link_play = link_play;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getLink_last_fm()
  {
    return link_last_fm;
  }

  public void setLink_last_fm( String link_last_fm )
  {
    this.link_last_fm = link_last_fm;
  }

                                                    
  public Artist save()
  {
    return Backendless.Data.of( Artist.class ).save( this );
  }

  public Future<Artist> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Artist> future = new Future<Artist>();
      Backendless.Data.of( Artist.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Artist> callback )
  {
    Backendless.Data.of( Artist.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Artist.class ).remove( this );
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
      Backendless.Data.of( Artist.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Artist.class ).remove( this, callback );
  }

  public static Artist findById( String id )
  {
    return Backendless.Data.of( Artist.class ).findById( id );
  }

  public static Future<Artist> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Artist> future = new Future<Artist>();
      Backendless.Data.of( Artist.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Artist> callback )
  {
    Backendless.Data.of( Artist.class ).findById( id, callback );
  }

  public static Artist findFirst()
  {
    return Backendless.Data.of( Artist.class ).findFirst();
  }

  public static Future<Artist> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Artist> future = new Future<Artist>();
      Backendless.Data.of( Artist.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Artist> callback )
  {
    Backendless.Data.of( Artist.class ).findFirst( callback );
  }

  public static Artist findLast()
  {
    return Backendless.Data.of( Artist.class ).findLast();
  }

  public static Future<Artist> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Artist> future = new Future<Artist>();
      Backendless.Data.of( Artist.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Artist> callback )
  {
    Backendless.Data.of( Artist.class ).findLast( callback );
  }

  public static BackendlessCollection<Artist> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Artist.class ).find( query );
  }

  public static Future<BackendlessCollection<Artist>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Artist>> future = new Future<BackendlessCollection<Artist>>();
      Backendless.Data.of( Artist.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Artist>> callback )
  {
    Backendless.Data.of( Artist.class ).find( query, callback );
  }
}