/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
https://leetcode.com/problems/palindrome-number/
*/
class Solution {
    public boolean isPalindrome(int x) {
        // 모든 0보다 작은 숫자는 false
        // string 변환 X
        
        if(x < 0){
            return false;
        }
        
        if(x == 0){
            return true;
        }
        
        int log10 = (int)Math.log10(x);
        int a = x;
        int b = 0;
        //System.out.println(x + ", " + log10);
        
        for(int i = 1; i <= log10 + 1; i++){
            b = b * 10 + (a %  10);
            a = (a / 10);   
            //System.out.println(a + "," + b);
        }
        
        return x == b;
    }
}