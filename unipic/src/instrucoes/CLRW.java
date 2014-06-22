package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class CLRW extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0000 0100 0000
	 */
	@Override
	public void setup(String comando) {
		
	}
	
	public void run(Memoria mem, CPU cpu){
		//Zera o conteudo de W
		cpu.setW((byte) 0x00);
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
	
}
