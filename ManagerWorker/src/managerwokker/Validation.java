/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerwokker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Validation {
    Scanner sc = new Scanner(System.in);
    
 
    public int inputInt(String msg, int min, int max) {
        System.out.print(msg);
        while(true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + " and " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
    
    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number: ");
            }
        }
    }
    
    public String inputString(String mess) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            if (input.trim().equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    
    //get valid date
//    public String inputDate(String mess) {
//        System.out.print(mess);
//        //set format of date
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        dateFormat.setLenient(false);
//        //force user input exectly a date
//        while(true) {
//            String input = sc.nextLine();
//            try {
//                Date date = dateFormat.parse(input);
//                //get current date
//                Date curDate = Calendar.getInstance().getTime();
//                //check range of date
//                if (curDate.compareTo(date) < 0) {
//                    System.out.print("Please input date that before current date: ");
//                    continue;
//                }
//                dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
//                return dateFormat.format(date);
//            } catch (Exception e) {
//                System.out.print("Please input valid date (dd-MM-yyyy): ");
//            }
//        }
//    }
}
