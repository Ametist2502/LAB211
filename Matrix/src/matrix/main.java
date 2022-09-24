package matrix;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Validation validation = new Validation();
        Calculate calculate = new Calculate();
        
        int[][] matrix1 = calculate.inputMatrix(1);
        int[][] matrix2 = calculate.inputMatrix(2);
        while (true) {
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = validation.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    calculate.additionMatrix(matrix1, matrix2);
                    break;
                case 2:
                    calculate.subtractionMatrix(matrix1, matrix2);
                    break;
                case 3:
                    calculate.multiplicationMatrix(matrix1, matrix2);
                    break;
                case 4:
                    return;
            }
        }
    }
}
