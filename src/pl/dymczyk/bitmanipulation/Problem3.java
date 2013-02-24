package pl.dymczyk.bitmanipulation;



public class Problem3 {

	public static void main(String[] args) {
		System.out.println(printNextLarger(15));
		System.out.println(printNextSmaller(15));
	}

	private static int printNextLarger(int i) {
		int smallest = i & -i;
		int r = i + smallest;
		return (( ( (r^i) >> 2) / smallest)) | r;
	}
	
	private static int printNextSmaller(int i) {
		return ~printNextLarger(~i);
	}
	
}
