/**
 * 
 * @author htdong
 */

public class Main {

	static final int advanceProbe(int probe) {
		probe ^= probe << 13;
		probe ^= probe >>> 17;
		probe ^= probe << 5;
		return probe;
	}

	public static void main(String[] args) {
		for (long i = -2147483648; i <= 2147483647; ++i) {
			if (advanceProbe((int) i) == 0) {
				System.out.println(i);
			}
		}
	}
}