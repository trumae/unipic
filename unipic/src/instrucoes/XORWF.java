package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class XORWF extends Instrucao{
	/***
	 *  Inicia a instru��o 
	 * @param comando 0001 10df ffff
	 */
	@Override
	public void setup(String comando){
		setD(Integer.parseInt(comando.substring(6,7),2)); // base binario = inteiro 
		setF(Integer.parseInt(comando.substring(7),2)); // 
	}
	
	/***
	 *  OU Exclusivo entre o valor de W com o valor de F
	 *  Se 'd' � zero, o resultado � salvo em 'w', se 'd' � 1, o resultado � salvo em 'f'
	 * @param mem mem�ria a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		// XOR entre w e f
		byte result = (byte) (mem.get(this.f) ^ cpu.getW());
		
		// salva no lugar certo
		if(this.d == 0){
			cpu.setW(result);
		}
		else{
			mem.set(this.f, result);
		}
		
		// incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
