package Leetcode_BinarySearch;

public class leetcode_033 {
	/**
	 * 该题和leetcode_081有相似之处
	 * 
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
	 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
	 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
	 * 你可以假设数组中不存在重复的元素。
	 * 你的算法时间复杂度必须是 O(log n) 级别。
	 * 示例 1:
	 * 输入: nums = [4,5,6,7,0,1,2], target = 0输出: 4
	 * 示例 2:
	 * 输入: nums = [4,5,6,7,0,1,2], target = 3输出: -1
	 */
	public int search(int[] nums, int target){
		if(nums.length == 0) return -1;
		int left = 0;
		int right = nums.length-1;
		while(left<right){
			int mid = left + (right-left)/2;
			if(nums[mid] == target){
				return mid;
			}
			else if(nums[left] == target){
				return left;
			}
			else if(nums[right] == target){
				return right;
			}
			else{
				if(nums[mid]>nums[left]){
					if(target>nums[mid]){
						left = mid+1;
					}
					else{
						if(target>nums[left]){
							right = mid-1;
						}
						else{
							left = mid+1;
						}
					}
				}
				else if(nums[mid]<nums[left]){
					if(target<nums[mid]){
						right = mid-1;
					}
					else{
						if(target<nums[right]){
							left = mid+1;
						}
						else{
							right = mid-1;
						}
					}
				}
				else{
					left++;//right--;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		leetcode_033 l033 = new leetcode_033();
		int nums[] = {4,5,6,7,0,1,2};
		int target = 3;
		System.out.println("The index of "+target+" is "+l033.search(nums, target));
	}

}
