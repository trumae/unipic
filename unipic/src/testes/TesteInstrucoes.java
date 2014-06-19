package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import instrucoes.*;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class TesteInstrucoes {
	Memoria mem = new Memoria();
	CPU cpu = new CPU();
	@Test

	public void testANDLW(){
		
		// primeiro teste
		
		
		//Seta endereco e valor
 		mem.set(15, (byte)0x00);
		//Seta um valor para W, no caso, dois
 		cpu.setW((byte)00000010); 
 		
 		Instrucao i1 = new ANDLW();
		i1.setup("101000001111"); // k=15 w=2, resultado = 17
		
		/**
		* Explicando 101000001111
		* Identificador da instrucao: 101
		* O restante é o valor que você quer dar para K
		* k=15=00001111
		* w&k = 15 = 17
		* 
		* Arrumar o teste para que 0x0 / 1x1  / 1x0/  0x1 
		* 
		**/
 		
 		i1.run(mem, cpu);
 		if(mem.get(0) != 0){
 			fail("Erro na 1a Instrucao, esperado: 0 , obtido: "+mem.get(0));
 		}
 		
 		// segundo teste
 		
 		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)00000110); // w = 0
		Instrucao i2 = new ANDLW();
		i2.setup("101000000111");
		
		/**
		* Explicando 101000000111
		* Identificador da instrucao: 101
		* w&k = 0
		**/
		
		i2.run(mem, cpu);
		if(mem.get(0) != 1){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+mem.get(0));
		}
		
		// terceiro teste
		
		mem.set(15, (byte)0x10);
		
		cpu.setW((byte)00000100);
		Instrucao i3 = new ANDLW();
		i3.setup("10100001011");
		
		/**
		* Explicando 10100001011
		* Identificador da instrucao: 101
		* w&k = 0&0 = 0
		**/
		
		i3.run(mem, cpu);
		if(mem.get(1) != 0){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+mem.get(0));
		}
		
		// quarto teste
		
				mem.set(15, (byte)0x11);
				
				cpu.setW((byte)00000100); // w = 
				Instrucao i4 = new ANDLW();
				i4.setup("10100001011");
				
				/**
				* Explicando 10100001011
				* Identificador da instrucao: 101
				* w&k = 4+11 = 15
				**/
				
				i4.run(mem, cpu);
				if(mem.get(1) != 1){
					fail("Erro na 1° instrucao, esperado: 1, obtido: "+mem.get(1));
				}
	}
	
	public void testOPTION(){
		mem.set(15, (byte)4);
		// 15 é o tamanho da memoria
		
		/** O conteudo do registrador w
		 * de ser carregado
		 * no registrador OPTION 
		 * se eu colocar 5 em w esse 5 tem q ficar no registrador option  
		 */
		
 		cpu.setW((byte)00000100); 	// w=4
 		Instrucao i1 = new OPTION();
		i1.setup("101000001111"); // Identificador da instrucao: 101
		i1.run(mem, cpu);
 		if(mem.OPTION != 4){
 			fail("Erro na 1a Instrucao, esperado: 4 , obtido: "+mem.get(0));
 		}
	}
}