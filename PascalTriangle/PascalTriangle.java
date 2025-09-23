package PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle{
    public static int nCr(int rows, int cols){
        rows = rows-1;
        cols = cols-1;
        int result = 1;
        for (int i = 0; i<cols; i++){
            result *= rows-i;
            result /= i+1;
        }
        return result;
    }
    public static void generate(int rows){
        for (int i = 1; i<= rows; i++){
            System.out.print(nCr(rows, i)+ " ");
        }
    }
    public static void generate2(int rows){
        int result = 1;
        System.out.print(result + " ");
        for (int i = 1; i<rows; i++){
            result *= rows - i;
            result /= i;
            System.out.print(result + " ");
        }
    }
    public static void generateAll(int rows){
        for (int i=1; i<=rows; i++){
            generate2(i);
            System.out.println();
        }
    }

    // Real Section
    // To get n row element and r column element - formula is (n-1 C r-1)
    public static List<Integer> generateRows(int rows){
        List<Integer> ans = new ArrayList<>();
        int result = 1;
        ans.add(result);
        for (int i = 1; i<rows;i++){
            result *= rows-i;
            result /= i;
            ans.add(result);
        }
        return ans;
    }
    public static List<List<Integer>> pascalTriangle(int rows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=rows; i++){
            ans.add(generateRows(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        int rows = 5, cols = 2;
        System.out.println(nCr(rows,cols));
        generateAll(rows);
        System.out.println(generateRows(rows));
        System.out.println(pascalTriangle(rows));
    }
}