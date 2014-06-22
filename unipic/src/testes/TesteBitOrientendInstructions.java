package testes;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import unipic.*;
import instrucoes.*;

public class TesteBitOrientendInstructions extends TestCase{
	public void testBCF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)255); // endereco 15 = 1111 1111
		mem.set(14, (byte)1);   // endereco 14 = 0000 0001
		mem.set(13, (byte)128); // endereco 13 = 1000 0000
		
		Instrucao i1 = new BCF();
		i1.setup("010010101111"); // b=5 f=15, resultado = 1110 1111
		
		Instrucao i2 = new BCF();
		i2.setup("010000001110"); // b=0 f=14, resultado = 0000 0000
		
		Instrucao i3 = new BCF();
		i3.setup("010011101101"); // b=7 f=13, resultado = 0000 0000
		
		i1.run(mem, cpu);
		if(mem.get(15) != -33){
			fail("Erro na 1° instrucao, esperado: -33, obtido: "+mem.get(15));
		}
		
		i2.run(mem, cpu);
		if(mem.get(14) != 0){
			fail("Erro na 2° instrucao, esperado: 1, obtido: "+mem.get(14));
		}
		
		i3.run(mem, cpu);
		if(mem.get(13) != 0){
			fail("Erro na 3° instrucao, esperado: 0, obtido: "+mem.get(13));
		}
	}
	
	public void testBSF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0);   // endereco 15 = 0000 0000
		mem.set(14, (byte)254);  // endereco 14 = 1111 1110
		mem.set(13, (byte)127); // endereco 13 = 0111 1111
		
		Instrucao i1 = new BSF();
		i1.setup("010110101111"); // b=5 f=15, resultado = 0001 0000
		
		Instrucao i2 = new BSF();
		i2.setup("010100001110"); // b=0 f=14, resultado = 1111 1111
		
		Instrucao i3 = new BSF();
		i3.setup("010111101101"); // b=7 f=13, resultado = 1111 1111
		
		i1.run(mem, cpu);
		if(mem.get(15) != 32){
			fail("Erro na 1° instrucao, esperado: 16, obtido: "+mem.get(15));
		}
		
		i2.run(mem, cpu);
		if(mem.get(14) != -1){
			fail("Erro na 2° instrucao, esperado: -1, obtido: "+mem.get(14));
		}
		
		i3.run(mem, cpu);
		if(mem.get(13) != -1){
			fail("Erro na 3° instrucao, esperado: -1, obtido: "+mem.get(13));
		}
	}
	
	public void testBTFSC(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		Instrucao inst1 = new BTFSC();
		Instrucao inst2 = new BTFSC();
		Instrucao inst3 = new BTFSC();
		
		mem.set(15, (byte)0);
		mem.set(14, (byte)255);
		
		inst1.setup("011000001111");
		inst2.setup("011000001110");
		
		inst1.run(mem, cpu);
		if(mem.getPCL() != 2){
			fail("A 1° instrucao não incrementou 2x o PCL");
		}
		
		inst2.run(mem, cpu);
		if(mem.getPCL() != 3){
			fail("A 2° instrucao incrementou 2x o PCL");
		}
	}
	
	public void testBTFSS(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		Instrucao inst1 = new BTFSS();
		Instrucao inst2 = new BTFSS();
		Instrucao inst3 = new BTFSS();
		
		mem.set(15, (byte)0);
		mem.set(14, (byte)255);
		
		inst1.setup("011000001111");
		inst2.setup("011000001110");
		
		inst1.run(mem, cpu);
		if(mem.getPCL() != 1){
			fail("A 1° instrucao incrementou 2x o PCL");
		}
		
		inst2.run(mem, cpu);
		if(mem.getPCL() != 3){
			fail("A 2° instrucao não incrementou 2x o PCL");
		}
	}
}
