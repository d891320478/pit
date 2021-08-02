/**
 * @author htdong
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(Main::f1);
		t1.start();
		Thread t2 = new Thread(Main::f2);
		t2.start();
		t1.interrupt();
	}
	
	public static Object lock = new Object();
	
	public static void f1() {
		synchronized(lock) {
			try {
				lock.wait();
			} catch(Throwable e) {
				System.out.println("f1 e");
			}
			System.out.println("f1 end");
		}
	}
	
	public static void f2() {
		synchronized(lock) {
			System.out.println("f2 start");
			for(long i=0;i<10000000000L;++i) {
			}
			lock.notifyAll();
			System.out.println("f2 end");
		}
	}
}