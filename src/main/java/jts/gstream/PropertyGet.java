package jts.gstream;

import com.vividsolutions.jts.geom.Geometry;

public interface PropertyGet {

  public Object get(String name);
  public int getInt(String name);
  public Geometry getGeom();

}
