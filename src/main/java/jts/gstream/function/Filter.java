package jts.gstream.function;

import com.vividsolutions.jts.geom.Geometry;

import jts.gstream.Geob;
import jts.gstream.GeobMutable;
import jts.gstream.Gschema;
import jts.gstream.PropertySet;
import jts.gstream.PropertyGet;

public abstract class Filter implements PropertyGet, FilterFn {

  private Geob in;
  
  @Override
  public boolean fun(Geob in) {
    this.in = in;
    return f();
    
  }
  
  public Object get(String name)
  {
    return in.get(name);
  }
  public int getInt(String name) {
    return in.getInt(name);
  }

  public Geometry getGeom(){
    return in.getGeom();
  }
  
  public Gschema schema() {
    return in.schema();
  }
  public abstract boolean f();

}
