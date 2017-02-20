/**
 * @author harika reddy
 *
 */
public class Solution {

	private static Solution instance;

	/**
	 * private constructor -
	 */
	private Solution() {
	}

	/**
	 * @return Thread-safe way to get the instance of Solution class we are
	 *         using Singleton design pattern here.
	 */
	public static synchronized Solution getInstance() {
		if (instance == null) {

			synchronized (Solution.class) {
				if (instance == null) {

					instance = new Solution();
				}
			}
		}
		return instance;
	}

	/**
	 * @param s
	 * @return This method will get the input string as binary value and find
	 *         the minimum ways to split it to equate to power of 5
	 */
	public int getMin(final String s) {

		// 1. Check if the sting is not empty or null.
		// 2. Check if the string contains 1's and 0's.
		// 3. Check the length of the input string is greater than 0 and less
		// than
		// or equal to 50
		if (!empty(s) && isBinary(s) && s.length() > 0 && s.length() <= 50) {

			final long[] f = new long[s.length() + 1];

			f[0] = 0;
			for (int i = 1; i <= s.length(); ++i) {
				f[i] = Integer.MAX_VALUE;

				// traverse the inner loop in reverse order
				for (int j = i; j >= 1; --j) {

					// skip the leading zero's from passed string if zero exists
					// then it will be skipped and continue for next char
					if (s.charAt(j - 1) == '0') {
						continue;
					}

					long num = Long.parseLong(s.substring(j - 1, i), 2);

					if (isPower(num)) {
						// Returns the smallest possible split value
						f[i] = Math.min(f[i], f[j - 1] + 1);
					}
				}

			}
			// need to type caste the return value to int as method return type
			// is integer
			return f[s.length()] == Integer.MAX_VALUE ? -1 : (int) f[s.length()];
		}

		return 0;
	}

	/**
	 * @param val
	 * @return
	 */
	private boolean isPower(final long val) {

		// check if the passed valued is 0 then ignore and continue
		if (val == 0) {
			return false;
		}
		// check if the natural logarithm is divisible with 5
		final int n = (int) (Math.log(val) / Math.log(5));
		// check if the value is exactly equal to power of 5-
		return Math.pow(5, n) == val;
	}

	/**
	 * @param s
	 * @return function checks and returns true for empty string.-
	 */
	private boolean empty(final String s) {

		return s == null || s.trim().isEmpty();
	}

	/**
	 * @param s
	 * @return function checks and returns true for binary string
	 */
	private boolean isBinary(final String s) {

		return s.matches("[01]+");
	}

}