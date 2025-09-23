package SearchInMatrix;

public class SearchInMatrix {
    
    // Binary Search 
    public static boolean binarySearch(int arr[], int target){
        int low = 0;
        int high = arr.length;
        while(low <= high){
            int mid = (low+high)/2;
            if (arr[mid]  == target){
                return true;
            }else if (arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }

    // Brute Force
    public static boolean bruteForce(int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for (int j = 0; j<m; j++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    // Better Approach
    public static boolean better(int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            if (target >= matrix[i][0] && target <= matrix[i][m-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    //Optimal Approach
    public static boolean optimal (int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0; 
        int high = n*m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int rows = mid/m;
            int cols = mid/m;
            if (matrix[rows][cols] == target){
                return true;
            }else if(matrix[rows][cols] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,4},
                          {6,7,8},
                          {9,10,34}};
        System.out.println(optimal(matrix, 7));
    }
}
