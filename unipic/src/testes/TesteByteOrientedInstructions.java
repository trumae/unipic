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
	
	public void testeMOVWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)2);
 		mem.set(14, (byte)2);
 		mem.set(13, (byte)2);
 		
 		cpu.setW((byte)00000010);
 		
 		Instrucao i1 = new MOVWF();
		i1.setup("000001000001"); //f=65 
 		Instrucao i2 = new MOVWF();
		i2.setup("000001000010"); //f=66 
 		Instrucao i3 = new MOVWF();
		i3.setup("000001000011"); //f=67 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 2){
 			fail("Erro na 1a Instrucao, esperado: 2 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 2){
 			fail("Erro na 1a Instrucao, esperado: 2 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 2){
 			fail("Erro na 1a Instrucao, esperado: 2 , obtido: "+mem.get(13));
 		}
	}
	
	public void testeINCF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)1);
 		mem.set(14, (byte)2);
 		mem.set(13, (byte)3);
 		
 		cpu.setW((byte)00000010);
 		
 		Instrucao i1 = new INCF();
		i1.setup("001010000000"); //f=0 
 		Instrucao i2 = new INCF();
		i2.setup("001010000001"); //f=1 
 		Instrucao i3 = new INCF();
		i3.setup("001010000010"); //f=2 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 1){
 			fail("Erro na 1a Instrucao, esperado: 1 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 2){
 			fail("Erro na 1a Instrucao, esperado: 2 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 3){
 			fail("Erro na 1a Instrucao, esperado: 3 , obtido: "+mem.get(13));
 		}
	}
	
	
	/* Teste SWAPF*/
	
	public void testSWAPF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)26);
 		mem.set(14, (byte)42);
 		mem.set(13, (byte)58);
 		
 		Instrucao i1 = new SWAPF();
		i1.setup("001110100001"); //f=1 invertendo bits 00011010 - 26
 		Instrucao i2 = new SWAPF();
		i2.setup("001110100010"); //f=2 invertendo bits 00101010 - 42
 		Instrucao i3 = new SWAPF();
		i3.setup("001110100011"); //f=3 invertendo bits 00111010 - 58
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 26){
 			fail("Erro na 1a Instrucao, esperado: 26 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 42){
 			fail("Erro na 1a Instrucao, esperado: 42 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 58){
 			fail("Erro na 1a Instrucao, esperado: 58 , obtido: "+mem.get(13));
 		}
	}
	
	/* Teste SUBWF */
	
	public void testSUBWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)6);
 		mem.set(14, (byte)20);
 		mem.set(13, (byte)30);
 		
 		cpu.setW((byte)00000000);
 		
 		Instrucao i1 = new SUBWF();
		i1.setup("0000100000110"); //f=6 
 		Instrucao i2 = new SUBWF();
		i2.setup("0000101010100"); //f=20 
 		Instrucao i3 = new SUBWF();
		i3.setup("0000101011110"); //f=30 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 6){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 20){
 			fail("Erro na 1a Instrucao, esperado: 15 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 30){
 			fail("Erro na 1a Instrucao, esperado: 25 , obtido: "+mem.get(13));
 		}
	}
	
	/* Teste XORWF*/	
	public void testXORWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)0);
 		mem.set(14, (byte)1);
 		mem.set(13, (byte)2);
 		
 		cpu.setW((byte)10111111);
 		
 		Instrucao i1 = new XORWF();
		i1.setup("000110111111"); 
 		Instrucao i2 = new XORWF();
		i2.setup("000110111110");
 		Instrucao i3 = new XORWF();
		i3.setup("000110111101"); 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 1){
 			fail("Erro na 1a Instrucao, esperado: 1 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 2){
 			fail("Erro na 1a Instrucao, esperado: 2 , obtido: "+mem.get(13));
 		}
	}

}
