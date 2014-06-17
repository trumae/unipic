package testes;

import junit.framework.TestCase;

import instrucoes.*;
import unipic.*;

public class TesteByteOrientendInstructions extends TestCase{
	
	public void testANDWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		mem.set(15, (byte)0);
 		cpu.setW((byte)01011001);
 		
 		Instrucao i1 = new ANDWF();
		i1.setup("010100001111"); // d=0 f=15 w=55, resultado = 1001 0000
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 60 , obtido: "+mem.get(15));
 		}
	}
	
	public void testCLRF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)0);	
		
		Instrucao i1 = new CLRF();
 		i1.setup("000000101010");
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
	}
	
	public void testCLRW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)0);	
 		
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
 		
 		Instrucao i1 = new DECFSZ();
 		i1.setup("101100001111");
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 14){
 			fail("Erro na 1a Instrucao, esperado: 14 , obtido: "+mem.get(15));
		}
	}
	
	public void testINCFSZ(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)16);	
 		
 		Instrucao i1 = new DECFSZ();
 		i1.setup("001111001111");
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 16){
 			fail("Erro na 1a Instrucao, esperado: 16 , obtido: "+mem.get(15));
		}
	}
	
	public void testMOVF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		
 		mem.set(15, (byte)15);	
 		
 		Instrucao i1 = new MOVF();
 		i1.setup("001000001111");
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 15){
 			fail("Erro na 1a Instrucao, esperado: 16 , obtido: "+mem.get(15));
		}
	}
	
}
