package jts.gstream.function;

import jts.gstream.Geob;
import jts.gstream.Gschema;

public interface SourceFn {

  public Geob f(Gschema schema);

}
