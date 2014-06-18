package testes;

import static org.junit.Assert.*;
import instrucoes.BCF;
import junit.framework.TestCase;

import org.junit.Test;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
import instrucoes.*;

public class TesteByteOrientedInstructions extends TestCase{
	
	public void testeXORWF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)1); 
		mem.set(14, (byte)0);
		mem.set(13, (byte)1);
		mem.set(12, (byte)0);
		
		cpu.setW((byte)1);
		
		Instrucao i1 = new XORWF();
		i1.setup("000110001111"); // d=0 f=15, resultado esperado: w=0
		i1.run(mem, cpu);
		if(cpu.getW() != 0){
			fail("Erro na 1° instrucao, esperado: w=0, obtido: "+cpu.getW());
		}

		cpu.setW((byte)1);
		
		Instrucao i2 = new XORWF();
		i2.setup("000110101110"); // d=1 f=14, resultado esperado: f=1
		i2.run(mem, cpu);
		if(mem.get(14) != 1){
			fail("Erro na 2° instrucao, esperado: f=1, obtido: "+mem.get(14));
		}

		cpu.setW((byte)0);
		
		Instrucao i3 = new XORWF();
		i3.setup("000110001101"); // d=0 f=13, resultado esperado: w=1
		i3.run(mem, cpu);
		if(cpu.getW() != 1){
			fail("Erro na 3° instrucao, esperado: w=1, obtido: "+cpu.getW());
		}

		cpu.setW((byte)0);
		
		Instrucao i4 = new XORWF();
		i4.setup("000110101100"); // d=1 f=12, resultado esperado: f=0
		i4.run(mem, cpu);
		if(mem.get(12) != 0){
			fail("Erro na 4° instrucao, esperado: f=0, obtido: "+mem.get(12));
		}
	}
	
	public void testeSWAPF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)0x0f); 
		mem.set(14, (byte)0xf0);
		mem.set(13, (byte)0x39);
		mem.set(12, (byte)0x93);
		
		Instrucao i1 = new SWAPF();
		i1.setup("001110001111"); // d=0 f=15, resultado esperado: w=f0
		i1.run(mem, cpu);
		if(cpu.getW() != (byte)0xf0){
			fail("Erro na 1° instrucao, esperado: w=0xf0, obtido: "+cpu.getW());
		}
		
		Instrucao i2 = new SWAPF();
		i2.setup("001110001110"); // d=0 f=14, resultado esperado: w=0f
		i2.run(mem, cpu);
		if(cpu.getW() != (byte)0x0f){
			fail("Erro na 2° instrucao, esperado: w=0x0f, obtido: "+cpu.getW());
		}
		
		Instrucao i3 = new SWAPF();
		i3.setup("001110001101"); // d=0 f=13, resultado esperado: w=93
		i3.run(mem, cpu);
		if(cpu.getW() != (byte)0x93){
			fail("Erro na 3° instrucao, esperado: w=0x93, obtido: "+cpu.getW());
		}
		
		Instrucao i4 = new SWAPF();
		i4.setup("001110001100"); // d=0 f=12, resultado esperado: w=39
		i4.run(mem, cpu);
		if(cpu.getW() != (byte)0x39){
			fail("Erro na 4° instrucao, esperado: w=0x39, obtido: "+cpu.getW());
		}
	}
	
	public void testeSUBWF(){
		Memoria mem = new Memoria();
		CPU cpu = new CPU();
		
		mem.set(15, (byte)10); 
		mem.set(14, (byte)20);
		
		cpu.setW((byte)5);
		
		Instrucao i1 = new SUBWF();
		i1.setup("000110001111"); // d=0 f=15, resultado esperado: w=5
		i1.run(mem, cpu);
		if(cpu.getW() != (byte)5){
			fail("Erro na 1° instrucao, esperado: w=5, obtido: "+cpu.getW());
		}

		cpu.setW((byte)50);
		
		Instrucao i2 = new SUBWF();
		i2.setup("000110101110"); // d=1 f=14, resultado esperado: f=-30
		i2.run(mem, cpu);
		if(mem.get(14) != (byte)-30){
			fail("Erro na 2° instrucao, esperado: f=-30, obtido: "+mem.get(14));
		}
	}
}
