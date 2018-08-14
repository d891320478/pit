package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.List;

import com.htdong.leetcode.domain.Node;

/**
 *
 * @author htdong
 * @date 2018年4月8日 下午2:35:54
 */

public class Solution {
    private int[] heap;
    private int lh;
    private int la;

    private void addHeap(int v, int i) {
        if (i <= lh) {
            heap[i] = v;
            while (i / 2 >= 1) {
                if (heap[i] < heap[i / 2]) {
                    int tmp = heap[i];
                    heap[i] = heap[i / 2];
                    heap[i / 2] = tmp;
                    i /= 2;
                } else {
                    break;
                }
            }
        } else {
            i = 1;
            if (heap[i] < v) {
                heap[i] = v;
                while (i * 2 <= lh) {
                    i *= 2;
                    if (i + 1 <= lh && heap[i + 1] < heap[i]) {
                        ++i;
                    }
                    if (heap[i] < heap[i / 2]) {
                        int tmp = heap[i];
                        heap[i] = heap[i / 2];
                        heap[i / 2] = tmp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public Solution(int k, int[] nums) {
        heap = new int[k + 2];
        lh = k;
        la = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            addHeap(nums[i], i + 1);
        }
    }

    public int add(int val) {
        ++la;
        addHeap(val, la);
        return heap[1];
    }
}