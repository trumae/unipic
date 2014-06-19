package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class XORLW extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * @param comando 1111 kkkk kkkk
	 */
	@Override
	public void setup(String comando){
		setK(Integer.parseInt(comando.substring(4),2)); // 
	}
	
	/***
	 *  OU Exclusivo entre o valor de W com o literal k
	 *  O resultado é salvo em 'w'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		// XOR entre w e k
		byte result = (byte) (this.k ^ cpu.getW());
		
		// salva no lugar certo
		cpu.setW(result);
		
		// incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
