package array.kidsWithGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int n:candies){
            max = Math.max(n,max);
        }
        List<Boolean> list = new ArrayList<>();
        for(int n:candies){
            if((n + extraCandies) >= max)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}
