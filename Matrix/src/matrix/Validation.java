package matrix;

import java.util.Scanner;

public class Validation {
    Scanner sc = new Scanner(System.in);
    
    public int checkIntLimit(int min, int max) {
        while(true){
            try{
                int n = Integer.parseInt(sc.nextLine());
                if(n<min || n>max){
                    throw new NumberFormatException();
                }
                return n;
            }catch(NumberFormatException ex){
                System.err.println("Re-input");
            }
        }
    }
    
    public int checkInput() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }
}
