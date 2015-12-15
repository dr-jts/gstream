package jts.gstream.example;

import java.io.IOException;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

import jts.geom.Geom;
import jts.gstream.Gstreams;
import jts.gstream.Geob;
import jts.gstream.GeobMutable;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.function.MapFunction;
import jts.gstream.function.Mapper;
import jts.gstream.function.FilterFn;
import jts.gstream.function.SinkFn;
import jts.gstream.io.WKTWriter;


public class WKTWriterExample {

  public static void main(String[] args) {
    WKTWriterExample ex = new WKTWriterExample();
    try {
      ex.example();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  void example() throws IOException {
    Gstream gs = Gstreams.sequence(
        "x", 1, 10, 
        "y", 1, 10 )
      .map( Gschema.schema("x", "y"),
          new Mapper() { public void f() {
            set(Geom.point(getInt("x"), getInt("y")));
           }});
    
    WKTWriter.write(gs);
    
  }

}
