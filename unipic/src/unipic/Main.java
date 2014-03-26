package unipic;

import argparser.ArgParser;
import argparser.StringHolder;
import argparser.ArgParseException;
public class Main {
   
	public static void main(String[] args) {
		StringHolder fileName = new StringHolder();//armazena o caminho do arquivo .hex

		int time=1000;
		
		try{
			ArgParser parser = new ArgParser("UNIPIC - Simulador de Microcontrolador Microchip PIC");
			
			//descricao de parametros
			parser.addOption ("-file %s #nome do arquivo a ser executado", fileName);
			
			//Adiciona op��o para alterar o tempo do Clock
			parser.addOption("-time %h #ciclo do clock", time);
			
			parser.matchAllArgs (args);
			
			if(fileName.value == null){
				throw new ArgParseException("-file","nome do arquivo n�o informado");
			}
			
			//Cria um objeto, e chama o m�todo setTempo() passando o valor armazenado em time
			Clock clock=new Clock();
			clock.setTempo(time);
		}
		catch(ArgParseException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println("UNIPIC - Simulador de Microcontrolador Microchip PIC");
		
		PIC pic = new PIC();
		pic.loadProgram(fileName.value);
		pic.run();
	}

}
