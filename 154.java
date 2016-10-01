public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length-1, middle = (left+right)/2, min = nums[0];
        while(left < right-1){
            if(nums[left] < nums[middle]){
                min = Math.min(nums[left], min);
                left = middle;
                middle = (left+right)/2;
            }
            else if(nums[left] > nums[middle]){
                min = Math.min(nums[middle], min);
                right = middle;
                middle = (left+right)/2;
            }
            else if(nums[left] == nums[middle]){
                int[] leftArray = Arrays.copyOfRange(nums, left, middle); // subarray(array, startIndex, endIndexexcluded);
                int[] rightArray = Arrays.copyOfRange(nums, middle, right+1);
                int leftMin = findMin(leftArray);
                int rightMin = findMin(rightArray);
                min = Math.min(min, leftMin);
                min = Math.min(min, rightMin);
                return min;
            }
        }
        min = Math.min(min, nums[left]);
        min = Math.min(min, nums[right]);
        return min;
    }
}

//nice version
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length-1, middle = (left+right)/2, min = nums[0];
        while(left < right-1){
            if(nums[left] < nums[middle]){
                min = Math.min(nums[left], min);
                left = middle;
                middle = (left+right)/2;
            }
            else if(nums[left] > nums[middle]){
                min = Math.min(nums[middle], min);
                right = middle;
                middle = (left+right)/2;
            }
            else {
                left++;
                middle = (left+right)/2;
            }
        }
        min = Math.min(min, nums[left]);
        min = Math.min(min, nums[right]);
        return min;
    }
}