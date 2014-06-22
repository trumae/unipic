package testes;

import org.junit.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import unipic.Carregador;


public class CarregadorTeste extends TestCase{
	Carregador C;
	
	@Before
	public void setUp() throws Exception {
		C = new Carregador();
	}

	@Test
	public void testHexToBin() {
		assertEquals("1111", C.hexToBin("F"));		
	}

	@Test
	public void testLoad() {
		
	}

	@Test
	public void testMain() {
	}
	
	@Test
	public void testlerArquivo(){
		String  [] resultado = {
				":020000040000FA",
				":0C000000010A050C6000E001050CE001A5",
				":04000C0000080008E0",
				":00000001FF"
				};
		Assert.assertArrayEquals(resultado, C.lerArquivo("C:\\Users\\Thiago\\MPLABXProjects\\Teste.X\\dist\\default\\production\\Teste.X.production.hex"));
	}
	
	@Test
	public void inverteData(){
		
	}

}
