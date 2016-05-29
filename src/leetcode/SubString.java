package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubString {
	public static class Solution {
	    public int lengthOfLongestSubstring(String s) {
	    	Integer maxLength[] = new Integer[s.length()+1];
	        int i = 0;
	        maxLength[0] = 0;
	        i++;
	        Set<Character> st = new HashSet<>();
	        char str[] = s.toCharArray();
	    	for(char c :str){
	    		if(!st.contains(c)){
	    			maxLength[i] = maxLength[i-1] + 1;
	    			st.add(c);
	    		}else{
	    			st.clear();
	    			maxLength[i] = 1;
	    			st.add(c);

	    			for(int j = i-2; j >=0 ; j--){
	    				if(str[j]==c){
	    					break;
	    				}
		    			maxLength[i]++;
		    			st.add(str[j]);
	    			}
	    		}
	    		i++;
	    	}
	    	return Collections.max(Arrays.asList(maxLength));
	    }
	}
	
	public static void main(String[] args) {
		String s= "dvdf";
		System.out.println(new Solution().lengthOfLongestSubstring(s));
	}

}
