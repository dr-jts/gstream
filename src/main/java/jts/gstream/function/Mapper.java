package jts.gstream.function;

import com.vividsolutions.jts.geom.Geometry;

import jts.gstream.Geob;
import jts.gstream.GeobMutable;
import jts.gstream.Gschema;
import jts.gstream.PropertySet;
import jts.gstream.PropertyGet;

public abstract class Mapper implements PropertyGet, PropertySet, MapFunction {

  private Geob in;
  private GeobMutable out;
  
  @Override
  public void fun(Geob in, GeobMutable out) {
    this.in = in;
    this.out = out;
    f();
    
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

  public void set(String name, Object o) {
    out.set(name, o);
  }
  
  public void set(Geometry geom) {
    out.set(geom);
  }
  
  public Gschema schema() {
    return in.schema();
  }
  public abstract void f();

}
