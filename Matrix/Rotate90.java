package Matrices;

public class Rotate90 {
    public static void main(String[] args) {
        int N = 3;
        int mat[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        display(mat);
        rotateMat90(mat, N);
    }
    static void display(int[][] mat){
        for (int i=0;i<mat.length;i++){
            for (int j = 0; j<mat[i].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.print('\n');
        }
    }

    static void rotateMat90(int matrix[][], int n){
       for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
                System.out.println("\t\t Swapped: " + matrix[i][j] + " vs" + matrix[j][i]);
            }
            System.out.println("Round-"+i);
            display(matrix);
        }
        for(int i=0;i<n;i++){
            int top=0;
            int bottom = n-1;
            while(top<bottom){
                int temp = matrix[top][i];
                matrix[top][i]=matrix[bottom][i];
                matrix[bottom][i] = temp;
                top++;
                bottom--;
            }
            System.out.println("SubChange");
            display(matrix);
        }
        System.out.println("Final");
        display(matrix);

    }
}

