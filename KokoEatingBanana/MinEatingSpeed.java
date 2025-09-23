package KokoEatingBanana;

public class MinEatingSpeed {
    public static int bruteForce(int piles[], int hours){
        int speed = 1;
        while(true){
            int ans = 0;
            for(int pile: piles){
                ans += (int) Math.ceil((double)pile/speed);
            }
            if (ans <= hours){
                return speed;
            }
            speed++;
        }
    }

    public static int optimal(int piles[], int hours){
        int max = 0;
        for(int i = 0; i<piles.length; i++){
            if (max < piles[i]){
                max = piles[i];
            }
        }
        int low = 1;
        int high = max;
        int ans = high;
        while(low <= high){
            int speed = (low+high)/2;
            int time = 0;
            for(int pile : piles){
                time += (int) Math.ceil((double)pile/speed);
            }
            if (time <= hours){
                ans = speed;
                high = speed-1;
            }else{
                low = speed+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int piles[] ={1,4,3,2};
        int hours = 9;
        System.out.println((bruteForce(piles, hours)));
        System.out.println(optimal(piles, hours));
    }
}
