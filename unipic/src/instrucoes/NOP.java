package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class NOP extends Instrucao{
	
	/***
	 * 
	 *  Inicia a instrucao 
	 * @param comando 0000 0000 0000
	 * 
	 **/
	@Override
	public void setup(String comando){
	}
	
	/***
	 * 
	 * Esse método faz simplesmente nada =D
	 * aqui, só incremento o PCL
	 * @param mem memoria a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 * 
	 */
	public void run(Memoria mem, CPU cpu){
		
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}




