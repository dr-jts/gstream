package jts.gstream.impl;

import java.util.Comparator;

import jts.gstream.Geob;

public class GeobComparator 
  implements Comparator
{
  private Comparator valueComparator = null;
  
  public GeobComparator() {
  }
  
  public GeobComparator(Comparator valueComparator) 
  {
    this.valueComparator = valueComparator;
  }
  
  public int compare(Object o1, Object o2)
  {
    Geob g1 = (Geob) o1;
    Geob g2 = (Geob) o2;
    
    int g1Size = g1.schema().size();
    int g2Size = g2.schema().size();
    int size = Math.min(g1Size, g2Size);
    
    for (int i = 0; i < size; i++) {
      Object v1 = g1.schema().name(i);
      Object v2 = g2.schema().name(i);
      
      // have to assume that null values are the same, since we don't have further type information
      if (v1 == null && v2 == null)
        return 0;
      
      int comp = -999;
      if (valueComparator != null)
        comp = valueComparator.compare(v1, v2);
      else
        comp = TypeUtil.compareValue(v1, v2);
      
      if (comp != 0)
        return comp;
    }
    return 0;
  }

}
