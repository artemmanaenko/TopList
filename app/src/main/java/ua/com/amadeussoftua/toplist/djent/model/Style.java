package ua.com.amadeussoftua.toplist.djent.model;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Style
{
  private String ownerId;
  private java.util.Date created;
  private String name_id;
  private String objectId;
  private String style_id;
  private java.util.Date updated;

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getName_id()
  {
    return name_id;
  }

  public void setName_id( String name_id )
  {
    this.name_id = name_id;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getStyle_id()
  {
    return style_id;
  }

  public void setStyle_id( String style_id )
  {
    this.style_id = style_id;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public Style save()
  {
    return Backendless.Data.of( Style.class ).save( this );
  }

  public Future<Style> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Style> future = new Future<Style>();
      Backendless.Data.of( Style.class ).save(this, future);

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Style> callback )
  {
    Backendless.Data.of( Style.class ).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of( Style.class ).remove( this );
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
      Backendless.Data.of( Style.class ).remove(this, future);

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Style.class ).remove(this, callback);
  }

  public static Style findById( String id )
  {
    return Backendless.Data.of( Style.class ).findById( id );
  }

  public static Future<Style> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Style> future = new Future<Style>();
      Backendless.Data.of( Style.class ).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Style> callback )
  {
    Backendless.Data.of( Style.class ).findById(id, callback);
  }

  public static Style findFirst()
  {
    return Backendless.Data.of( Style.class ).findFirst();
  }

  public static Future<Style> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Style> future = new Future<Style>();
      Backendless.Data.of( Style.class ).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Style> callback )
  {
    Backendless.Data.of( Style.class ).findFirst(callback);
  }

  public static Style findLast()
  {
    return Backendless.Data.of( Style.class ).findLast();
  }

  public static Future<Style> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Style> future = new Future<Style>();
      Backendless.Data.of( Style.class ).findLast(future);

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Style> callback )
  {
    Backendless.Data.of( Style.class ).findLast(callback);
  }

  public static BackendlessCollection<Style> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Style.class ).find( query );
  }

  public static Future<BackendlessCollection<Style>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Style>> future = new Future<BackendlessCollection<Style>>();
      Backendless.Data.of( Style.class ).find(query, future);

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Style>> callback )
  {
    Backendless.Data.of( Style.class ).find(query, callback);
  }
}