package pl.dymczyk.bitmanipulation;



public class Problem5 {

	public static void main(String[] args) {
		System.out.println(bitsToConvert(31, 14));
	}

	private static int bitsToConvert(int from, int to) {
		int result = 0;
		for(int difference = from ^ to ; difference > 0 ; difference = difference >> 1) {
			result += difference & 1;
		}
		return result;
	}
}
