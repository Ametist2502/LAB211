/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin MSI
 */
public class Validation {

    public static Scanner input = new Scanner(System.in);
    public static String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

    public static int checkInputLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(input.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
                System.out.print("Enter your input: ");
            }
        }
    }
    
    public static String checkInputDate() throws ParseException{
        while (true) {
            try {
                String result = input.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
                } else {
                    System.err.println("Re-input");
                    System.out.print("Enter your input: ");
                }
            } catch (NumberFormatException | ParseException ex) {
                System.err.println("Re-input");
                System.out.print("Enter your input: ");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {
            String result = input.nextLine().trim();
            if (result.length() == 0) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(input.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
                System.out.print("Enter your input: ");
            }
        }
    }

    public static String checkInputTaskTypeId() {
        while (true) {
            int n = checkInputLimit(1, 4);
            String result = null;
            switch (n) {
                case 1:
                    result = "code";
                    break;
                case 2:
                    result = "test";
                    break;
                case 3:
                    result = "manager";
                    break;
                case 4:
                    result = "learn";
            }
            return result;
        }
    }

    public static String checkInputPlan() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PLAN_VALID) && Double.parseDouble(result) >= 8.0
                    && Double.parseDouble(result) <= 17.5) {
                return result;
            } else {
                System.err.println("Re-input.");
                System.out.print("Enter your input between 8.0 and 17.5(each value space 0.5): ");
            }
        }
    }
}
