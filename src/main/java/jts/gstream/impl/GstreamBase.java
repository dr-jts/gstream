package jts.gstream.impl;

import java.util.List;

import jts.gstream.Geob;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.Gstreams;
import jts.gstream.function.MapFunction;
import jts.gstream.function.FilterFn;
import jts.gstream.function.SinkFn;

public abstract class GstreamBase implements Gstream {

  @Override
  public Gstream map(Gschema schema, MapFunction mapper) {
    return new MapGstream(this, schema, mapper);
  }

  @Override
  public void forEach(SinkFn sink) {
    GstreamIt it = iterator();
    Geob go;
    while ((go = it.next()) != null) {
      sink.f(go);
    }
  }
  
  public Gstream filter(FilterFn pred) {
    return new FilterGstream(this, pred);
  }

  public Gstream skip(int n) {
    return new SkipGstream(this, n);
  }
  
  public Gstream limit(int n) {
    return new LimitGstream(this, n);
  }
  
  public Gstream memoize()
  {
    return new ListGstream(this);
  }
  
  public List<Geob> toList() {
    return Gstreams.toList(this);
  }

}
