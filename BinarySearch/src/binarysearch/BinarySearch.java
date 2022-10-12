/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin MSI
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int length = checkInput("Enter number of array: ");
        int search = checkInput("Enter search value: ");
        
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        BinarySearch searcher = new BinarySearch();
        searcher.bubbleSort(array);
        
        System.out.print("Sorted array: ");
        searcher.displayArray(array);
        
        int foundIndex = searcher.binarySearch(array, search, 0, length - 1);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
    }
    //validation input
        public static int checkInput(String msg) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.print("Input could not be empty. Please enter a positive integer number");
                continue;
            }
            try {
                size_array = Double.parseDouble(input);
                //check value of size must be a positive number
                if (size_array <= 0) {
                    throw new Exception();
                }
                //Compare float value of input with size_array catch input be a rational number
                if ((int) size_array != size_array) {
                    throw new Error();
                } else {
                    break;
                }
            } catch (NumberFormatException exception) {
                System.out.print("Input could not be a string. Please enter a positive integer number");
                continue;
            } catch (Exception NegaError) {
                System.out.print("Input could not be less than zero. Please enter a positive integer number");
                continue;
            } catch (Error RealNumError) {
                System.out.print("Input could not be a real number. Please enter a positive integer number");
                continue;
            }
        } while (true);
        return (int) size_array;
    }

    /**
     *
     * @param arr the array
     */
    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
    
    /**
     *
     * @param arr the array
     */
    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * searches for a value in sorted array
     *
     * @param array array to search in
     * @param value searched value
     * @param left index of left boundary
     * @param right index of right boundary
     * @return position of searched value, if it presents in the array or -1, if
     * it is absent
     */
    int binarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, value, left, middle - 1);
        } else {
            return binarySearch(array, value, middle + 1, right);
        }
    }
    
}
