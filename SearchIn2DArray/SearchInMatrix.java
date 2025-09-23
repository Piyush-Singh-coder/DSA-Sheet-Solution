package SearchIn2DArray;

public class SearchInMatrix {
    public static int binarySearch(int arr[], int target){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high) /2;
            if (arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    public static boolean better(int matrix[][], int target){
        int i = 0;
        int index = -1;
        while (index == -1 && i < matrix.length){
            index = binarySearch(matrix[i], target);
            i++;
        }
        if (index != -1){
            System.out.println("["+(i-1)+"," +index+"]");
            return true;
        }else{
            return false;
        }
    }
    public static boolean optimal(int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0; 
        int high = n*m-1;
        while(low <= high){
            int mid = (low+high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target){
                System.out.println(row +"," +col);
                return true;
            }else if(matrix[row][col] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        System.out.println(low +"" +high);
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};  
        System.out.println(optimal(matrix, 10)); 
    }
}
