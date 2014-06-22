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
