package binarySearchTree.searchInBinarySearchTree;
/**
 * Definition for a binary tree node.
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }


}

//Ab hoga Push

/**
 * This is an recursive approach for the solution, its simple we check if the current node has the value we are looking for if yes then return that node , or else depending on the property of Binary search tree we observe if target is smaller than current node's value then we need to move to left side of the tree and perform the same checks. Thus we recall the same function with the left node as the root node, if the match is found then fine else conditions are checked if the target is greater then it will trace the right side of tree till it reaches. if result is not found then it is clear that the result does not exist, we can return null or the current node's value. 
 */
public class Solution{

	public TreeNode searchBST(TreeNode root, int val) {
        if(root != null){
            if(root.val == val){
                return root;
            }else if(val < root.val ){
                return searchBST(root.left,val);
            }else{
                return searchBST(root.right,val);
            }
        }
        return root;
    }

	
}