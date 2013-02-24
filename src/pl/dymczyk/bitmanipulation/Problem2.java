package pl.dymczyk.bitmanipulation;


public class Problem2 {

	public static void main(String[] args) {
		System.out.println(decimalToBinary(0.5));
	}

	private static String decimalToBinary(double d) {
		if(d >= 1 || d <= 0) {
			return "ERROR";
		}
		
		StringBuilder result = new StringBuilder("0.");

		while(d > 0) {
			if(result.length() > 32 ) {
				return "ERROR";
			}
			
			double multiplied = d*2;
			if(multiplied >= 1) {
				result.append("1");
				d = multiplied - 1;
			} else {
				result.append("0");
				d = multiplied;
			}
		}
		
		return result.toString();
	}
	
}
