public class Solution {
    public int maxProduct(int[] nums) {
        int max = 0; 
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            max = Math.max(nums[0], nums[1]);
            max = Math.max(max, nums[0]*nums[1]);
            return max;
        }
        else{
            for(int i = 0; i<nums.length; i++){
                int local_max = nums[i];
                int prod = nums[i];
                for(int j = i+1; j<nums.length; j++){
                    prod *= nums[j];
                    local_max = Math.max(local_max, prod);
                }
                max = Math.max(max, local_max);
            }
            return max;
        }
    }
}

//nice version
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else{
            int max_global = nums[0];
            int max_local = nums[0];
            int min_local = nums[0];
            for(int i = 1; i<nums.length; i++){
                int temp_max_local = max_local;
                max_local = Math.max(Math.max(nums[i], max_local*nums[i]), min_local*nums[i]);
                min_local = Math.min(Math.min(nums[i], temp_max_local*nums[i]), min_local*nums[i]);
                max_global = Math.max(max_global, max_local);
            }
            return max_global;
        }
    }
}