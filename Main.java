/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author tony.tian
 */
import java.util.Arrays;
public class Main {

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
  // TODO code application logic here
  Generator gen = new Generator();
  Comparable[] testnlogn = gen.generateArray(20);
  Comparable[] testn2 = gen.generateArray(20);
  Integer[] testInteger = gen.generateArrayInteger(100000);
  TonySort mysort = new TonySort();
  Long start = System.currentTimeMillis();

  //mysort.sortnlgn(testnlogn);
  //mysort.sortnlgnAlt(testnlogn);
  //mysort.sortn2(testn2);
  //mysort.sortn2Alt(testn2);
  mysort.wildcard(testInteger);
  //Arrays.sort(testnlogn);
  Long end = System.currentTimeMillis();

  /*for(Comparable i : testInteger)
  {
       System.out.println(i);
  }*/
  System.out.println(end - start + " time");
 }
}
