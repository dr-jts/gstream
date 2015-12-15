package jts.geom;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

public class Geom {
  public static GeometryFactory GEOM_FACTORY = new GeometryFactory();
  
  public static Geometry point(double x, double y) {
    return point(GEOM_FACTORY, x, y);
  }
  public static Geometry point(GeometryFactory gf, double x, double y) {
    return gf.createPoint(new Coordinate(x, y));
  }
}
