package array.canPlaceFlowers;

/**
 * It is similar approach as Solution1 (its actually lot better) we are just modifying the way we write it shortens
 * the code.
 * We keep a count variable which will store the amount of times we can place 1, at the end if it exceeds n we return
 * true
 */
public class Solution2 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0;i<flowerbed.length;i++){

            if(flowerbed[i] == 0){
                boolean isLeftEmpty =  (i == 0) || flowerbed[i-1] == 0 ;
                boolean isRightEmpty = (i == flowerbed.length-1) || flowerbed[i+1] == 0;

                if(isLeftEmpty && isRightEmpty){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
