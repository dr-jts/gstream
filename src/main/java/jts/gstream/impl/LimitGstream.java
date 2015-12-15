package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;

public class LimitGstream extends GstreamBase {
  private Gstream stream;
  private int limit;

  public LimitGstream(GstreamBase stream, int n) {
    this.stream = stream;
    this.limit = n;
  }

  public GstreamIt iterator() {
    return new GstreamIt() {
      GstreamIt it = stream.iterator();
      int count = 0;
      @Override
      public Geob next() {
        while (true) {
          Geob go = it.next();
          count++;
          if (go == null) return null;
          boolean ok = count <= limit;
          if (! ok) continue;
          return go;
        }
      }
    };
  }

}
