package ContainerWithMostWater;

public class maxArea {
    public static int bruteForce(int height[]){
        int max = Integer.MIN_VALUE;
        int n = height.length;
        for(int i = 0; i<n; i++){
            for(int j= i+1; j<n ; j++){
                int width = j-i;
                int ht = Math.min(height[i], height[j]);
                int area = width * ht;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public static int optimal(int height[]){
        int n = height.length;
        int i = 0, j = n-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
            int width = j-i;
            int ht = Math.min(height[i], height[j]);
            int area = width * ht;
            max = Math.max(max, area);
            if (height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int height[] = {1,7,2,5,4,7,3,6};
        System.out.println(bruteForce(height));
        System.out.println(optimal(height));
    }
}
