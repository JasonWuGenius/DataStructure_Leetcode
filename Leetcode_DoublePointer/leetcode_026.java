package Leetcode_DoublePointer;

public class leetcode_026 {
	/*
	 * 删除排序数组中重复项
	 * 
	 *  给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
		不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
		示例 1:
		给定数组 nums = [1,1,2], 
		函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
		你不需要考虑数组中超出新长度后面的元素。
		示例 2:
		给定 nums = [0,0,1,1,1,2,2,3,3,4],
		函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
		你不需要考虑数组中超出新长度后面的元素。
	 */	
	public static int removeDuplicates(int[] nums){
		if(nums == null){
			return 0;
		}
		int i=0, j=0;
		while(j<nums.length){
			if(nums[i] != nums[j]){
				nums[++i] = nums[j];
			}
			j++;
		}
		return i+1;
	}
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
//		int[] nums = {1,1,2};
		System.out.println("The List:");
		for(int item:nums){
			System.out.print(item+" ");
		}
		System.out.println("\nThe Length of the Changed List: "+removeDuplicates(nums));
	}

}
