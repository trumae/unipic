package testes;

import static org.junit.Assert.fail;

import org.junit.Test;

import instrucoes.IORWF;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;


/**
 * 
 * Teste para a classe IORWF, nele eu
 * passo valores para cada condição 
 * logica(0 e 0; 0 e 1, 1 e 0; 1 e 1)
 * e verifico se a saida é que eu espero
 * 
 * */

public class TesteIORWF {

	@Test
	public void testIORWF(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		// Passando 1 e 1
 		mem.set(15, (byte)0x01);
 		cpu.setW((byte)0x01);
 		
 		Instrucao i1 = new IORWF();
		i1.setup("010100001111"); 
 		
 		i1.run(mem, cpu);
 		
 		if(mem.get(15) != 0x01){
 			fail("Erro na 1a Instrucao, esperado: 1 , obtido: "+mem.get(15));
 		}
 		
 		// Passando 1 e 0
 		mem.set(15, (byte)0x01);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i2 = new IORWF();
		i2.setup("010100001111"); 
 		
 		i2.run(mem, cpu);
 		
 		if(mem.get(15) != 0x01){
 			fail("Erro na 2a Instrucao, esperado: 1 , obtido: "+mem.get(15));
 		}
 		
 		
		// Passando 0 e 0
 		mem.set(15, (byte)0x00);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i3 = new IORWF();
		i3.setup("000100001111"); 
 		
 		i3.run(mem, cpu);
 		
 		if(mem.get(15) != 0x00){
 			fail("Erro na 3a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
 		
 		
 		mem.set(15, (byte)0x00);
 		cpu.setW((byte)0x01);
 		
 		Instrucao i4 = new IORWF();
		i4.setup("010100001111"); 
 		
 		i4.run(mem, cpu);
 		
 		if(mem.get(15) != 0x00){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(15));
 		}
	}
}


