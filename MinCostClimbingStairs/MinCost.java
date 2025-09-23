package MinCostClimbingStairs;

public class MinCost {
    public static int minCost(int cost[]){
        return Math.min(recursion(cost, 0), recursion(cost, 1));
    }
    public static int recursion(int cost[], int i){
        if (i >= cost.length){
            return 0;
        }
        return cost[i]  + Math.min(recursion(cost, i+1), recursion(cost, i+2));
    }
    public static void main (String[] args){
        int cost [] = {1,2,3};
        System.out.println(minCost(cost));
    }
}
