package Leetcode_Tree;

/*
	不同的二叉搜索树

	给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

	示例:

	输入: 3
	输出: 5
	解释:
	给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

	   1         3     3      2      1
		\       /     /      / \      \
		 3     2     1      1   3      2
		/     /       \                 \
	   2     1         2                 3
*/

/*
结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)

*/
class Solution {
    public int numTrees(int n) {
        if(n <= 1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=i; j++){
                count += dp[j-1]*dp[i-j];
            }
            dp[i] = count;
        }
        return dp[n];
    }
}