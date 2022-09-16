/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin MSI
 */
public class bubbleSortAlgorithm {
   public static void main(String[] args) {
       
        int size_array = InputPositiveNumber("Enter number of array:");
        int[] array = CreateArray(size_array);
        Display(array, "Unsorted array: ");
        bubbleSort(array);
        Display(array, "Sorted array: ");
    }

    private static int InputPositiveNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double size_array;
        String input;
        do {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty. Please enter a positive integer number");
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
                System.out.println("Input could not be a string. Please enter a positive integer number");
            } catch (Exception NegaError) {
                System.out.println("Input could not be less than zero. Please enter a positive integer number");
            } catch (Error RealNumError) {
                System.out.println("Input could not be a real number. Please enter a positive integer number");
            }
        } while (true);
        return (int) size_array;
    }

    private static int[] CreateArray(int size_array) {
        int[] array = new int[size_array];
        Random rd = new Random();
        int max=100, min=-100;
        //Loop use to random each element of array
        for (int i = 0; i < size_array; i++) {
            array[i] = rd.nextInt(100) - 50;
        }
        return array;
    }

    private static void Display(int[] array, String msg) {
        System.out.print(msg);
        System.out.print("[");
        //Loop use to accessed each element of array and display
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //Check index to Display comma
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        if(msg.equals("Unsorted array: ")){
            System.out.println("]");
        }else{
            System.out.println("]");
        }
    }

    public static void bubbleSort(int[] array){
       for(int i = 0; i< array.length; i++){
           for(int j=0; j< array.length-i-1; j++){
               if(array[j+1]<array[j]){                 
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;                  
                }
            }
        }
    }
}
