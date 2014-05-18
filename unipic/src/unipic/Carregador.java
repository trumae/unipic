package unipic;

import instrucoes.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;
public class Carregador {
	/***
	 * Le o arquivo com o programa e retorna o objeto Flash com o programa 
	 * armazenado
	 * @param filename nome do arquivo com codigo
	 * @return Flash com programa carregado
	 */
	//declaração das instrucoes
	private Object [][] instrucoes = new Object[][]{
			{ ADDWF.class, "^000111[0|1]{1}[0|1]{5}$" },
			{ ANDWF.class, "^000101[0|1]{1}[0|1]{5}$" },
			{ CLRF.class, "^0000011[0|1]{5}$" },
			{ CLRW.class, "^000001000000$" },
			{ COMF.class, "^001001[0|1]{1}[0|1]{5}$" },
			{ DECF.class, "^000011[0|1]{1}[0|1]{5}$" },
			{ DECFSZ.class, "^001011[0|1]{1}[0|1]{5}$" },
			{ INCF.class, "^001010[0|1]{1}[0|1]{5}$" },
			{ INCFSZ.class, "^001111[0|1]{1}[0|1]{5}$" },
			{ IORWF.class, "^000100[0|1]{1}[0|1]{5}$" },
			{ MOVF.class, "^001000[0|1]{1}[0|1]{5}$" },
			{ MOVWF.class, "^0000001[0|1]{5}$" },
			{ NOP.class, "^000000000000$" },
			{ RLF.class, "^001101[0|1]{1}[0|1]{5}$" },
			{ RRF.class, "^001100[0|1]{1}[0|1]{5}$" },
			{ SUBWF.class, "^000010[0|1]{1}[0|1]{5}$" },
			{ SWAPF.class, "^001110[0|1]{1}[0|1]{5}$" },
			{ XORWF.class, "^000110[0|1]{1}[0|1]{5}$" },
			
			{ BCF.class, "^0100[0|1]{3}[0|1]{5}$" },
			{ BSF.class, "^0101[0|1]{3}[0|1]{5}$" },
			{ BTFSC.class, "^0110[0|1]{3}[0|1]{5}$" },
			{ BTFSS.class, "^0111[0|1]{3}[0|1]{5}$" },

			{ ANDLW.class, "^1110[0|1]{8}$" },
			{ CALL.class, "^1001[0|1]{8}$" },
			{ CLRWDT.class, "^000000000100$" },
			{ GOTO.class, "^101[0|1]{9}$" },
			{ IORLW.class, "^1101[0|1]{8}$" },
			{ MOVLW.class, "^1100[0|1]{8}$" },
			{ OPTION.class, "^000000000010$" },
			{ RETLW.class, "^1000[0|1]{8}$" },
			{ SLEEP.class, "^000000000011$" },
			{ TRIS.class, "^000000000[0|1]{3}$" },
			{ XORLW.class, "^1111[0|1]{8}$" }
	};
	
//	//BYTE-ORIENTED
//	ADDWF 	= "^000111[0|1]{1}[0|1]{5}$";
//	ANDWF 	= "^000101[0|1]{1}[0|1]{5}$";
//	CLRF 	= "^0000011[0|1]{5}$";
//	CLRW 	= "^000001000000$";
//	COMF 	= "^001001[0|1]{1}[0|1]{5}$";
//	DECF 	= "^000011[0|1]{1}[0|1]{5}$";
//	DECFSZ 	= "^001011[0|1]{1}[0|1]{5}$";
//	INCF 	= "^001010[0|1]{1}[0|1]{5}$";
//	INCFSZ 	= "^001111[0|1]{1}[0|1]{5}$";
//	IORWF 	= "^000100[0|1]{1}[0|1]{5}$";
//	MOVF 	= "^001000[0|1]{1}[0|1]{5}$";
//	MOVWF 	= "^0000001[0|1]{5}$";
//	NOP 	= "^000000000000$";
//	RLF 	= "^001101[0|1]{1}[0|1]{5}$";
//	RRF 	= "^001100[0|1]{1}[0|1]{5}$";
//	SUBWF 	= "^000010[0|1]{1}[0|1]{5}$";
//	SWAPF 	= "^001110[0|1]{1}[0|1]{5}$";
//	XORWF 	= "^000110[0|1]{1}[0|1]{5}$";
//	
//	//BIT-ORIENTED
//	BCF 	= "^0100[0|1]{3}[0|1]{5}$";
//	BSF 	= "^0101[0|1]{3}[0|1]{5}$";
//	BTFSC 	= "^0110[0|1]{3}[0|1]{5}$";
//	BTFSS 	= "^0111[0|1]{3}[0|1]{5}$";
//	
//	//LITERAL AND CONTROL
//	ANDLW 	= "^1110[0|1]{8}$";
//	CALL 	= "^1001[0|1]{8}$";
//	CLRWDT 	= "^000000000100$";
//	GOTO 	= "^101[0|1]{9}$";
//	IORLW 	= "^1101[0|1]{8}$";
//	MOVLW 	= "^1100[0|1]{8}$";
//	OPTION 	= "^000000000010$";
//	RETLW 	= "^1000[0|1]{8}$";
//	SLEEP 	= "^000000000011$";
//	TRIS 	= "^000000000[0|1]{3}$";
//	XORLW 	= "^1111[0|1]{8}$";

	
	//codigo
	private String [] codigo = {
			":020000040000FA",
			":100000002500140A070EE201090801080B0804087C",
			":1000100008080008050806083100FF0C3000F0024F",
			":100020000F0AF1020D0A0008080C06006700000C18",
			":10003000020075007600130202093200030E26004A",
			":10004000030C0C0932031203040F2600030C0C09E5",
			":10005000B5024306B6021402030EE2013B0A400A4F",
			":100060004B0A010C660734001602020F43071B0AF5",
			":1000700074006600030066060300010C34001B0ACE",
			":10008000020C6607460A340075007600F7024A0A39",
			":10009000060C3700560A1602010F4307560A030CD6",
			":1000A000340075007600D70033001B0A15021F0EBE",
			":1000B00043071B0A9302030E4306010C040F33008F",
			":0200C0001B0A19",
			":021FFE00EA0FE8",
			":00000001FF"
	};
	
	
	private static String[] lerArquivo(String caminho){
		String linha = ""; 
		ArrayList<String> hexLista = new ArrayList<>();

		int i = 0;

		try {  

			BufferedReader in = new BufferedReader(new FileReader(caminho));  
			while ((linha = in.readLine()) != null) {  

				hexLista.add(i, linha);
				i++;
			} 
			in.close();
			String[] hex = new String [hexLista.size()];

			for( int x = 0; x < hexLista.size(); x++ ){
				hex[x] = hexLista.get(x);
				System.out.println(hex[x]);  // PARA VER SE FUNCIONA =D
			}
			return hex;

		} catch (Exception e) {
			System.err.println("Erro na abertura do arquivo " + caminho);  
			System.err.println(e);
			return null; 
		}
	}
	
	public String getAsm(){
 		return "";
	}
	
	/** 
	 * Metodo que converte um numero hexadecimal para binario
	 * 
	 * @param hex String - Numero a ser convertido
	 * 
	 * @return String - Bin�rio de 4 bits
	 */
	public String hexToBin(String hex){
		return String.format("%04d",Integer.parseInt(Integer.toBinaryString(Integer.parseInt(hex,16))));
	}
	
	/**
	 * Metodo de carregamento do arquivo hex
	 * 
	 * @param filename String - ...
	 * 
	 * @return Vector<Instrucao> - Instrucoes que serao encaminhadas para FLASH da PIC
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	Vector<Instrucao> load(String filename) throws InstantiationException, IllegalAccessException {
		int byteCount;
		int address;
		int recordType;
		String data;
		int checksum;
		
		int dataLenght;
		String [] bitData;
		String [] binInst;
		Vector<Instrucao> objInstrucoes =  new Vector<Instrucao>();
		
		codigo = lerArquivo(filename);
		for(String c : codigo){
			byteCount 	= Integer.parseInt(c.substring(1,3),16);
			address 	= Integer.parseInt(c.substring(3,7),16);
			recordType 	= Integer.parseInt(c.substring(7,9),16);
			
			dataLenght 	= byteCount*2;
			data 		= c.substring(9,(9+dataLenght));
			
			checksum 	= Integer.parseInt(c.substring((9+dataLenght),(11+dataLenght)),16);
			
			bitData 	= new String[dataLenght];
			
			switch(recordType){
				case 0:
					for(int i = 0;i<data.length();i++){
						bitData[i] = hexToBin(data.substring(i,i+1));
					}
					
					bitData = inverteData(bitData);
					
					binInst = new String[(int)(bitData.length/4)];
					
					for(int i = 0, j = 0; i < bitData.length; i += 4, j++){
						binInst[j] = bitData[i+1]+bitData[i+2]+bitData[i+3];
					}
					//.matcher(binInstVal)
					for(String binInstVal : binInst){
						for(Object[] instrucoesVal : this.instrucoes){
							if(Instrucao.matcher(binInstVal, (String) instrucoesVal[1])){
								Instrucao i = (Instrucao)((Class<?>) instrucoesVal[0]).newInstance();
								i.setup(binInstVal);
								objInstrucoes.add(i);
								continue;
							}
						}
					}
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
	  			default:
	  				break;
			}
		}
		return objInstrucoes;
	}
	
	/**
	 * Inverte cada par de hexadecimais do campo data para ajustar
	 * os valores de MSB e LSB.
	 * 
	 * @param data String[] - Array de Strings contendo todo o campo data
	 * ja convertido para Binarios de 4 bits
	 * 
	 * @return String[] - Array de Strings com todos os pares de Binarios 
	 * invertidos.
	 */
	private String [] inverteData(String [] data){
		String backup;
		for(int i = 0; i < data.length; i++){
			backup = data[i];
			data[i] = data[i+2];
			data[i+2] = backup;
			
			if((i % 2) != 0) i+=2;
		}
		return data;
	}
	
	//metodo main para testes simples
	public static void main(String [] args){
		Carregador c = new Carregador();
		try{
			Vector<Instrucao> i = c.load("teste");
			for(Instrucao in : i){
				System.out.println(in.toString());
			}
		}
		catch(Exception e){
			
		}
	}
}
