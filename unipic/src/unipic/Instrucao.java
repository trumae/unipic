package unipic;

public class Instrucao {
	public Instrucao() throws Exception{
		Clock clock= new Clock();
		int tempo=clock.getTempo();
		//Antes de cada instrução, este comando deverá ser executado.
		clock.Cronometro(tempo);
	}
}
