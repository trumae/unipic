package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class IORLW  extends Instrucao{
	
	/***
	 *  Inicia a instrução 
	 * @param comando 1101 kkkk kkkk
	 **/
	@Override
	public void setup(String comando){
		
		setK(Integer.parseInt(comando.substring(4), 2));
	}
	
	/***
	 *  Faco um operacao 'OR' entre o 'k' e o 'W'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		
		cpu.setW((byte) (cpu.getW() | this.k));
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
