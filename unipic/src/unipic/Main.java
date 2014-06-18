package unipic;

import argparser.ArgParser;
import argparser.IntHolder;
import argparser.StringHolder;
import argparser.ArgParseException;
public class Main {
	public static void main(String[] args) {
		StringHolder fileName = new StringHolder();//armazena o caminho do arquivo .hex
		IntHolder tempo= new IntHolder(1000);
		int numCiclos = 1000; //armazena o numero de ciclos, valor 'padrao' 1000
		
		try{
			ArgParser parser = new ArgParser("UNIPIC - Simulador de Microcontrolador Microchip PIC");
			
			//descricao de parametros
			parser.addOption ("-file %s #nome do arquivo a ser executado", fileName);
			
			//Adiciona opcao para alterar o tempo do Clock
			parser.addOption("-clockTime %h #periodo do clock", tempo);
			
			//Numero de Ciclos
			parser.addOption("-numCycles %h #numero de ciclos", numCiclos);
			
			parser.matchAllArgs (args);
			
			if(fileName.value == null){
				throw new ArgParseException("-file","nome do arquivo nao informado");
			}
			
			//Cria um objeto, e chama o metodo setTempo() passando o valor armazenado em time
			Clock clock=new Clock();
			clock.setTempo(Integer.parseInt(tempo.toString()));
		}
		catch(ArgParseException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		
		fileName.value = "exemplos/dice.hex";
		System.out.println("UNIPIC - Simulador de Microcontrolador Microchip PIC");
		
		PIC pic = new PIC();
		pic.loadProgram(fileName.value);
		pic.run(numCiclos);
	}

}
