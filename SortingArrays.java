/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sortingarrays;

import java.util.Arrays;

/**
 *
 * @author amanp
 */
public class SortingArrays {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] toSelectionSort = {2, 6, 3, 4, 8, 9, 4, 1, 6, 3, 4, 9, 5, 7, 2};
        int[] toInsertionSort = {2, 6, 3, 4, 8, 9, 4, 1, 6, 3, 4, 9, 5, 7, 2};
        int[] toShellSort = {2, 6, 3, 4, 8, 9, 4, 1, 6, 3, 4, 9, 5, 7, 2};
               
        
        int SIZE = 12;
        
        System.out.println("<<Selection Sort>>");
        System.out.println("Original: " + Arrays.toString(toSelectionSort));
        System.out.println("Final: " + Arrays.toString(SelectionSort(toSelectionSort, SIZE)));        
        System.out.println("");
        
        System.out.println("<<Insertion Sort>>");
        System.out.println("Original: " + Arrays.toString(toInsertionSort));
        System.out.println("Final: " + Arrays.toString(InsertionSort(toInsertionSort, SIZE)));
        System.out.println("");
        
        
        
        System.out.println("<<Shell Sort>>");
        System.out.println("Original: " + Arrays.toString(toShellSort));
        System.out.println("Final: " + Arrays.toString(ShellSort(toShellSort, SIZE)));
        System.out.println("");
        
        
        
        
    }
////////////////////////////////////////////////////////////////////////////
///////////             Selection Sort Start
////////////////////////////////////////////////////////////////////////////    
public static int[] SelectionSort(int[] arr, int size){
    for (int pos = 0; pos < size - 1; pos++) {
        int indexOfNextSmallest = getIndexOfSmallest(arr, pos, size - 1);
        swap(arr, pos, indexOfNextSmallest);
        System.out.println(Arrays.toString(arr));

    } 
    return arr;
 }


public static int getIndexOfSmallest(int[] arr, int f, int l) {
    int min = arr[f];
    int indexMin = f;
    for (int pos = f + 1; pos <= l; pos++) {
        if (arr[pos]< min) {
            min = arr[pos];
            indexMin = pos;
        } 
    }
 return indexMin;
 }

 
 public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
 }   
////////////////////////////////////////////////////////////////////////////
///////////             Selection Sort End
////////////////////////////////////////////////////////////////////////////    


////////////////////////////////////////////////////////////////////////////
///////////             Insertion Sort Start
////////////////////////////////////////////////////////////////////////////    

public static int[] InsertionSort(int[] arr, int size) {
    insertionSort(arr, 0, size - 1);
    return arr;
} // end insertionSort

 public static int[] insertionSort(int[] arr, int f, int l) {
    for (int unsorted = f + 1; unsorted <= l; unsorted++) {
        // Assertion: a[first] <= a[first + 1] <= ... <= a[unsorted - 1]
        int firstUnsorted = arr[unsorted];

        insertInOrder(firstUnsorted, arr, f, unsorted - 1);
        System.out.println(Arrays.toString(arr));
    }
    return arr;
 }

 private static  void insertInOrder(int anEntry, int[] arr, int start, int end) {
    int pos = end;

    while ((pos >= start) && (anEntry < (arr[pos]))) {
        arr[pos + 1] = arr[pos]; 
        pos--;
    }

    
    arr[pos + 1] = anEntry; 
    } 
 

////////////////////////////////////////////////////////////////////////////
///////////             Insertion Sort End
////////////////////////////////////////////////////////////////////////////    


////////////////////////////////////////////////////////////////////////////
///////////             Shell Sort Start
////////////////////////////////////////////////////////////////////////////    

public static int[] ShellSort(int[] arr, int size) {
    shellSort(arr, 0, size - 1);

    return arr;
} // end shellSort

public static int[] shellSort(int[] arr, int f, int l) {
    int n = l - f + 1; // Number of array entries
    int space = n / 2;
    while (space > 0) {
        for (int start = f; start < f + space; start++) {
            incrementalInsertionSort(arr, start, l, space);
        }
    space = space / 2;
    System.out.println(Arrays.toString(arr));
    }
    return arr;
 }

private static int[] incrementalInsertionSort(int[] arr, int f, int l, int space) {
    int unsorted, index;

    for (unsorted = f + space; unsorted <= l; unsorted = unsorted + space) {
        int nextToInsert = arr[unsorted];
        index = unsorted - space;
        while ((index >= f) && (nextToInsert < arr[index])) {
            arr[index + space] = arr[index];
            index = index - space;
        }
        arr[index + space] = nextToInsert;
    }
    return arr;
}
 
 

////////////////////////////////////////////////////////////////////////////
///////////             Shell Sort End
////////////////////////////////////////////////////////////////////////////     
 
    
}
