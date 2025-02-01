package array.canPlaceFlowers;

/**
 * It's literally the same as the Solution2, but we are returning as soon as the count matches the n
 */
public class Solution3 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0;i<flowerbed.length;i++){

            if(flowerbed[i] == 0){
                boolean isLeftEmpty =  (i == 0) || flowerbed[i-1] == 0 ;
                boolean isRightEmpty = (i == flowerbed.length-1) || flowerbed[i+1] == 0;

                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i] = 1;
                    count++;
                    if(count == n){
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }
}
