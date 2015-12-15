package jts.gstream.impl;

import jts.gstream.Geob;
import jts.gstream.GeobMutable;
import jts.gstream.Gschema;

import com.vividsolutions.jts.geom.Geometry;

public class GeobImpl implements GeobMutable {

  private Object[] attr;
  private Geometry geom;
  private Gschema schema;

  public GeobImpl(Gschema schema) {
    this.schema = schema;
    attr = new Object[schema.size()];
  }
  
  public Gschema schema() {
    return schema;
  }
  @Override
  public Object get(String name) {
    return attr[schema.index(name)];
  }

  @Override
  public int getInt(String name) {
    return (Integer) get(name);
  }

  @Override
  public void set(String name, Object o) {
    attr[schema.indexChecked(name)] = o;
  }

  @Override
  public void set(Geometry geom) {
    this.geom = geom;
    
  }

  @Override
  public Geometry getGeom() {
    return geom;
  }

  public void set(String string, int i) {
    set(string, (Integer) i);
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < attr.length; i++) {
      sb.append(schema.name(i) + ": " + attr[i] + ", ");
    }
    sb.append(geom);
    return sb.toString();
  }

  @Override
  public void set( Geob go, String name ) {
    set(name, go.get(name));
  }

  @Override
  public void set(Geob in) {
    Gschema inSchema = in.schema();
    for (int i = 0; i < inSchema.size(); i++) {
      String name = inSchema.name(i);
      int index = schema.index(name);
      if (index >= 0) {
        set(name, in.get(name));
      }
    }
  }

  @Override
  public int compareTo(Object obj) {
    Geob other = (Geob) obj;
    int schemaSz = other.schema().size(); 
    for (int i = 0; i < attr.length; i++) {
      if (i >= schemaSz) {
        return 1;
      }
      //int cmp = get(schema.name(i)).compareTo(other.get(other.schema().name(i)));
    }
    return 0;
  }

}
