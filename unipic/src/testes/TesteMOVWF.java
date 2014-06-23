package testes;

import static org.junit.Assert.fail;
import instrucoes.MOVWF;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class TesteMOVWF {

	@Test
	public void testIORLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		mem.set(15, (byte)0x01);
 		cpu.setW((byte)0x01);
 		
 		Instrucao i1 = new MOVWF();
		i1.setup("000000101111"); 
 		
 		i1.run(mem, cpu);
 		
 		if(mem.get(15) != 0x01){
 			
 			fail("Erro na 1a Instrucao, esperado: 1 , obtido: "+mem.get(15));
 		}
 		

 		mem.set(15, (byte)0x0f);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i2 = new MOVWF();
		i2.setup("000000101111"); 
 		
 		i2.run(mem, cpu);
 		
 		if(mem.get(15) != 0x0f){
 			fail("Erro na 2a Instrucao, esperado: 0x0f , obtido: "+mem.get(15));
 		}
 		
 		
 		mem.set(15, (byte)0x0f);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i3 = new MOVWF();
		i3.setup("000000101111"); 
 		
 		i3.run(mem, cpu);
 		
 		if(mem.get(15) != 0x0f){
 			fail("Erro na 2a Instrucao, esperado: 0x0f , obtido: "+mem.get(15));
 		}
 		
 		
 		mem.set(15, (byte)0x00);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i4 = new MOVWF();
		i4.setup("000000101111"); 
 		
 		i4.run(mem, cpu);
 		
 		if(mem.get(15) != 0x00){
 			fail("Erro na 2a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
	}

}
