package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

public static class Solution{
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> indexSum = new HashMap<>();
        
        for(int i=0; i < nums.length ; i++){        
        	indexSum.put(nums[i],i);
        }
        
        for(int i=0; i < nums.length ; i++){
        	Integer j=indexSum.get(target-nums[i]);
        	if(j!=null && j>i){
        		return new int[]{i+1,j+1};
        	}
        }
        return new int[]{};
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode l3 = null;
    	ListNode head  = null;
    	int carry = 0;
    	while (l1!=null || l2!=null){
    		int val1 = l1 != null ? l1.val : 0;
    		int val2 = l2 != null ? l2.val : 0;
    		
    		int sum = val1 + val2 + carry;
    		if(l3==null){
    			l3 = new ListNode(sum%10);
    			head = l3;
    		}else{
    			l3.next = new ListNode(sum%10);
    			l3 = l3.next;
    		}
    		carry =sum/10;
    		l1=l1.next;
    		l2=l2.next;
    	}
    	if(carry!=0){
    		l3.next = new ListNode(carry);
    	}
    	
    	//reverse
    	ListNode l4 = head.next;
    	
    	while(l4!=null){
    		ListNode tmp=l4.next;
    		l4.next=head;
    		head = head.next;
    		l4 = tmp;	
    	}
    	return head;
        
    }
}

 public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
 public static void main(String[] args) {
	
	 ListNode l1 = new ListNode(5);
	 ListNode l2 = new ListNode(6);

	 Solution s = new Solution();
	 s.addTwoNumbers(l1, l2);
	 
}

}