/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expenses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin MSI
 */
public class Validation {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public int checkInputLimit(int min, int max) throws IOException {
        while (true) {
            try {
                int n = Integer.parseInt(input.readLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public static String checkInputString() throws IOException {
        String x;
        while (true) {
            x = input.readLine();
            if (x.isEmpty() || x.matches("\\s")) {
                System.out.print("Input again: ");
                x = input.readLine();
            } else {
                break;
            }
        }

        return x;
    }
    
    public static String checkInputDate() throws IOException {
       String date = "";
        Date d1 = null;
        Date d = new Date();
        while (true) {
            try {
                date = Validation.checkInputString();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
                df.setLenient(false);
                d1 = df.parse(date);
                if (d1.after(d)) {
                    System.out.println("qiweiqe");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Error! Input must follow dd-MM-yyyy");
            }
        }
        return date;
    }

    public double checkInputDouble() throws IOException{
        while(true){
            try{
                double result = Double.parseDouble(input.readLine());
                return result;
            }catch(NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
    
    public int checkInputInt() throws IOException{
        while(true){
            try{
                int result = Integer.parseInt(input.readLine());
                return result;
            }catch(NumberFormatException ex){
                System.out.println("Re-input");
            }
        }
    }
}
