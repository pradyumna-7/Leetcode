/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postMap = new HashMap<>();
    
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return buildTree(preorder, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int[] postorder, int left, int right) {
        if (left > right) return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
        
        if (left == right) return root;
        
        int leftChildIndex = postMap.get(preorder[preIndex]);
        
        root.left = buildTree(preorder, postorder, left, leftChildIndex);
        root.right = buildTree(preorder, postorder, leftChildIndex + 1, right - 1);
        
        return root;
    }
}
