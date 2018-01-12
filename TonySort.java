/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author tony.tian
 */
public class TonySort implements SortCompetitor {

 public String getOwner() {
  return "Tony";
 }

 public void sortnlgn(Comparable[] data) {
  medianQuickSort(data, 0, data.length - 1);
 }

 public void medianQuickSort(Comparable[] data, int left, int right) {
  if (left + 11 > right) //11
  {
   insertionSort(data, left, right + 1);
  } else {
   Comparable pivot = median(data, left, right);
   int partition = partition(data, left, right, pivot);
   medianQuickSort(data, left, partition - 1);
   medianQuickSort(data, partition + 1, right);
  }
 }

 public Comparable median(Comparable[] data, int left, int right) {
  int middle = (left + right) / 2;

  if (data[left].compareTo(data[middle]) > 0) {
   swap(data, left, middle);
  }
  if (data[left].compareTo(data[right]) > 0) {
   swap(data, left, right);
  }
  if (data[middle].compareTo(data[right]) > 0) {
   swap(data, middle, right);
  }

  swap(data, middle, right - 1);
  return data[right - 1];
 }

 public int partition(Comparable[] data, int left, int right, Comparable pivot) {
  int leftPartition = left;
  int rightPartition = right - 1;

  while (true) {
   while (data[++leftPartition].compareTo(pivot) < 0) //add before
   {;
   }
   while (data[--rightPartition].compareTo(pivot) > 0) //minus before
   {;
   }
   if (leftPartition >= rightPartition) {
    break;
   } else {
    swap(data, leftPartition, rightPartition);
   }
  }
  swap(data, leftPartition, right - 1);
  return leftPartition;
 }

 public void swap(Comparable[] data, int index1, int index2) {
  Comparable temp = data[index1];
  data[index1] = data[index2];
  data[index2] = temp;
 }

 public void insertionSort(Comparable[] data, int left, int size) {
  for (int i = left + 1; i < size; i++) {
   Comparable current = data[i];
   int k;
   for (k = i - 1; k >= 0 && (data[k].compareTo(current) > 0); k--) {
    data[k + 1] = data[k];
   }
   data[k + 1] = current;
  }
 }

 public void sortnlgnAlt(Comparable[] data) {
  heapSort(data);
 }

 public void heapSort(Comparable[] data) {
  int n = data.length - 1;
  for (int i = n / 2; i >= 0; i--) {
   maxHeap(data, n, i);
  }
  for (int i = n; i > 0; i--) {
   swap(data, 0, i);
   n--;
   maxHeap(data, n, 0);
  }
 }

 public void maxHeap(Comparable[] data, int n, int i) {
  int largest = i;
  int left = i * 2;
  int right = left + 1;
  if (left <= n && data[left].compareTo(data[largest]) > 0) {
   largest = left;
  }
  if (right <= n && data[right].compareTo(data[largest]) > 0) {
   largest = right;
  }
  if (largest != i) {
   swap(data, i, largest);
   maxHeap(data, n, largest);
  }
 }

 public void sortn2(Comparable[] data) {
  combSort(data, data.length);
 }

 public void combSort(Comparable[] data, int size) {
  int gap = size;
  boolean swapped = true;
  int i;
  while (gap > 1 || swapped) {
   if (gap > 1) {
    gap = (int)(gap / 1.3); //fastest
   }
   if (gap == 9 || gap == 10) {
    gap = 11;
   }
   i = 0;
   swapped = false;
   while (i + gap < size) {
    if (data[i].compareTo(data[i + gap]) > 0) {
     swap(data, i, i + gap);
     swapped = true;
    }
    i++;
   }
  }
 }

 public void sortn2Alt(Comparable[] data) {
  insertionSort(data, 0, data.length);
 }

 public void wildcard(Integer[] data) {
  introSort(data, 0, data.length, 2 * giveDepth(data.length));
  insertionSort(data, 0, data.length);
 }

 public void introSort(Integer[] data, int left, int right, int depth) {
  if (left + 11 >= right) {
   insertionSort(data, left, right);
  } else {
   while (right - left > 11) {
    if (depth == 0) {
     heapSort2(data, left, right);
     return;
    }
    depth--;
    Comparable pivot = median(data, left, right - 1);
    int p = partition(data, left, right, pivot); //use median quicksort
    introSort(data, p, right, depth);
    right = p;
   }
  }
 }

 public void heapSort2(Integer[] data, int left, int right) {
  int n = right - left;
  for (int i = n / 2; i >= 1; i--) {
   minHeap(data, i, n, left);
  }
  for (int i = n; i > 1; i--) {
   swap(data, left, left + i - 1);
   minHeap(data, 1, i - 1, left);
  }
 }

 public void minHeap(Integer[] data, int i, int n, int left) {
  int temp = data[left + i - 1];
  int c;
  while (i <= n / 2) {
   c = i * 2;
   if (c < n && data[left + c - 1] < (data[left + c])) {
    c++;
   }
   if (!(temp < data[left + c - 1])) {
    break;
   }
   data[left + i - 1] = data[left + c - 1];
   i = c;
  }
  data[left + i - 1] = temp;
 }

 public int giveDepth(int n) {
  return (int)(Math.floor(Math.log(n) / Math.log(2)));
 }

 public void introSort2(Integer[] data) {
  int range = data.length - 1;
  if (range < 11) {
   insertionSort(data, 0, range);
  }
  int depth = (int)(5 * Math.log(range) / Math.log(2.0)) / 3;
  if (depth == 0) {
   heapSort(data);
  }
  medianQuickSort(data, 0, range);
 }
}
