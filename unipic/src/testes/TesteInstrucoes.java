package testes;

import static org.junit.Assert.*;
import instrucoes.*;

import org.junit.Test;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class TesteInstrucoes {

	
	/**
	 * Nessa classe eu simplesmente seto um valor
	 * para cada condição lógica (0 ou 0; 0 ou 1; 1 ou 1; 1 ou 0)
	 * e verifico se a saida é a esperada, caso não for
	 * eu boto como teste falho
	 * 
	 */
	@Test
	public void testeIORWF() {

		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x00);
		Instrucao i1 = new IORWF();
		i1.setup("000100001111");
		
		// Passando 0 e 0 
		i1.run(mem, cpu);
		if(cpu.getW() != (byte)0x00){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x00);
		Instrucao i2 = new IORWF();
		i2.setup("000100001111");
		
		i2.run(mem, cpu);
		
		// Passando 1 e 0
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 2° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x01);
		Instrucao i3 = new IORWF();
		i3.setup("000100001111");
		
		i3.run(mem, cpu);
		
		// Passando 1 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 3° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x01);
		Instrucao i4 = new IORWF();
		i4.setup("000100001111");
		
		i4.run(mem, cpu);
		
		// Passando 0 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 4° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
	}
	
	
	/**
	 * Nessa classe eu simplesmente seto um valor
	 * para cada condição lógica (0 ou 0; 0 ou 1; 1 ou 1; 1 ou 0)
	 * e verifico se a saida é a esperada, caso não for
	 * eu boto como teste falho
	 * 
	 */
	@Test
	public void testeIORLW() {

		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x00);
		Instrucao i1 = new IORLW();
		i1.setup("000100001111");
		
		i1.run(mem, cpu);
		
		// Passando 0 e 0
		if(cpu.getW() == (byte)0x01){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x00);
		Instrucao i2 = new IORLW();
		i2.setup("000000000001");
		
		i2.run(mem, cpu);
		
		// Passando 0 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 2° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x01);
		Instrucao i3 = new IORLW();
		i3.setup("000100001111");
		
		i3.run(mem, cpu);
		
		// Passando 1 e 1
		if(cpu.getW() != (byte)0x0f){
			fail("Erro na 3° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x01);
		Instrucao i4 = new IORLW();
		i4.setup("000000000001");
		
		i4.run(mem, cpu);
		
		// Passando 0 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 4° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
	}

	
	/**
	 * Nessa classe eu simplesmente seto um valor
	 * para cada condição lógica (0 ou 0; 0 ou 1; 1 ou 1; 1 ou 0)
	 * e verifico se a saida é a esperada, caso não for
	 * eu boto como teste falho
	 * 
	 */
	@Test
	public void testeANDLW() {

		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x00);
		Instrucao i1 = new ANDLW();
		i1.setup("000100001111");
		
		i1.run(mem, cpu);
		
		// Passando 0 e 0
		if(cpu.getW() != (byte)0x00){
			fail("Erro na 1° instrucao, esperado: 0, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x00);
		Instrucao i2 = new ANDLW();
		i2.setup("000100001111");
		
		i2.run(mem, cpu);
		
		// Passando 1 e 0
		if(cpu.getW() != (byte)0x00){
			fail("Erro na 2° instrucao, esperado: 0, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x01);
		
		cpu.setW((byte)0x01);
		Instrucao i3 = new ANDLW();
		i3.setup("000100001111");
		
		i3.run(mem, cpu);
		
		// Passando 1 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 3° instrucao, esperado: 1, obtido: "+cpu.getW());
		}
		
		
		mem.set(15, (byte)0x00);
		
		cpu.setW((byte)0x01);
		Instrucao i4 = new ANDLW();
		i4.setup("000100001111");
		
		i4.run(mem, cpu);
		
		// Passando 0 e 1
		if(cpu.getW() != (byte)0x01){
			fail("Erro na 4° instrucao, esperado: 0, obtido: "+cpu.getW());
		}
	
	}
	@Test
	public void testANDLW() {
		CPU cpu = new CPU();
		// primeiro teste
		Memoria mem = new Memoria();
		// Seta endereco e valor
		mem.set(15, (byte) 0x00);
		// Seta um valor para W, no caso, dois
		cpu.setW((byte) 00000010);

		Instrucao i1 = new ANDLW();
		i1.setup("101000001111"); // k=15 w=2, resultado = 17

		/**
		 * Explicando 101000001111 Identificador da instrucao: 101 O restante é
		 * o valor que você quer dar para K k=15=00001111 w&k = 15 = 17
		 * 
		 * Arrumar o teste para que 0x0 / 1x1 / 1x0/ 0x1
		 * 
		 **/

		i1.run(mem, cpu);
		if (mem.get(0) != 0) {
			fail("Erro na 1a Instrucao, esperado: 0 , obtido: " + mem.get(0));
		}

		// segundo teste

		mem.set(15, (byte) 0x01);

		cpu.setW((byte) 00000110); // w = 0
		Instrucao i2 = new ANDLW();
		i2.setup("101000000111");

		/**
		 * Explicando 101000000111 Identificador da instrucao: 101 w&k = 0
		 **/

		i2.run(mem, cpu);
		if (mem.get(0) != 1) {
			fail("Erro na 1° instrucao, esperado: 0, obtido: " + mem.get(0));
		}

		// terceiro teste

		mem.set(15, (byte) 0x10);

		cpu.setW((byte) 00000100);
		Instrucao i3 = new ANDLW();
		i3.setup("10100001011");

		/**
		 * Explicando 10100001011 Identificador da instrucao: 101 w&k = 0&0 = 0
		 **/

		i3.run(mem, cpu);
		if (mem.get(1) != 0) {
			fail("Erro na 1° instrucao, esperado: 0, obtido: " + mem.get(0));
		}

		// quarto teste

		mem.set(15, (byte) 0x11);

		cpu.setW((byte) 00000100); // w =
		Instrucao i4 = new ANDLW();
		i4.setup("10100001011");

		/**
		 * Explicando 10100001011 Identificador da instrucao: 101 w&k = 4+11 =
		 * 15
		 **/

		i4.run(mem, cpu);
		if (mem.get(1) != 1) {
			fail("Erro na 1° instrucao, esperado: 1, obtido: " + mem.get(1));
		}
	}

	public void testOPTION() {
		CPU cpu = new CPU();
		Memoria mem = new Memoria();
		mem.set(15, (byte) 4);
		// 15 é o tamanho da memoria

		/**
		 * O conteudo do registrador w de ser carregado no registrador OPTION se
		 * eu colocar 5 em w esse 5 tem q ficar no registrador option
		 */

		cpu.setW((byte) 00000100); // w=4
		Instrucao i1 = new OPTION();
		i1.setup("101000001111"); // Identificador da instrucao: 101
		i1.run(mem, cpu);
		if (mem.OPTION != 4) {
			fail("Erro na 1a Instrucao, esperado: 4 , obtido: " + mem.get(0));
		}
	}
}
