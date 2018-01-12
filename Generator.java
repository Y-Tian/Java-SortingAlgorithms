/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author tony.tian
 */
public class Generator {

 public Comparable[] generateArray(int size) {
  Comparable[] array = new Comparable[size];
  for (int i = 0; i < size; i++) {
   array[i] = (int)(Math.random() * 2 * Integer.MAX_VALUE - Integer.MAX_VALUE);
  }
  return array;
 }

 public Integer[] generateArrayInteger(int size) {
  Integer[] array = new Integer[size];
  for (int i = 0; i < size; i++) {
   array[i] = (int)(Math.random() * 2 * Integer.MAX_VALUE - Integer.MAX_VALUE);
  }
  return array;
 }
}
