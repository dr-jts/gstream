package jts.gstream;

import java.util.ArrayList;
import java.util.List;

import jts.gstream.function.SinkFn;
import jts.gstream.function.SourceFn;
import jts.gstream.impl.GeobImpl;
import jts.gstream.impl.ListGstream;
import jts.gstream.impl.SourceGstream;


public class Gstreams {

  public static Gstream sequence(final String name1, final int min1, final int max1) {
    Gschema schema = Gschema.schema(name1);
    return new SourceGstream(schema, new SourceFn() { 
      int count1 = min1;
      boolean isDone = false;
      
      public Geob f(Gschema schema) {
        if (min1 > max1) isDone = true;
        if (isDone) return null;
        GeobImpl go = new GeobImpl(schema);
        go.set(name1, count1);
          if (count1 == max1) { 
            isDone = true;
          }
          else {
            count1++;
          }
        return go;
    }});
  }

  public static Gstream sequence(final String name1, final int min1, final int max1, 
      final String name2, final int min2, final int max2) {
    Gschema schema = Gschema.schema(name1, name2);
    return new SourceGstream(schema, new SourceFn() { 
      int count1 = min1;
      int count2 = min2;
      boolean isDone = false;
      
      public Geob f(Gschema schema) {
        if (min1 > max1 || min2 > max2) isDone = true;
        if (isDone) return null;
        GeobImpl go = new GeobImpl(schema);
        go.set(name1, count1);
        go.set(name2, count2);
        if (count2 == max2) {
          count2 = min2;
          if (count1 == max1) { 
            isDone = true;
          }
          else {
            count1++;
          }
        } else {
          count2++;
        }
        return go;
    }});
  }

  public static List<Geob> toList(Gstream stream) {
    final List list = new ArrayList();
    stream.forEach(new SinkFn() {

      @Override
      public void f(Geob go) {
        list.add(go);
      }
    });
    return list;
  }

  public static Gstream create(Gschema schema, Object[][] values) {
    List valList = new ArrayList();
    for (int i = 0; i < values.length; i++) {
      GeobImpl go = new GeobImpl(schema);
      for (int j = 0; j < values[i].length; j++) {
        go.set(schema.name(j), values[i][j]);
      }
      valList.add(go);
    }
    return new ListGstream(valList);
  };
  
}
