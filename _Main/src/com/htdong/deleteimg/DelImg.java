package com.htdong.deleteimg;

import java.io.File;

/**
 * @author htdong
 * @date 2020年11月13日 上午8:53:35
 */
public class DelImg {

    private static void dfs(File f) {
        if (f.isFile()) {
            if (f.lastModified() + 86400000L * 15 < System.currentTimeMillis()) {
                f.delete();
            }
        } else if (f.isDirectory()) {
            System.err.println(f.getPath());
            File[] list = f.listFiles();
            for (File iter : list) {
                dfs(iter);
            }
            if (f.listFiles().length == 0) {
                f.delete();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        File ff = new File("D:\\TIMRecord\\312687042\\Image\\Group2");
        File[] list = ff.listFiles();
        int x = list.length / 2;
        Thread t = new Thread(() -> {
            for (int i = 0; i < x; ++i) {
                dfs(list[i]);
            }
        });
        t.start();
        for (int i = x; i < list.length; ++i) {
            dfs(list[i]);
        }
        t.join();
        System.out.println(System.currentTimeMillis() - t1);
    }

}