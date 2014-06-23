package testes;

import static org.junit.Assert.*;
import instrucoes.ANDLW;
import unipic.CPU;
import unipic.Carregador;
import unipic.Instrucao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;

import unipic.Memoria;
import org.junit.Test;

public class testeCarregador extends Carregador{

	Carregador c = new Carregador();
	@Test
	public void testCaregador() {
		Object caminho;
		// teste da instrução 3
		caminho = c.lerArquivo("C:/Users/Kà.áH/git/unipic/unipic/exemplos/dice.hex");
		String [] cod= {
						":1000100008080008050806083100FF0C3000F0024F",
						":0C000000010A050C6000E001050CE001A5",
						":04000C0000080008E0",
						":10005000B5024306B6021402030EE2013B0A400A4F", 
						":100060004B0A010C660734001602020F43071B0AF5",
						":1000700074006600030066060300010C34001B0ACE",
						":10008000020C6607460A340075007600F7024A0A39",
				};
		// Teste Hexadecimal para Binario
		
		assertEquals("1010", c.hexToBin("A"));
		assertEquals("1011", c.hexToBin("B"));
		assertEquals("1100", c.hexToBin("C"));
		assertEquals("1101", c.hexToBin("D"));
		assertEquals("1110", c.hexToBin("E"));
		assertEquals("1111", c.hexToBin("F"));
		assertEquals("111", c.hexToBin("7"));
		assertEquals("1101", c.hexToBin("8"));
		fail("Erro no carregamento");
		
		// Teste Ler Aquivo
		
		assertEquals(":1000100008080008050806083100FF0C3000F0024F", caminho); //2
		assertEquals(":100000002500140A070EE201090801080B0804087C", caminho); //3
		assertEquals(":100020000F0AF1020D0A0008080C06006700000C18", caminho); //4
		assertEquals(":10003000020075007600130202093200030E26004A", caminho); //5
		assertEquals(":10004000030C0C0932031203040F2600030C0C09E5", caminho); //6
		assertEquals(":10005000B5024306B6021402030EE2013B0A400A4F", caminho); //7
		
		// Testa InverteData
		
		String [] j = inverteData(cod);
		System.out.println(j[0]);

		// Testa Load
		// Não consegui fazer
		//Vector<Instrucao> i = c.load("teste");
		
	}
}


