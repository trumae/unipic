package testes;

import static org.junit.Assert.*;
import instrucoes.*;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class TesteInstrucoes {

	@Test

	public void testANDLW(){
		Memoria mem = new Memoria();
 		CPU cpu = new CPU();
		//Seta endereco e valor
 		mem.set(15, (byte)17);
		//Seta um valor para W, no caso, dois
 		cpu.setW((byte)00000010); 
 		
 		Instrucao i1 = new ANDLW();
		i1.setup("101000001111"); // k=15 w=2, resultado = 17
		
		/**
		* Explicando 101000001111
		* Identificador da instrucao: 101
		* O restante é o valor que você quer dar para K
		* k=15=00001111
		* w&k = 2+15 = 17
		**/
 		
 		i1.run(mem, cpu);
 		if(mem.get(15) != 17){
 			fail("Erro na 1a Instrucao, esperado: 17 , obtido: "+mem.get(15));
 		}
 		
 		// segundo teste
 		
 		mem.set(7, (byte)13);
		
		cpu.setW((byte)00000110);
		Instrucao i2 = new ANDLW();
		i2.setup("101000000111");
		
		/**
		* Explicando 101000000111
		* Identificador da instrucao: 101
		* O restante é o valor que você quer dar para K
		* k=7=00000111
		* w&k = 6+7 = 13
		**/
		
		i2.run(mem, cpu);
		if(mem.get(7) != 13){
			fail("Erro na 1° instrucao, esperado: 13, obtido: "+mem.get(13));
		}
		
		// terceiro teste
		
		mem.set(1, (byte)15);
		
		cpu.setW((byte)00000100);
		Instrucao i3 = new ANDLW();
		i3.setup("10100001011");
		
		/**
		* Explicando 10100001011
		* Identificador da instrucao: 101
		* O restante é o valor que você quer dar para K
		* k=11=00001011
		* w&k = 4+11 = 15
		**/
		
		i3.run(mem, cpu);
		if(mem.get(11) != 15){
			fail("Erro na 1° instrucao, esperado: 13, obtido: "+mem.get(15));
		}
		
	}
	
	
}