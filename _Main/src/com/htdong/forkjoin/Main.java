package com.htdong.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author htdong
 * @date 2020年12月3日 上午9:38:39
 */
public class Main {

    private static class Task extends RecursiveTask<Long> {

        private static final long serialVersionUID = 4328410048601753978L;

        private Long start, end;

        public Task(Long s, Long t) {
            this.start = s;
            this.end = t;
        }

        @Override
        protected Long compute() {
            if (end - start < 100000L) {
                long sum = 0;
                for (long i = start; i <= end; ++i) {
                    sum += i;
                }
                return sum;
            }
            long mid = start + end >> 1;
            Task t1 = new Task(start, mid);
            Task t2 = new Task(mid + 1, end);
            invokeAll(t1, t2);
            return t1.join() + t2.join();
        }
    }

    public static void main(String[] args) {
        long s = 1L;
        long t = 8000000000L;

        long t1 = System.currentTimeMillis();

        ForkJoinPool fjp = new ForkJoinPool(4);
        Long ans = fjp.invoke(new Task(s, t));
        System.out.println(ans);
        long t2 = System.currentTimeMillis();

        Long sum = 0L;
        for (long i = s; i <= t; ++i) {
            sum += i;
        }
        System.out.println(sum);

        long t3 = System.currentTimeMillis();

        System.err.println(t2 - t1);
        System.err.println(t3 - t2);

    }
}