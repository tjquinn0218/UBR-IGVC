package robOS2.hardware.clearPath;

public interface Commands {
	// Command values
	public static final int CmdStart =       128;
	public static final int CmdBaud =        129;
	public static final int CmdControl =     130;
	public static final int CmdSafe =        131;
	public static final int CmdFull =        132;
	public static final int CmdSpot =        134;
	public static final int CmdClean =       135;
	public static final int CmdDemo =        136;
	public static final int CmdDrive =       137;
	public static final int CmdMotors =      138;
	public static final int CmdLeds =        139;
	public static final int CmdSong =        140;
	public static final int CmdPlay =        141;
	public static final int CmdSensors =     142;
	public static final int CmdDock =        143;
	public static final int CmdPWMMotors =   144;
	public static final int CmdDriveWheels = 145;
	public static final int CmdOutputs =     147;
	public static final int CmdSensorList =  149;
	public static final int CmdIRChar =      151;

/*
	// Sensor byte indices - offsets in packets 0, 5 and 6
	public static final int SenBumpDrop =    0;            
	public static final int SenWall =        1;
	public static final int SenCliffL =      2;
	public static final int SenCliffFL =     3;
	public static final int SenCliffFR =     4;
	public static final int SenCliffR =      5;
	public static final int SenVWall =       6;
	public static final int SenOverC =       7;
	public static final int SenIRChar =      10;
	public static final int SenButton =      11;
	public static final int SenDist1 =       12;
	public static final int SenDist0 =       13;
	public static final int SenAng1 =        14;
	public static final int SenAng0 =        15;
	public static final int SenChargeState = 16;
	public static final int SenVolt1 =       17;
	public static final int SenVolt0 =       18;
	public static final int SenCurr1 =       19;
	public static final int SenCurr0 =       20;
	public static final int SenTemp =        21;
	public static final int SenCharge1 =     22;
	public static final int SenCharge0 =     23;
	public static final int SenCap1 =        24;
	public static final int SenCap0 =        25;
	public static final int SenWallSig1 =    26;
	public static final int SenWallSig0 =    27;
	public static final int SenCliffLSig1 =  28;
	public static final int SenCliffLSig0 =  29;
	public static final int SenCliffFLSig1 = 30;
	public static final int SenCliffFLSig0 = 31;
	public static final int SenCliffFRSig1 = 32;
	public static final int SenCliffFRSig0 = 33;
	public static final int SenCliffRSig1 =  34;
	public static final int SenCliffRSig0 =  35;
	public static final int SenInputs =      36;
	public static final int SenAInput1 =     37;
	public static final int SenAInput0 =     38;
	public static final int SenChAvailable = 39;
	public static final int SenOIMode =      40;
	public static final int SenOISong =      41;
	public static final int SenOISongPlay =  42;
	public static final int SenStreamPckts = 43;
	public static final int SenVel1 =        44;
	public static final int SenVel0 =        45;
	public static final int SenRad1 =        46;
	public static final int SenRad0 =        47;
	public static final int SenVelR1 =       48;
	public static final int SenVelR0 =       49;
	public static final int SenVelL1 =       50;
	public static final int SenVelL0 =       51;


	// Sensor packet sizes
	public static final int Sen0Size =       26;
	public static final int Sen1Size =       10;
	public static final int Sen2Size =       6;
	public static final int Sen3Size =       10;
	public static final int Sen4Size =       14;
	public static final int Sen5Size =       12;
	public static final int Sen6Size =       52;

	// Sensor bit masks
	public static final int WheelDropFront = 0x10;
	public static final int WheelDropLeft  = 0x08;
	public static final int WheelDropRight = 0x04;
	public static final int BumpLeft =       0x02;
	public static final int BumpRight =      0x01;
	public static final int BumpBoth =       0x03;
	public static final int BumpEither =     0x03;
	public static final int WheelDropAll =   0x1C;
	public static final int ButtonAdvance =  0x04;
	public static final int ButtonPlay =     0x01;


	// LED Bit Masks
	public static final int LEDAdvance =      0x08;
	public static final int LEDPlay =        0x02;
	public static final int LEDsBoth =       0x0A;

	// OI Modes
	public static final int OIPassive =      1;
	public static final int OISafe =         2;
	public static final int OIFull =         3;


	// Baud codes
	public static final int Baud300 =        0;
	public static final int Baud600 =        1;
	public static final int Baud1200 =       2;
	public static final int Baud2400 =       3;
	public static final int Baud4800 =       4;
	public static final int Baud9600 =       5;
	public static final int Baud14400 =      6;
	public static final int Baud19200 =      7;
	public static final int Baud28800 =      8;
	public static final int Baud38400 =      9;
	public static final int Baud57600 =      10;
	public static final int Baud115200 =     11;


	// Drive radius special cases
	public static final int RadStraight =    32768;
	public static final int RadCCW =         1;
	public static final int RadCW =         -1;



	// Baud UBRRx values
	public static final int Ubrr300 =        3839;
	public static final int Ubrr600 =        1919;
	public static final int Ubrr1200 =       959;
	public static final int Ubrr2400 =       479;
	public static final int Ubrr4800 =       239;
	public static final int Ubrr9600 =       119;
	public static final int Ubrr14400 =      79;
	public static final int Ubrr19200 =      59;
	public static final int Ubrr28800 =      39;
	public static final int Ubrr38400 =      29;
	public static final int Ubrr57600 =      19;
	public static final int Ubrr115200 =     9;
*/
/*
	// Command Module button and LEDs
	#define UserButton        0x10
	#define UserButtonPressed (!(PIND & UserButton))

	#define LED1              0x20
	#define LED1Off           (PORTD |= LED1)
	#define LED1On            (PORTD &= ~LED1)

	#define LED2              0x40
	#define LED2Off           (PORTD |= LED2)
	#define LED2On            (PORTD &= ~LED2)

	#define LEDBoth           0x60
	#define LEDBothOff        (PORTD |= LEDBoth)
	#define LEDBothOn         (PORTD &= ~LEDBoth)


	// Create Port
	#define RobotPwrToggle      0x80
	#define RobotPwrToggleHigh (PORTD |= 0x80)
	#define RobotPwrToggleLow  (PORTD &= ~0x80)

	#define RobotPowerSense    0x20
	#define RobotIsOn          (PINB & RobotPowerSense)


	// Command Module ePorts
	#define LD2Over         0x04
	#define LD0Over         0x02
	#define LD1Over         0x01
*/
}
