package leetcode;

public class leetcode007 {

	public int reverse(int x) {
		long res = 0;

		// ex:123
		// loop 1: res(0) * 10 + x(123) % 10 ---> res = 3
		// x(123) /= 10 ---> x = 12
		// loop 2: res(3) * 10 + x(12) % 10 ---> res = 32
		// x(12) /= 10 ---> x = 1
		// loop 3: res(32) * 10 + x(1) % 10 ---> res = 321
		// x(1) /= 10 ---> x = 0
		while (x != 0) {
			res = res * 10 + x % 10;
			x /= 10;
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
				return 0;
		}

		return (int) res;
	}

}
