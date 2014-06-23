package testes;

import static org.junit.Assert.fail;
import instrucoes.IORLW;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;


/**
 * 
 * Teste para a classe IORLW, nele eu
 * passo valores para cada condição 
 * logica(0 e 0; 0 e 1, 1 e 0; 1 e 1)
 * e verifico se a saida é que eu espero
 * 
 * */



public class TesteIORLW{

	@Test
	public void testIORLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
 		
 		// Passando 1 e 1
 		mem.set(15, (byte)0x01);
 		cpu.setW((byte)0x01);
 		
 		Instrucao i1 = new IORLW();
		i1.setup("110100001111"); 
 		
 		i1.run(mem, cpu);
 		
 		if(cpu.getW() != 0x0f){
 			fail("Erro na 1a Instrucao, esperado: 1 , obtido: "+cpu.getW());
 		}
 		
 		// Passando 1 e 0
 		mem.set(15, (byte)0x01);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i2 = new IORLW();
		i2.setup("110100001111"); 
 		
 		i2.run(mem, cpu);
 		
 		if(cpu.getW() != 0x0f){
 			fail("Erro na 2a Instrucao, esperado: 1 , obtido: "+cpu.getW());
 		}
 		
 		
		// Passando 0 e 0
 		mem.set(15, (byte)0x00);
 		cpu.setW((byte)0x00);
 		
 		Instrucao i3 = new IORLW();
		i3.setup("110100001000"); 
 		
 		i3.run(mem, cpu);
 		
 		if(cpu.getW() != 0x08){
 			fail("Erro na 3a Instrucao, esperado: 8 , obtido: "+cpu.getW());
 		}
 		
 		
 		mem.set(15, (byte)0x00);
 		cpu.setW((byte)0x01);
 		
 		Instrucao i4 = new IORLW();
		i4.setup("110100000011"); 
 		
 		i4.run(mem, cpu);
 		
 		if(cpu.getW() != 0x03){
 			fail("Erro na 4a Instrucao, esperado: 3 , obtido: "+cpu.getW());
 		}
	}

}
