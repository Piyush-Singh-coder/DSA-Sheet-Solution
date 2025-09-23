package MedianTwoSortedArrary;

import java.util.Arrays;

public class Median{
    public static double bruteForce(int nums1[], int nums2[]){
        int n1 = nums1.length; 
        int n2 = nums2.length;
        int nums3 [] = new int[n1+n2];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                nums3[k++] = nums1[i++];
            }else{
                nums3[k++] = nums2[j++];
            }
        }
        while(i<n1){
            nums3[k++] = nums1[i++];
        }
        while(j<n2){
            nums3[k++] = nums2[j++];
        }
        System.out.println(Arrays.toString(nums3));
        double median = 0;
        if (nums3.length % 2 == 0){
            median = (double)(nums3[nums3.length/2] + nums3[(nums3.length/2)-1])/2;
        }else{
            median = (double)nums3[nums3.length/2];
        }
        return median;
    }
    public static double better(int nums1[], int nums2[]){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int idx2 = (nums1.length + nums2.length)/2;
        int idx1 = idx2 -1;
        int element1 = -1;
        int element2 = -2;
        int count = 0;
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2){
            if (nums1[i] < nums2[i]){
                if(count == idx1) element1 = nums1[i];
                if(count == idx2) element2 = nums1[i];
                i++;
                count++;
            }else{
                if(count == idx1) element1 = nums2[j];
                if (count == idx2) element2 = nums2[j];
                count++;
                j++;
            }
        }
        while(i<n1){
            if(count == idx1) element1 = nums1[i];
            if (count == idx2) element2 = nums1[i];
            count++;
            i++;
        }
        while(j<n2){
            if(count == idx1) element1 = nums2[j];
            if (count == idx2) element2 = nums2[j];
            j++;
            count++;
        }
        if ((n1+n2)%2 == 0){
            return (double) (element1+element2)/2;
        }else{
            return (double) element2/2;
        }

    }
    public static double optimal(int nums1[], int nums2[]){
        int n1 = nums1.length; 
        int n2 = nums2.length; 
        if (n1>n2){
            return optimal(nums2, nums1);
        }
        int n = n1+n2;
        int left = (n1+n2+1)/2;
        int low = 0;
        int high = n1;
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? nums1[mid1-1]: Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MIN_VALUE;

            if (l1 <= r2 && l2 <= r1){
                if (n % 2 == 0){
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2)))/2;
                }else{
                    return (double) (Math.max(l1, l2));
                }
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int nums1[] = {1,3};
        int nums2[] = {2,4};
        System.out.println(optimal(nums1, nums2));
    }
}