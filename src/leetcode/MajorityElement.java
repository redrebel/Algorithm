//https://leetcode.com/problems/majority-element/
class Solution {
    public int majorityElement(int[] nums) {
        
        int len = nums.length;
        if(len < 2){
            return nums[0];
        }
        
        int limit = len / 2;
        
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i = 0 ; i < len; i++){
            int value = nums[i];
            if(m.get(value) == null ){
                m.put(value, 1);
            }else if(m.get(value) + 1 > limit){
                return value;
            } else {
                m.put(value, m.get(value) + 1);    
            }
        }
        return -1;
    }
}