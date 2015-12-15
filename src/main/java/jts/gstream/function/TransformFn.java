package jts.gstream.function;

import jts.gstream.Geob;

public interface TransformFn {
  /**
   * Transforms an input Geob into an output Geob.
   * The input gob should not be modified.
   * 
   * @param in
   * @return a new transformed gob.
   */
  Geob f(Geob in);

}
