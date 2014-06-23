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
}
