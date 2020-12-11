package com.leetcode.easy;

/**
 * 合并两个有序数组
 *
 * 将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *解题思路1：
 *      用三指针，p个指针指向num1的结尾（最大长度下标），p1指针指向nums的最大非0值，p2指向nums2的结尾
 *      p1与p2对比值，最大值放在p上
 *         如果p1为最大值，则p1--,p--
 *         如果p2为最大值，则p2--,p--
 *      首先指针降为0的数组结束循环
 *         如果p1为0，则把nums2剩下的数放进nums1中
 *         如果p2为0，则结束
 *
 * 效率：
 *      O(M+N)   0ms      100%
 *      o(1)      38.7 MB  46.65%
 */
public class Solution88 {

    public static void main(String[] args) {

        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,3,nums2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = nums1.length - 1;
        int p1 = nums1.length - nums2.length -1;
        int p2 = nums2.length - 1;

        System.out.println("p = "+p+" p1 = "+p1 +" p2 ="+p2);

        while((p1>=0) && (p2 >=0)){

            System.out.println("循环未结束"+"p = "+p+" p1 = "+p1 +" p2 ="+p2);

            if(nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
                p--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
                p--;
            }
        }

        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
