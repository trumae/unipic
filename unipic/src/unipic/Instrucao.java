package unipic;

public class Instrucao {
	public Instrucao() throws Exception{
		Clock clock= new Clock();
		int tempo=clock.getTempo();
		//Antes de cada instru��o, este comando dever� ser executado.
		clock.Cronometro(tempo);
	}
}
