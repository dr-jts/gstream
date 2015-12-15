package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.function.TransformFn;

public class TransformGstream extends GstreamBase {

  private TransformFn fn;
  private Gstream gstream;

  public TransformGstream(Gstream gstream, TransformFn fn) {
    this.gstream = gstream;
    this.fn = fn;
  }

  @Override
  public GstreamIt iterator() {
    return new GstreamIt() {
      GstreamIt it = gstream.iterator();
      @Override
      public Geob next() {
        Geob go = it.next();
        if (go == null) return null;
        Geob trans = fn.f(go);
        return trans;
      }
      
    };
  }

}
