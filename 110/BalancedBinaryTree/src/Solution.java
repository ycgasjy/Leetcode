
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
};

public class Solution {
	public int depth(TreeNode root){
		if(root==null)
			return 0;
		else 
			return 1+Math.max(depth(root.left), depth(root.right));
		
	}
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        	return true;
        else return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left)-depth(root.right)))<=1;
    }
    public static void main(String[] args){
    	int i=0;
    	int size=100;
    	Solution sol=new Solution();
    	TreeNode[] BST=new TreeNode[100];
    	BST[0]=new TreeNode(0);
    	for(i=1;i<size;i++){
    		BST[i]=new TreeNode(i);
    		BST[i].left=null;
    		BST[i].val=i;
    		BST[i-1].right=BST[i];
    	}
    	System.out.println(sol.isBalanced(BST[0]));
    }
}