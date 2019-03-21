package store.leetcode;

import java.util.Arrays;

public class Solution {
	// 3671
	// [[518,518],[71,971],[121,862],[967,607],[138,754],[513,337],[499,873],[337,387],[647,917],[76,417]]
	public static void main(String[] args) {
		 
//		int costs[][]=new int[][] {{10,20},{30,200},{400,50},{30,20}};
		int costs[][]=new int[][]{{518,518},{71,971},{121,862},{967,607},{138,754}, {513,337}, {499,873}, {337,387}, {647,917}, {76,417}};
		System.out.println(twoCitySchedCost(costs));
	}

	/**
	 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
	 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
	 * @param costs
	 * @return
	 */
	public static int twoCitySchedCost(int[][] costs) {
		int len = costs.length;
		int num_a = 0;
		int num_b = 0;
		int totalCost = 0;
        int temp[] = new int[len];
        for (int i = 0; i < len; i++) {
        	temp[i] = Math.abs(costs[i][0] - costs[i][1]);
        	if(costs[i][0] <= costs[i][1]) {
        		num_a++;
    			totalCost += costs[i][0];
    			System.out.println("costs[i][0]" + costs[i][0] + "   - 差值：" + temp[i]);
        	} else {
        		num_b++;
        		totalCost += costs[i][1];
        		System.out.println("costs[i][1]" + costs[i][1] + "   - 差值：" + temp[i]);
        	}
        }
        System.out.println("不计两地人数时最理想情况totalCost=" + totalCost);
        Arrays.sort(temp);
        int t = 0;
        if (num_a >= num_b) {
        	t = num_a - (len / 2);
        } else {
        	t = num_b - (len / 2);
        }
        
        for (int i = 0; i < t; i++) {
        	totalCost += temp[i];
		}
        return totalCost;
    }
	
	
}
