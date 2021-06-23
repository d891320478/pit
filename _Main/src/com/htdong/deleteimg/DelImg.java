package com.htdong.deleteimg;

import java.io.File;

/**
 * @author htdong
 * @date 2020年11月13日 上午8:53:35
 */
public class DelImg {

    private static void dfs(File f) {
        if (f.isFile()) {
            if (f.lastModified() + 86400000L * 30 < System.currentTimeMillis()) {
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

    public static void main(String[] args) {
        File ff = new File("D:\\TIMRecord\\312687042\\Image\\Group2");
        dfs(ff);
    }
}