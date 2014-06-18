package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class RETLW extends Instrucao{
	
	/***
	 *  Inicia a instru��o 
	 * @param comando 1000 kkkk kkkk
	 **/
	@Override
	public void setup(String comando){
		
		setK(Integer.parseInt(comando.substring(4), 2));
	}
	
	/***
	 *  O registrador 'W' � carregado em um literal 'k' de 8 bits
	 * @param mem mem�ria a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		cpu.setW((byte) this.k);
		mem.setPCL((byte) (0));
	}
}