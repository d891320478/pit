package com.htdong.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author htdong
 * @date 2018年9月29日 下午2:17:21
 */

public class MyStack {

    Queue<Integer> queue, q;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue.size() == 1) {
            return queue.remove();
        } else {
            q.clear();
            while(queue.size() > 1) {
                q.add(queue.remove());
            }
            int ret = queue.remove();
            while(!q.isEmpty()) {
                queue.add(q.remove());
            }
            return ret;
        }
    }

    /** Get the top element. */
    public int top() {
        q.clear();
        while(queue.size() > 1) {
            q.add(queue.remove());
        }
        int ret = queue.remove();
        q.add(ret);
        while(!q.isEmpty()) {
            queue.add(q.remove());
        }
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}