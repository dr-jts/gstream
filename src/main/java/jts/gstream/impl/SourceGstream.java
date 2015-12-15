package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.function.SourceFn;

public class SourceGstream extends GstreamBase {

  private SourceFn fn;
  private Gschema schema;

  public SourceGstream(Gschema schema, SourceFn fn) {
    this.schema = schema;
    this.fn = fn;
  }

  @Override
  public GstreamIt iterator() {
    return new GstreamIt() {
      public Geob next() {
        return fn.f(schema);
      }
      
    };
  }

}
