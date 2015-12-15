package jts.gstream;

import com.vividsolutions.jts.geom.Geometry;

public interface GeobMutable extends Geob, PropertySet {

  public void set(Geob go, String name);
  
  public void set(Geometry geom);
  void set(String name, Object o);
  public void set(Geob in);

}
