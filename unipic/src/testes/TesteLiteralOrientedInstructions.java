package testes;

import static org.junit.Assert.*;
import instrucoes.BCF;
import junit.framework.TestCase;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
import instrucoes.*;

public class TesteLiteralOrientedInstructions extends TestCase{
	
	public void testeXORLW(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		cpu.setW((byte)1);
		
		Instrucao i1 = new XORLW();
		i1.setup("111100000001"); // k=1, resultado esperado: w=0
		i1.run(mem, cpu);
		if(cpu.getW() != 0){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+cpu.getW());
		}

		cpu.setW((byte)1);
		
		Instrucao i2 = new XORLW();
		i2.setup("111100000000"); // k=0, resultado esperado: w=1
		i2.run(mem, cpu);
		if(cpu.getW() != 1){
			fail("Erro na 2° instrucao, esperado: 1, obtido: "+mem.get(14));
		}

		cpu.setW((byte)0);
		
		Instrucao i3 = new XORLW();
		i3.setup("111100000001"); // k=1, resultado esperado: w=1
		i3.run(mem, cpu);
		if(cpu.getW() != 1){
			fail("Erro na 3° instrucao, esperado: 1, obtido: "+cpu.getW());
		}

		cpu.setW((byte)0);
		
		Instrucao i4 = new XORLW();
		i4.setup("111100000000"); // k=0, resultado esperado: w=0
		i4.run(mem, cpu);
		if(cpu.getW() != 0){
			fail("Erro na 4° instrucao, esperado: 0, obtido: "+mem.get(12));
		}
	}
	
	public void testeANDLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)12);
 		mem.set(14, (byte)22);
 		mem.set(13, (byte)32);
 		//Seta o valor de w. w = 12
 		cpu.setW((byte)00001100);
 		
 		Instrucao i1 = new ANDLW();
		i1.setup("111011000000"); //f=0 
 		Instrucao i2 = new ANDLW();
		i2.setup("111011001010"); //f=10 
 		Instrucao i3 = new ANDLW();
		i3.setup("111011010100"); //f=20 
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 12){
 			fail("Erro na 1a Instrucao, esperado: 12 , obtido: "+mem.get(15));
 		}
 		
 		i2.run(mem, cpu);
 		if(mem.get(14) != 22){
 			fail("Erro na 1a Instrucao, esperado: 22 , obtido: "+mem.get(14));
 		}
 		
 		i1.run(mem, cpu);
 		if(mem.get(13) != 32){
 			fail("Erro na 1a Instrucao, esperado: 32 , obtido: "+mem.get(13));
 		}
	}
	
	public void testeGOTO(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)15);
 		
 		Instrucao i1 = new GOTO();
		i1.setup("101000001111");
 		
 		i1.run(mem, cpu);
 		if(mem.getPCL() != 15){
 			fail("Erro na 1a Instrucao, esperado: 15 , obtido: "+mem.getPCL());
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

	
	public void testeRETLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)35);
 		mem.set(14, (byte)127);
 		mem.set(13, (byte)0);
 		
 		Instrucao i1 = new RETLW();
		i1.setup("100000100011"); //k=35 
 		Instrucao i2 = new MOVLW();
		i2.setup("110001111111"); //k=127 
 		Instrucao i3 = new MOVLW();
		i3.setup("110000000000"); //k=0 
 		
 		i1.run(mem, cpu);
 		if(cpu.getW() != 35){
 			fail("Erro na 1a Instrucao, esperado: 35 , obtido: "+cpu.getW());
 		}
 		
 		i2.run(mem, cpu);
 		if(cpu.getW() != 127){
 			fail("Erro na 1a Instrucao, esperado: 127 , obtido: "+cpu.getW());
 		}
 		
 		i3.run(mem, cpu);
 		if(cpu.getW() != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+cpu.getW());
 		}
	}
}
