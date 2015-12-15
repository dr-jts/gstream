package jts.gstream;

import com.vividsolutions.jts.geom.Geometry;

public interface PropertySet {
  
  public void set(Geometry geom);
  void set(String name, Object o);

}
