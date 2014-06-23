package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class MOVWF extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * @param comando 0000 001f ffff
	 **/
	@Override
	public void setup(String comando){
		
		setK(Integer.parseInt(comando.substring(7), 2));
	}
	
	/***
	 *  Move o valor do registrador 'W' para o 'F'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		mem.set(this.f, cpu.getW());;
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
