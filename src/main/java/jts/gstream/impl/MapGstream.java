package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.Gschema;
import jts.gstream.Gstream;
import jts.gstream.GstreamIt;
import jts.gstream.function.MapFunction;
import jts.gstream.function.TransformFn;

public class MapGstream extends GstreamBase {

  private Gschema schema;
  private MapFunction mapper;
  private Gstream gstream;
  
  public MapGstream(Gstream gstream, Gschema schema, MapFunction mapper) {
    this.gstream = gstream;
    this.schema = schema;
    this.mapper = mapper;
  }

  @Override
  public GstreamIt iterator() {
    Gstream trans = new TransformGstream(gstream, new TransformFn() {

      @Override
      public Geob f(Geob in) {
        GeobImpl out = new GeobImpl(schema);
        out.set(in);
        mapper.fun(in, out);
        return out;
      }
      
    });
    return trans.iterator();
  }

}
