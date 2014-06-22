package testes;

import static org.junit.Assert.*;
import instrucoes.BCF;
import junit.framework.TestCase;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
import instrucoes.*;

public class TesteByteOrientedInstructions extends TestCase{
	
	public void testeXORWF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)1); 
		mem.set(14, (byte)0);
		mem.set(13, (byte)1);
		mem.set(12, (byte)0);
		
		cpu.setW((byte)1);
		
		Instrucao i1 = new XORWF();
		i1.setup("000110001111"); // d=0 f=15, resultado esperado: w=0
		i1.run(mem, cpu);
		if(cpu.getW() != 0){
			fail("Erro na 1° instrucao, esperado: w=0, obtido: "+cpu.getW());
		}

		cpu.setW((byte)1);
		
		Instrucao i2 = new XORWF();
		i2.setup("000110101110"); // d=1 f=14, resultado esperado: f=1
		i2.run(mem, cpu);
		if(mem.get(14) != 1){
			fail("Erro na 2° instrucao, esperado: f=1, obtido: "+mem.get(14));
		}

		cpu.setW((byte)0);
		
		Instrucao i3 = new XORWF();
		i3.setup("000110001101"); // d=0 f=13, resultado esperado: w=1
		i3.run(mem, cpu);
		if(cpu.getW() != 1){
			fail("Erro na 3° instrucao, esperado: w=1, obtido: "+cpu.getW());
		}

		cpu.setW((byte)0);
		
		Instrucao i4 = new XORWF();
		i4.setup("000110101100"); // d=1 f=12, resultado esperado: f=0
		i4.run(mem, cpu);
		if(mem.get(12) != 0){
			fail("Erro na 4° instrucao, esperado: f=0, obtido: "+mem.get(12));
		}
	}
	
	public void testeSWAPF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0x0f); 
		mem.set(14, (byte)0xf0);
		mem.set(13, (byte)0x39);
		mem.set(12, (byte)0x93);
		
		Instrucao i1 = new SWAPF();
		i1.setup("001110001111"); // d=0 f=15, resultado esperado: w=f0
		i1.run(mem, cpu);
		if(cpu.getW() != (byte)0xf0){
			fail("Erro na 1° instrucao, esperado: w=0xf0, obtido: "+cpu.getW());
		}
		
		Instrucao i2 = new SWAPF();
		i2.setup("001110001110"); // d=0 f=14, resultado esperado: w=0f
		i2.run(mem, cpu);
		if(cpu.getW() != (byte)0x0f){
			fail("Erro na 2° instrucao, esperado: w=0x0f, obtido: "+cpu.getW());
		}
		
		Instrucao i3 = new SWAPF();
		i3.setup("001110001101"); // d=0 f=13, resultado esperado: w=93
		i3.run(mem, cpu);
		if(cpu.getW() != (byte)0x93){
			fail("Erro na 3° instrucao, esperado: w=0x93, obtido: "+cpu.getW());
		}
		
		Instrucao i4 = new SWAPF();
		i4.setup("001110001100"); // d=0 f=12, resultado esperado: w=39
		i4.run(mem, cpu);
		if(cpu.getW() != (byte)0x39){
			fail("Erro na 4° instrucao, esperado: w=0x39, obtido: "+cpu.getW());
		}
	}
	
	public void testeSUBWF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)10); 
		mem.set(14, (byte)20);
		
		cpu.setW((byte)5);
		
		Instrucao i1 = new SUBWF();
		i1.setup("000110001111"); // d=0 f=15, resultado esperado: w=5
		i1.run(mem, cpu);
		if(cpu.getW() != (byte)5){
			fail("Erro na 1° instrucao, esperado: w=5, obtido: "+cpu.getW());
		}

		cpu.setW((byte)50);
		
		Instrucao i2 = new SUBWF();
		i2.setup("000110101110"); // d=1 f=14, resultado esperado: f=-30
		i2.run(mem, cpu);
		if(mem.get(14) != (byte)-30){
			fail("Erro na 2° instrucao, esperado: f=-30, obtido: "+mem.get(14));
		}
	}
	
	public void testeADDWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)0);
 		mem.set(14, (byte)10);
 		mem.set(13, (byte)20);
 		//Seta o valor de w. w = 0
 		cpu.setW((byte)00000000);
 		
 		Instrucao i1 = new ADDWF();
		i1.setup("000111000000"); //f=0 
 		Instrucao i2 = new ADDWF();
		i2.setup("000111001010"); //f=10 
 		Instrucao i3 = new ADDWF();
		i3.setup("000111010100"); //f=20 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 10){
 			fail("Erro na 1a Instrucao, esperado: 10 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 20){
 			fail("Erro na 1a Instrucao, esperado: 20 , obtido: "+mem.get(13));
 		}
	}
	
	public void testeIORLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)0);
 		mem.set(14, (byte)29);
 		mem.set(13, (byte)58);
 		//Seta o valor de w. w = 29
 		cpu.setW((byte)00011101);
 		
 		Instrucao i1 = new IORLW();
		i1.setup("000100000000"); //f=0 
 		Instrucao i2 = new IORLW();
		i2.setup("000100000001"); //f=1 
 		Instrucao i3 = new IORLW();
		i3.setup("000100000010"); //f=2 
 		
 		i1.run(mem, cpu);
 		//w*f -> 80*0=0
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		//w*f -> 80*1=80
 		if(mem.get(14) != 29){
 			fail("Erro na 1a Instrucao, esperado: 29 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		//w*f -> 80*2=160
 		if(mem.get(13) != 58){
 			fail("Erro na 1a Instrucao, esperado: 58 , obtido: "+mem.get(13));
 		}
	}
	
	public void testeMOVLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)127);
 		mem.set(14, (byte)0);
 		mem.set(13, (byte)50);
 		
 		Instrucao i1 = new MOVLW();
		i1.setup("110001111111"); //f=127 
 		Instrucao i2 = new MOVLW();
		i2.setup("110000000000"); //f=0 
 		Instrucao i3 = new MOVLW();
		i3.setup("110000110010"); //f=50
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 127){
 			fail("Erro na 1a Instrucao, esperado: 127 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(14));
 		}
 		
 		i3.run(mem, cpu);
 		if(mem.get(13) != 50){
 			fail("Erro na 1a Instrucao, esperado: 50 , obtido: "+mem.get(13));
 		}
	}
	
	public void testANDWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		// seta w=55
 		cpu.setW((byte)01011001);
 		
 		mem.set(15, (byte)70);
 		mem.set(14, (byte)57);
 		mem.set(13, (byte)62);

 		
 		Instrucao i1 = new ANDWF();
		i1.setup("010100001111"); //f=15
		Instrucao i2 = new ANDWF();
		i2.setup("010100000010"); //f=2
		Instrucao i3 = new ANDWF();
		i3.setup("010100000111"); //f=7
		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 70){
 			fail("Erro na 1a Instrucao, esperado: 70 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 57){
 			fail("Erro na 1a Instrucao, esperado: 57 , obtido: "+mem.get(14));
 		}
 		
 		i3.run(mem, cpu);
 		if(mem.get(13) != 62){
 			fail("Erro na 1a Instrucao, esperado: 62 , obtido: "+mem.get(13));
 		}
	}
	
	public void testCLRF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)0);
 		mem.set(14, (byte)0);
 		mem.set(13, (byte)0);
		
		Instrucao i1 = new CLRF();
 		i1.setup("000001100001"); // f=1
		Instrucao i2 = new CLRF();
 		i2.setup("000001100010"); // f=2
		Instrucao i3 = new CLRF();
 		i3.setup("000001100101"); // f=5
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(14));
 		}
 		
 		i3.run(mem, cpu);
 		if(mem.get(13) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(13));
 		}
	}
	
	public void testCLRW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)0);
 		mem.set(14, (byte)0);
 		mem.set(13, (byte)0);
 		
 		Instrucao i1 = new CLRW();
 		i1.setup("000001000000");
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
		}
	}
	
	public void testDECF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)14);	
 		
 		Instrucao i1 = new DECF();
 		i1.setup("001100001111");
 		
 		i1.run(mem, cpu); 		
		if(mem.get(15) != 14){
 			fail("Erro na 1a Instrucao, esperado: 14 , obtido: "+mem.get(15));
		}
	}
	
	public void testCOMF(){
	Memoria mem = new Memoria();
		CPU cpu = new CPU();

		mem.set(15, (byte)241);	
		
		Instrucao i1 = new COMF();
		i1.setup("100100001111");
		
		i1.run(mem, cpu);
		if(mem.get(15) != -15){
			fail("Erro na 1a Instrucao, esperado: -15 , obtido: "+mem.get(15));
		}
	}
	
	public void testDECFSZ(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)14);	
 		mem.set(14, (byte)6);	
 		mem.set(13, (byte)2);	
 		
 		Instrucao i1 = new DECFSZ();
 		i1.setup("101100001111"); //f=15
 		Instrucao i2 = new DECFSZ();
 		i2.setup("101100000111"); //f=7
 		Instrucao i3 = new DECFSZ();
 		i3.setup("101100000011"); //f=3
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 14){
 			fail("Erro na 1a Instrucao, esperado: 14 , obtido: "+mem.get(15));
		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 6){
 			fail("Erro na 1a Instrucao, esperado: 6 , obtido: "+mem.get(14));
		}
 		
 		i3.run(mem, cpu);
 		if(mem.get(13) != 2){
 			fail("Erro na 1a Instrucao, esperado: 3 , obtido: "+mem.get(13));
		}
	}
	
	public void testINCFSZ(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)16);	
 		mem.set(14, (byte)8);
 		mem.set(13, (byte)4);
 		
 		Instrucao i1 = new DECFSZ();
 		i1.setup("001111001111"); //f=15
 		Instrucao i2 = new DECFSZ();
 		i2.setup("001111000111"); //f=7
 		Instrucao i3 = new DECFSZ();
 		i3.setup("001111000011"); //f=3
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 16){
 			fail("Erro na 1a Instrucao, esperado: 16 , obtido: "+mem.get(15));
		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 8){
 			fail("Erro na 1a Instrucao, esperado: 8 , obtido: "+mem.get(14));
		}
 		
 		i3.run(mem, cpu);
 		if(mem.get(13) != 4){
 			fail("Erro na 1a Instrucao, esperado: 4 , obtido: "+mem.get(13));
		}
	}
	
	public void testMOVF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)15);	
 		mem.set(14, (byte)7);	
 		mem.set(13, (byte)3);	
 		
 		Instrucao i1 = new MOVF();
 		i1.setup("001000001111"); // f=15
 		Instrucao i2 = new MOVF();
 		i1.setup("001000001111"); // f=7
 		Instrucao i3 = new MOVF();
 		i1.setup("001000001111"); // f=3
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 15){
 			fail("Erro na 1a Instrucao, esperado: 16 , obtido: "+mem.get(15));
		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(14) != 7){
 			fail("Erro na 1a Instrucao, esperado: 7 , obtido: "+mem.get(14));
		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 3){
 			fail("Erro na 1a Instrucao, esperado: 3 , obtido: "+mem.get(13));
		}
	}
	
}
