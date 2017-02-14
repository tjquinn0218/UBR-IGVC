package robOS2.utility;

public class SICKHelper {
	
	public static int getSICKData(byte b1, byte b2){
		int x = intFromByte(b1);
		int y = intFromByte(b2);
		return getSICKData(x, y);
	}

	public static int getSICKData(int b1, int b2) {
		return b1 | (b2 << 8);
	}
	
	public static int intFromByte(byte b) {
		int result = (int)b;
		if(result >= 0) {
			return result;
		}
		else {
			return result+256;
		}
	}
	
	public static byte[] intToByteArray(int[] array) {
		byte[] result = new byte[array.length];
		for(int i = 0; i < array.length; i++) {
			result[i] = (byte)(array[i] & 0xFF);
		}
		return result;
	}
}
