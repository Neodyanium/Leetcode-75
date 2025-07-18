package hashmap.equalRowAndColumnPair;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[][] arr ={{3,2,1},{1,7,6},{2,7,7}};
        int r = equalPairs2(arr);
        System.out.println(r);
    }

    /**
     * Simple brute force, for each row, check each columns all the elements should match
     */
    public static int equalPairs(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                boolean flag = true;
                for(int k=0;k<grid.length;k++) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    count++;
            }

        }
        return count;
    }

    /**
     * Here we are using HashMap, we can't have array as key, so we make String as the key and kept its count
     *
     * we iterate over each column this time and check if this key exist already we get its value and add it to our
     * count, return the count at the end.
     */
    public static int equalPairs2(int[][] grid) {
        int count = 0, n = grid.length;
        HashMap<String,Integer> rowMap = new HashMap<>();
        for(int[] row:grid){
            String s = Arrays.toString(row);
            rowMap.put(s,rowMap.getOrDefault(s,0)+1);
        }

        System.out.println(rowMap);

        for(int c=0;c<n;c++){
            int[] col = new int[n];
            for(int r=0;r<n;r++){
                col[r] = grid[r][c];
            }

            count += rowMap.getOrDefault(Arrays.toString(col),0);
        }

        return count;
    }
}
