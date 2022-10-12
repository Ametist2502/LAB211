/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin MSI
 */
public class LinearSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = checkInput("Enter number of array: ");
//        scanner.nextLine();
        int search = checkInput("Enter search value: ");

        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(length);
        }
        LinearSearch searcher = new LinearSearch();
        System.out.print("The array: ");
        searcher.displayArray(array);

        int foundIndex = searcher.linerSearch(array, search);
        System.out.println("\nFound " + search + " at index: " + foundIndex);
//        searcher.linerSearch(array, search);
    }

    public void displayArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int linerSearch(int[] arr, int key) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int checkInput(String msg) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println(msg);
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
}
