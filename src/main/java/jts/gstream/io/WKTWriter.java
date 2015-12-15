package jts.gstream.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import jts.gstream.Geob;
import jts.gstream.Gstream;
import jts.gstream.function.SinkFn;

public class WKTWriter {
  
  public static void write(Gstream gstream) throws IOException {
    WKTWriter writer = new WKTWriter(gstream);
    writer.write(new PrintWriter(System.out));
  }

  
  private Gstream gstream;

  public WKTWriter(Gstream gstream) {
    this.gstream = gstream;
  }
  
  public void write(String filename) throws IOException {
    write(new PrintWriter(new FileWriter(new File(filename))));
  }

  public void write(final PrintWriter writer) throws IOException {
    gstream.forEach( new SinkFn() { public void f(Geob in) {
      writer.println(in.getGeom());
    }});
    writer.close();
  }

  public void write() throws IOException {
    write(new PrintWriter(System.out));
    
  }

}
