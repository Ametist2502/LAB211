package matrix;

public class Calculate {
    Validation validation = new Validation();
    
    
    public int[][] inputMatrix(int n){
        System.out.print("Enter Row Matrix: ");
        int row = validation.checkInput();
        System.out.print("Enter Colum Matrix: ");
        int col = validation.checkInput();
        int[][] matrix = new int[row][col];
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                System.out.print("Enter values: ");
                matrix[i][j] = validation.checkInput();
            }
        }
        return matrix;
    }
    
    public void displayMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
    
    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2){
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
          if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            System.out.println("Invalid size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                ansMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return ansMatrix;
    }
    
    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length
                || matrix1[0].length != matrix2[0].length) {
            System.out.println("Invalid size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                ansMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return ansMatrix;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        if (matrix1[0].length != matrix2.length) {
            System.out.println("Invalide size!");
            return null;
        }
        int[][] ansMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int temp = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    temp += matrix1[i][k] * matrix2[k][j];
                }
                ansMatrix[i][j] = temp;
            }
        }
        return ansMatrix;
    }
}
