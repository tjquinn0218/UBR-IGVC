package robOS2.hardware.sick;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import robOS2.utility.SICKHelper;

public class SICKData {
		
	private static int OFFSET = 7;
	private static int CRC16_GEN_POL = 0x8005;
	private byte[] _data;
	private int _length;
	
	public SICKData(byte[] data) {
		_data = data;
		_length = data.length;
	}
	
	public SICKData(int[] data) {
		this(SICKHelper.intToByteArray(data));
	}
	
	public SICKData(String fileName) {
		_data = new byte[2048];
		_length = 0;
		buildFromFile(fileName);
	}
	
	public static String byteString(byte b) {
		int data = (int)b & 0xFF;
		String s = Integer.toString(data, 16);
		if(s.length() == 1) {
			s = "0" + s;
		}
		return s;
	}
	
	public static int compare(SICKData l1, SICKData l2) {
		int count = 0;
		int length = Math.min(l1.getLength(), l2.getLength());
		for(int i = 0; i < length; i++) {
			if(l1.get(i) == l2.get(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static int compareHeader(SICKData l1, SICKData l2) {
		int count = 0;
		int length = Math.min(l1.getLength(), l2.getLength());
		while(count < length && l1.get(count) == l2.get(count)) {
			count++;
		}
		return count;
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
	
	public void buildFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			while(line != null) {
				processLine(line.trim());
				line = br.readLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	public byte get(int index) {
		return _data[index];
	}
	
	public int getData(int index) {
		int realIndex = index * 2 + OFFSET;
		//int data = Utility.getSICKData(_data[realIndex], _data[realIndex+1]);
		int data = getSICKData(_data[realIndex], _data[realIndex+1]);
		return data & 0x1FFF;
	}
	
	public int getLength() {
		return _length;
	}
	
	public int getRealLength() {
		int i = intFromByte(_data[3]) << 8;
		i += intFromByte(_data[2]);
		return i;
	}
	
	public int getSICKSize() {
		byte b1 = _data[2];
		byte b2 = _data[3];
		return SICKHelper.getSICKData(b1, b2);
	}
	
	public String toString() {
		int j = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < _length; i++) {
			if(j % 16 == 0 && j != 0) {
				sb.append("\n");
			}
			j++;
			sb.append(byteString(_data[i]) + " ");
		}
		return sb.toString();
	}
	
	public boolean validHeader() {
		int j = intFromByte(_data[0]);
		if(j != 2) {
			return false;
		}
		j = intFromByte(_data[1]);
		if(j != 0x80) {
			return false;
		}
		return true;
	}
	
	public boolean verifyCRC() {
		int expectedCRC = SICKHelper.getSICKData(_data[_length-2], _data[_length-1]);
		
		int crc16 = 0;
		byte[] abData = new byte[2];
		abData[0] = 0;
		int len = _length - 2;
		int index = 0;
		
		while(len > 0) {
			len--;
			abData[1] = abData[0];
			abData[0] = _data[index++];
			if((crc16 & 0x8000) != 0) {
				crc16 = (crc16 & 0x7fff) << 1;
				crc16 ^= CRC16_GEN_POL;
			}
			else {
				crc16 <<= 1;
			}
			crc16 ^= SICKHelper.getSICKData(abData[0], abData[1]);
			
		}
		return expectedCRC == crc16;
	}	
		
	public void writeToFile(String fileName) {
		try {
			PrintStream ps = new PrintStream(fileName);
			Scanner sc = new Scanner(toString());
			while(sc.hasNextLine()) {
				ps.println(sc.nextLine());
				ps.flush();
			}
		}
		catch(IOException e) {}
	}
	
	private int getSICKData(byte b1, byte b2) {
		return ((int)b2 << 8) | ((int)b1 & 0xFF); 
	}

	private void processLine(String line) {
		Scanner sc = new Scanner(line);
		while(sc.hasNext()) {
			String s = sc.next();
			int d = Integer.valueOf(s, 16);
			_data[_length] = (byte)d;
			_length++;
		}
	}
}
