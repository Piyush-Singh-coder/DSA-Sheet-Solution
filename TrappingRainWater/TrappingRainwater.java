package TrappingRainWater;

public class TrappingRainwater {
    public static int better(int height[]){
        int n = height.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = height[0];
        for(int i = 1; i<n; i++){
            prefix[i] = Math.max(height[i],prefix[i-1]);
        }
        suffix[n-1] = height [n-1];
        for(int i = n-2; i>=0; i--){
            suffix[i] = Math.max(height[i], suffix[i+1]);
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return ans;
    }

    public static int optimal(int height[]){
        int l = 0; 
        int r = height.length-1;
        int ans = 0;
        int lmax = 0;
        int rmax = 0;
        while(l<r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);
            if (lmax < rmax){
                ans += lmax - height[l];
                l++; 
            }
            else{
                ans+= rmax - height[r];
                r--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int height[] = {0,2,0,3,1,0,1,3,2,1};
        System.out.println(better(height));
        System.out.println(optimal(height));

    }
}
