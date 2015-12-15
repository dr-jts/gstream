package jts.gstream.example;

import jts.geom.Geom;
import jts.gstream.Geob;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.Gstreams;
import jts.gstream.function.Mapper;
import jts.gstream.function.Filter;
import jts.gstream.function.FilterFn;
import jts.gstream.function.SinkFn;

public class GstreamExample {

  public static void main(String[] args) {
    GstreamExample ex = new GstreamExample();
    try {
      ex.example1();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  void example1() {
    Gstreams.sequence( "x", 1, 5, "y", 1, 5 )
      .map( Gschema.schema( "i", "x", "y", "xy" ),
          new Mapper() { public void f() {
            set( "i", count++);
            set( "xy", getInt("x") + getInt("y"));
            set( Geom.point( getInt("x"), getInt("y") ));
          }
          int count = 0;
      })
      .skip(2)
      .filter( new Filter() { public boolean f() {
          return getInt("xy") % 2 == 0;
        }})
      .limit(5)
      .forEach( new SinkFn() { public void f(Geob in) {
            System.out.println(in);
          }});
  }
  void example2() {
    Gstream s2 = Gstreams.create(Gschema.schema("x", "y", "xy"), 
        new Object[][] { 
        { 1, 1, 2 }
    });
    
  }


}
