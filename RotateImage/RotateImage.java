package RotateImage;

public class RotateImage {
    // Print the matrix
    public static void traverse(int matrix[][]){
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    // BruteForce Approach
    public static void bruteForce(int matrix[][]){
        int ans[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length;j++){
                ans[i][j] = matrix[2-j][i];
            }
        }
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length;j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
    // Optimal Approach 
    // First convert matrix into transpose matrix then reverse each row
    public static void optimal(int matrix[][]){
        for (int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse matrix
        for(int i = 0; i<matrix.length; i++){
                reverse(matrix[i]);
        }
    }
    public static void reverse(int arr[]){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        bruteForce(matrix);
        optimal(matrix);
        traverse(matrix);
    }
}


