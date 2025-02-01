package array.canPlaceFlowers;

import java.util.Arrays;

/**
 * This is simple as it annoyingly gets you just have to handle all the situations with if and else statements,
 * the edge cases would be the 1st and last index, what if there is only a single element etc.
 *
 * if you encounter a 1 just use continue and go to the next iteration
 *
 * if you want to place the pot you will check if it has pot before it and after it, if it doesn't you can place it and
 * modify the array that you have placed it, so the future placing can be made on that decision.
 *
 * But when you are at 0 index, you will be out of bounds checking for previous, so for index i=0 just check the next
 * and place depending on it, similarly if you are at the last index just check the previous index and place if it is 0
 *
 * if array is of length 1, the index i is first and last index at the same time and it also doesn't have a next or
 * previous, what can be done? if it;s 1 its skipped already check if it's 0 reduce n.
 *
 * Time Complexity is 0(n) and space complexity is also same
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] arr = {0,0,0,0,1};
        canPlaceFlowers(arr,2);
    }

    public static boolean canPlaceFlowers(int[] arr, int n) {
        int len = arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1)
                continue;
            else if(arr.length == 1){
                n--;
            }
            else if(i==0){
                if(arr[i+1] == 0){
                    arr[i+1] = 1;
                    n--;
                }
            }
            else if(i == len-1){
                if(arr[i-1]==0)
                    n--;
            }
            else{
                if(arr[i-1] == 0 && arr[i+1] == 0){
                    n--;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
        return n==0;
    }
}
