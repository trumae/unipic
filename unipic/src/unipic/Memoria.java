package unipic;

public class Memoria {
	private static byte [] data = new byte [16];
	private static byte OPTION;
	private static byte TRISGPIO;
	
	private static final int INDF   = 0;
	private static final int TMR0   = 1;
	private static final int PCL    = 2;
	private static final int STATUS = 3;
	private static final int FSR    = 4;
	private static final int OSCCAL = 5;
	private static final int GPIO   = 6;
	
	public void reset(){
		//Seta valor do PCL
		data[PCL] = (byte)0xFF;

		//Seta valor do STATUS
		//1° seta os 3 primeiros bits como 0
		//1F = 0001 1111
		data[STATUS] = (byte)(data[STATUS] & (byte)0x1F);
		//2° seta os proximos 2 bits como 1
		//18 = 0001 1000
		data[STATUS] = (byte)(data[STATUS] | (byte)0x18);
		
		//Seta valor do FSR
		//E0 = 1110 0000
		data[FSR] = (byte)(data[FSR] | (byte)0xE0);
		
		//Seta valor do OSCCAL
		data[OSCCAL] = (byte)0xFE;
		
		//seta valor do OPTION
		OPTION = (byte)0xFF;
		
		//seta valor do TRISGPIO
		TRISGPIO = (byte)0x0F;
	}
	public static byte get(int endereco){
		if(
			endereco == Memoria.INDF   ||
			endereco == Memoria.TMR0   ||
			endereco == Memoria.PCL    ||
			endereco == Memoria.STATUS ||
			endereco == Memoria.FSR    ||
			endereco == Memoria.OSCCAL ||
			endereco == Memoria.GPIO
		){
			//Endereço invalido, dispara exceçao
			return 0;
		}
		return data[endereco];
	}
	public static void set(int endereco, byte valor){
		if(
			endereco == Memoria.INDF   ||
			endereco == Memoria.TMR0   ||
			endereco == Memoria.PCL    ||
			endereco == Memoria.STATUS ||
			endereco == Memoria.FSR    ||
			endereco == Memoria.OSCCAL ||
			endereco == Memoria.GPIO
		){
			//Endereço invalido, dispara exceçao
			return;
		}
		data[endereco] = valor;
	}
	
	//acessar registradores especificos
	public static byte getSTATUS(String nomeBit){
		byte bit;
		switch(nomeBit){
			case "GPWUF":
				// STATUS    = 1010 0110
				// 0x80      = 1000 0000
				// resultado = 1000 0000 = -128, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x80);
				if(bit == -128) bit = 1;
				return bit;
			case "CWUF":
				// STATUS    = 0110 0110
				// 0x40      = 0100 0000
				// resultado = 0100 0000 = 64, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x40);
				if(bit == 64) bit = 1;
				return bit;
			case "TO":
				// STATUS    = 0111 0110
				// 0x10      = 0001 0000
				// resultado = 0001 0000 = 16, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x10);
				if(bit == 16) bit = 1;
				return bit;
			case "PD":
				// STATUS    = 0110 1110
				// 0x08      = 0000 1000
				// resultado = 0000 1000 = 8, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x08);
				if(bit == 8) bit = 1;
				return bit;
			case "Z":
				// STATUS    = 0110 0110
				// 0x04      = 0000 0100
				// resultado = 0000 0100 = 4, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x04);
				if(bit == 4) bit = 1;
				return bit;
			case "DC":
				// STATUS    = 0110 0110
				// 0x02      = 0000 0010
				// resultado = 0000 0010 = 2, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x02);
				if(bit == 2) bit = 1;
				return bit;
			case "C":
				// STATUS    = 0110 0111
				// 0x01      = 0000 0001
				// resultado = 0000 0001 = 1, entao retorna 1
				bit = (byte) (data[STATUS] & (byte)0x01);
				return bit;
			default:
				//nomeBit invalido, dispara excessao
				
				break;
		}
		
		return 0;
	}
	
	public static void main(String [] args){
		byte b = (byte)0x08;
		System.out.print(b);
	}
}
