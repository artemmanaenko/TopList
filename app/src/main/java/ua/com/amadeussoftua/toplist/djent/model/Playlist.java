package ua.com.amadeussoftua.toplist.djent.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Playlist
{
  private java.util.Date updated;
  private String image_url;
  private String link;
  private String objectId;
  private String ownerId;
  private Integer listeners;
  private Integer rate;
  private java.util.Date created;
  private String style_id;
  private String name_id;

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

  public String getLink()
  {
    return link;
  }

  public void setLink( String link )
  {
    this.link = link;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getListeners()
  {
    return listeners;
  }

  public void setListeners( Integer listeners )
  {
    this.listeners = listeners;
  }

  public Integer getRate()
  {
    return rate;
  }

  public void setRate( Integer rate )
  {
    this.rate = rate;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getStyle_id()
  {
    return style_id;
  }

  public void setStyle_id( String style_id )
  {
    this.style_id = style_id;
  }

  public String getName_id()
  {
    return name_id;
  }

  public void setName_id( String name_id )
  {
    this.name_id = name_id;
  }

                                                    
  public Playlist save()
  {
    return Backendless.Data.of( Playlist.class ).save( this );
  }

  public Future<Playlist> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Playlist> future = new Future<Playlist>();
      Backendless.Data.of( Playlist.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Playlist> callback )
  {
    Backendless.Data.of( Playlist.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Playlist.class ).remove( this );
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
      Backendless.Data.of( Playlist.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Playlist.class ).remove( this, callback );
  }

  public static Playlist findById( String id )
  {
    return Backendless.Data.of( Playlist.class ).findById( id );
  }

  public static Future<Playlist> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Playlist> future = new Future<Playlist>();
      Backendless.Data.of( Playlist.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Playlist> callback )
  {
    Backendless.Data.of( Playlist.class ).findById( id, callback );
  }

  public static Playlist findFirst()
  {
    return Backendless.Data.of( Playlist.class ).findFirst();
  }

  public static Future<Playlist> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Playlist> future = new Future<Playlist>();
      Backendless.Data.of( Playlist.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Playlist> callback )
  {
    Backendless.Data.of( Playlist.class ).findFirst( callback );
  }

  public static Playlist findLast()
  {
    return Backendless.Data.of( Playlist.class ).findLast();
  }

  public static Future<Playlist> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Playlist> future = new Future<Playlist>();
      Backendless.Data.of( Playlist.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Playlist> callback )
  {
    Backendless.Data.of( Playlist.class ).findLast( callback );
  }

  public static BackendlessCollection<Playlist> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Playlist.class ).find( query );
  }

  public static Future<BackendlessCollection<Playlist>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Playlist>> future = new Future<BackendlessCollection<Playlist>>();
      Backendless.Data.of( Playlist.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Playlist>> callback )
  {
    Backendless.Data.of( Playlist.class ).find( query, callback );
  }
}