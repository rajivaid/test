package com.algo2014.bst;
public class CountTree {

	public static int countTrees(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			// there will be one value at the root, with whatever remains
			// on the left and right each forming their own subtrees.
			// Iterate through all the values that could be the root...
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= numKeys; root++) {
				left = countTrees(root - 1);
				right = countTrees(numKeys - root);
				// number of possible trees with this root == left*right
				sum += left * right;
			}
			return (sum);
		}
	}
	
	public static void main(String[] args) {

		System.out.println(countTrees(9));
	}
}
