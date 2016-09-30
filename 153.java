public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){ // dont forget this; 
            return nums[0];
        }
        else{
            for(int i = 0; i < nums.length-1; i++){
                if(nums[i] > nums[i+1]){
                    return nums[i+1];
                }
            }
            return nums[0];
        }
    }
}


// nice version 
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){ // null small case
            return 0;
        }
        int left = 0, right = nums.length-1, middle = (left + right)/2, min = nums[0]; //right initial to length-1;
        while(left < right-1){
            if(nums[left] < nums[middle]){
                min = Math.min(nums[left], min);
                left = middle; 
                middle = (left + right)/2;
            }
            else if(nums[left] > nums[middle]){
            min = Math.min(nums[middle], min); // compare middle and min; 
            right = middle;
            middle = (left + right)/2;
            }
        }
        min = Math.min(nums[left], min);
        min = Math.min(nums[right], min);
        return min;
    }
}