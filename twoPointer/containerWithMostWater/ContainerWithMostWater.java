package twoPointer.containerWithMostWater;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int maxArea = 0;
        while(l < r){

            maxArea = Math.max( Math.min(height[l] , height[r]) * (r - l),maxArea);

            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }

        return maxArea;

    }
}
