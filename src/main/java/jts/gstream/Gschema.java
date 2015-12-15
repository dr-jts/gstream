package jts.gstream;

public class Gschema {

  public static Gschema schema(String... name) {
    return new Gschema(name);
  }

  /*
  public static Gschema create(String name1, String name2) {
    return new Gschema(new String[] { name1, name2 });
  }
  */
  
  private String[] names;

  Gschema(String[] names) {
    this.names = names.clone();
  }
  
  public int index(String name) {
    for (int i = 0; i < names.length; i++) {
      if (name.equals(names[i])) return i;
    }
    return -1;
  }

  public int indexChecked(String name) {
    for (int i = 0; i < names.length; i++) {
      if (name.equals(names[i])) return i;
    }
    throw new GStreamException("Property not found: " + name);
  }

  public int size() {
    return names.length;
  }

  public String name(int i) {
    return names[i];
  }

}
