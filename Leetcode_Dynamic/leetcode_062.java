package Leetcode_Dynamic;

/*
 * 不同路径
 * 
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	问总共有多少条不同的路径？
	说明：m 和 n 的值均不超过 100。
	示例 1:
	输入: m = 3, n = 2
	输出: 3
	解释:
	从左上角开始，总共有 3 条路径可以到达右下角。
	1. 向右 -> 向右 -> 向下
	2. 向右 -> 向下 -> 向右
	3. 向下 -> 向右 -> 向右
	示例 2:
	输入: m = 7, n = 3
	输出: 28
 */
public class leetcode_062 {
	
	//方法一：机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走不就行了吗？即C（（m+n-2），（m-1））。
	
	//方法二：使用组合数就失去该题目的意义了。第二种方法使用动态规划的方法
	public static int uniquePaths(int m, int n){
		int[][] dp = new int[m][n];
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(i == 0 || j == 0){
					dp[i][j] = 1;
				}
				else{
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}
	public static void main(String[] args) {
		int m = 7;
		int n = 3;
		System.out.println("m: "+m+" n:"+n);
		System.out.println("The uniquePath are: "+uniquePaths(m, n));
	}

}
