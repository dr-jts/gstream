package jts.gstream.impl;

import java.util.Iterator;
import java.util.List;

import jts.gstream.Geob;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.Gstreams;
import jts.gstream.function.MapFunction;
import jts.gstream.function.SinkFn;

public class ListGstream extends GstreamBase
{

  private List<Geob> values;

  public ListGstream(List values) {
    this.values = values;
  }

  public ListGstream(Gstream stream) {
    this.values = stream.toList();
  }

  public GstreamIt iterator() {
    return new GstreamIt() {
      Iterator<Geob> it = values.iterator();
      public Geob next() {
        if (! it.hasNext()) return null;
        return it.next();
      }
      
    };
  }

}
