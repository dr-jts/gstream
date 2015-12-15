package jts.gstream.function;

import jts.gstream.Geob;
import jts.gstream.GeobMutable;


public interface MapFunction {
  void fun(Geob in, GeobMutable out);
}
