package jts.gstream;

import java.util.List;

import jts.gstream.function.MapFunction;
import jts.gstream.function.FilterFn;
import jts.gstream.function.SinkFn;



public interface Gstream {

  Gstream map(Gschema schema, MapFunction mapper);

  void forEach(SinkFn sink);
  
  Gstream skip(int n);
  
  Gstream limit(int n);
  
  GstreamIt iterator();
  
  List toList();

  Gstream filter(FilterFn predFn);

  Gstream memoize();
}
