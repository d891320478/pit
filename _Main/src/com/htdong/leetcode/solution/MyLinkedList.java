package com.htdong.leetcode.solution;

public class MyLinkedList {

    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    ListNode head, tail;
    int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is
     * invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode next = head;
        for (int i = 0; i < index; ++i) {
            next = next.next;
        }
        return next.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After
     * the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode next = new ListNode(val);
        next.next = head;
        head = next;
        if (tail == null) {
            tail = next;
        }
        ++size;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode next = new ListNode(val);
        if (tail == null) {
            head = tail = next;
        } else {
            tail.next = next;
            tail = next;
        }
        ++size;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index
     * equals to the length of linked list, the node will be appended to the end of
     * linked list. If index is greater than the length, the node will not be
     * inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode next = head;
        for (int i = 0; i < index - 1; ++i) {
            next = next.next;
        }
        ListNode c = new ListNode(val);
        c.next = next.next;
        next.next = c;
        ++size;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            ListNode next = head, pre = null;
            for (int i = 0; i < index; ++i) {
                pre = next;
                next = next.next;
            }
            pre.next = next.next;
            if (index + 1 == size) {
                tail = pre;
            }
        }
        --size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
 * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */