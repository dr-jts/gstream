package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.function.FilterFn;

public class FilterGstream extends GstreamBase {

  private Gstream stream;
  private FilterFn pred;

  public FilterGstream(Gstream stream, FilterFn pred) {
    this.stream = stream;
    this.pred = pred;
  }

  @Override
  public GstreamIt iterator() {
    return new GstreamIt() {
      GstreamIt it = stream.iterator();
      @Override
      public Geob next() {
        while (true) {
          Geob go = it.next();
          if (go == null) return null;
          boolean ok = pred.fun(go);
          if (! ok) continue;
          return go;
        }
      }
    };
  }

}
