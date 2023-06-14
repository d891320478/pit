package com.htdong.deleteimg;

import java.io.File;

/**
 * @author htdong
 * @date 2020年11月13日 上午8:53:35
 */
public class DelImg {

    private static long dfs(File f) {
    	long cnt = 0;
        if (f.isFile()) {
            if (f.lastModified() + 86400000L * 15 < System.currentTimeMillis()) {
            	cnt += f.length();
                f.delete();
            }
        } else if (f.isDirectory()) {
            System.err.println(f.getPath());
            File[] list = f.listFiles();
            for (File iter : list) {
                cnt += dfs(iter);
            }
            if (f.listFiles().length == 0) {
                f.delete();
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        File ff = new File("C:\\Users\\dht31\\Documents\\Tencent Files\\312687042\\Image\\Group2");
        File[] list = ff.listFiles();
        int x = list.length / 2;
        Del otherDel = new Del(x, list);
        Thread t = new Thread(otherDel);
        t.start();
        long c2 = 0;
        for (int i = x; i < list.length; ++i) {
            c2 += dfs(list[i]);
        }
        t.join();
        System.out.println(System.currentTimeMillis() - t1);
        System.out.println((otherDel.getC()+c2)/1024.0/1024.0/1024.0);
    }
    
    static class Del implements Runnable {
    	
    	private int x;
    	private long c;
    	private File[] list;
    	
    	public Del(int x, File[] list) {
    		this.x = x;
    		this.c = 0;
    		this.list = list;
    	}
		
		@Override
		public void run() {
			for (int i = 0; i < x; ++i) {
                c+=dfs(list[i]);
            }
		}
		
		public long getC() {
			return c;
		}
	}

}