package Leetcode_Dynamic;

import java.util.Arrays;

/*
 * 零钱兑换
 * 
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
	示例 1:
	输入: coins = [1, 2, 5], amount = 11
	输出: 3 
	解释: 11 = 5 + 5 + 1
	示例 2:
	输入: coins = [2], amount = 3
	输出: -1
 */

/**
 * 
 * 
	比较典型的动态规划问题。
	
	假设 f(n) 代表要凑齐金额为 n 所要用的最少硬币数量，那么有：
	
	f(n) = min(f(n - c1), f(n - c2), ... f(n - cn)) + 1
	其中 c1 ~ cn 为硬币的所有面额。
	
	再具体解释一下这个公式吧，例如这个示例：
	
	输入: coins = [1, 2, 5], amount = 11
	输出: 3 
	解释: 11 = 5 + 5 + 1
	题目求的值为 f(11)，第一次选择硬币时我们有三种选择。
	
	假设我们取面额为 1 的硬币，那么接下来需要凑齐的总金额变为 11 - 1 = 10，
	即 f(11) = f(10) + 1，这里的 +1 就是我们取出的面额为 1 的硬币。
	
	同理，如果取面额为 2 或面额为 5 的硬币可以得到：
	
	f(11) = f(9) + 1
	f(11) = f(6) + 1
	所以：
	
	f(11) = min(f(10), f(9), f(6)) + 1
 */


public class leetcode_322 {
	//动态规划
	public static int coinChange(int[] coins, int amount){
		int[] memo = new int[amount+1];
		Arrays.fill(memo, amount+1);
		for(int i=1; i<=amount; i++){
			for(int coin: coins){
				if(i-coin>=0){
					memo[i] = Math.min(memo[i], memo[i-coin]+1);
				}
			}
		}
		return memo[amount] == amount+1? -1:memo[amount];
	}

	public static int coinChange1(int[] coins, int amount){
		int[] dp = new int[amount+1];
		dp[0] = 0;
		for(int i=1; i<amount+1; i++){
			dp[i] = amount+1;
		}
		for(int i=1; i<amount+1; i++){
			for(int j=0; j<coins.length; j++){
				if(i-coins[j]>=0){
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		if(dp[amount] == amount+1){
			return -1;
		}
		return dp[amount];
	}
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 11;
		System.out.println("The solution: "+coinChange1(coins, amount));
	}

}
