package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class MOVLW extends Instrucao{
	@Override
	public void setup(String comando){
		
		/***
		 *  Inicia a instrução 
		 * @param comando 1100 kkkk kkkk
		 **/
		setK(Integer.parseInt(comando.substring(4), 2));
	}
		
	/***
	 *  O literal 'k' de 8 bits é carregado no registrador 'W'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){		
		cpu.setW((byte) this.k);
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
