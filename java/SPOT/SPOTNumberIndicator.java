
public class SPOTNumberIndicator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int value = 124;
		boolean shadeOffBits = false;
		updateLeds(value, shadeOffBits);
	}

	public static void updateLeds(int value, boolean shadeOffBits) {
		int lastValue = 0;
		value = Math.abs(value % 9);
		value = (int) (Math.pow(2, value) -1);

		for (int i = 0; i < 8; i++) {
			//System.out.println("i = " + i + "\tValue = " + value);
			if ((value & 1) > 0) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
			value = value >> 1;
		}

		lastValue = value;
	}
}
