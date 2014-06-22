package unipic;

public class Memoria {
	private byte bit;
	
	private  byte [] data = new byte [16];
	private  byte OPTION;
	private  byte TRISGPIO;
	
	private static final int INDF   = 0;
	private static final int TMR0   = 1;
	private static final int PCL    = 2;
	private static final int STATUS = 3;
	private static final int FSR    = 4;
	private static final int OSCCAL = 5;
	private static final int GPIO   = 6;
	
	//private static final int OPTION_REG = 0;
			
	private static final double INTOSC = 0.018;  //18ms
	
	public void reset(){
		//Seta valor do PCL
		data[PCL] = (byte)0xFF;

		//Seta valor do STATUS
		//1� seta os 3 primeiros bits como 0
		//1F = 0001 1111
		data[STATUS] = (byte)(data[STATUS] & (byte)0x1F);
		//2� seta os proximos 2 bits como 1
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
	public  byte get(int endereco){
		if(
			endereco == Memoria.INDF   ||
			endereco == Memoria.TMR0   ||
			endereco == Memoria.PCL    ||
			endereco == Memoria.STATUS ||
			endereco == Memoria.FSR    ||
			endereco == Memoria.OSCCAL ||
			endereco == Memoria.GPIO
		){
			//Endere�o invalido, dispara exce�ao
			return 0;
		}
		return data[endereco];
	}
	public  void set(int endereco, byte valor){
		if(
			endereco == Memoria.INDF   ||
			endereco == Memoria.TMR0   ||
			endereco == Memoria.PCL    ||
			endereco == Memoria.STATUS ||
			endereco == Memoria.FSR    ||
			endereco == Memoria.OSCCAL ||
			endereco == Memoria.GPIO
		){
			//Endere�o invalido, dispara exce�ao
			return;
		}
		data[endereco] = valor;
	}
	
	//acessar registradores especificos
	public  byte getSTATUS(String nomeBit){
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
	
	public void setSTATUS(String nomeBit, byte bit){
		switch(nomeBit){
			case "GPWUF":
				this.bit=bit;
			case "CWUF":
				this.bit=bit;
			case "Z":
				this.bit=bit;
			case "DC":
				this.bit=bit;
			case "C":
				this.bit=bit;
			default:
				//nomeBit invalido, dispara excecao
				break;
		}
	}
	
	public  byte getINDF(byte bit){
		// O INDF atende ao registro cujo endereco esta no FSR.
		data[INDF] = getFSR(bit);
		return data[INDF];
	}
	
	public void setINDF(byte endereco){
		this.data[INDF]=endereco;
	}
	
	public  byte getFSR(byte pEndereco){  
		// "Ponteiro" de endereco de memoria de dados. (Enderecamento indireto)
		data[FSR] = (byte) pEndereco;
		// Incrementa em 1 o valor do FSR
		//data[FSR]= (byte) (data[FSR] & (byte)0x01);
		return data[FSR];
	}
	
	public void setFSR(byte pEndereco){  
		this.data[FSR] = (byte) pEndereco;
	}
	
	public  byte getOSCCAL(String nomeBit){
		byte bit;
		// Frequencia interna = 4MHz
		// Contem 7 bits para calibracao e sao configurados da mesma maneira
		switch(nomeBit){
			case "CAL6":
				// OSCCAL    			= 0011 1111
				// Maximum Frequency  	= 0011 1111
				// Center Frequency     = 0000 0000   
				// Minimum Frequency    = 0100 0000  
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL5":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL4":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL3":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL2":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL1":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "CAL0":
				bit = (byte) (data[OSCCAL]);
				if((bit >= 0) && (bit <=127)) bit = 1;
				return bit;
			case "FOSC4":
				// FOSC4    			= INTOSC/4
				bit = (byte) (data[OSCCAL]);
				if(bit == INTOSC/4) bit =1;
				return bit;
			default:
				//nomeBit invalido, dispara excessao		
				break;
		}
		
		return 0;
	}
	
	public void setOSCCAL(String nomeBit, byte bit){
		switch(nomeBit){
			case "CAL6":
				this.bit=bit;
			case "CAL5":
				this.bit=bit;
			case "CAL4":
				this.bit=bit;
			case "CAL3":
				this.bit=bit;
			case "CAL2":
				this.bit=bit;
			case "CAL1":
				this.bit=bit;
			case "CAL0":
				this.bit=bit;
			case "FOSC4":
				this.bit=bit;
			default:
				//nomeBit invalido, dispara excessao		
				break;
		}

	}	
	
	public  byte getGPIO(String nomeBit, byte bit){  
		// O valor do bit define se a tensao eh alta (1) ou baixa (0)
		byte tensao = 0;
		switch(nomeBit){
			case "GP0":
				if (bit == (byte) 1){
					tensao=1;
					return tensao;
				} else return tensao;
			case "GP1":
				if (bit == (byte) 1){
					tensao=1;
					return tensao;
				} else return tensao;
			case "GP2":
				if (bit == (byte) 1){
					tensao=1;
					return tensao;
				} else return tensao;
			default:
				//nomeBit invalido, dispara excessao		
				break;
		}
		return 0;
	}
	
	public void setGPIO(String nomeBit, byte bit){  
		switch(nomeBit){
			case "GP0":
				if (bit == (byte) 1){
					this.data[GPIO]=1;
				} else this.data[GPIO]=0;
			case "GP1":
				if (bit == (byte) 1){
					this.data[GPIO]=1;
				} else this.data[GPIO]=0;
			case "GP2":
				if (bit == (byte) 1){
					this.data[GPIO]=1;
				} else this.data[GPIO]=0;
			case "GP3":
				if (bit == (byte) 1){
					this.data[GPIO]=1;
				} else this.data[GPIO]=0;
			default:
				//nomeBit invalido, dispara excessao		
				break;
		}
	}
	
	public  byte getPCL(){
		return data[PCL];
	}
	
	public void setPCL(byte pc){
		data[PCL] = pc;
	}
	
	public  byte getTRM0(String nomeBit){
		return 0;
	}
	
	public static void main(String [] args){
		byte b = (byte)0x08;
		System.out.print(b);
	}
}
