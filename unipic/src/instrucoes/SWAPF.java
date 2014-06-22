package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class SWAPF extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * @param comando 0011 10df ffff
	 */
	@Override
	public void setup(String comando){
		setD(Integer.parseInt(comando.substring(6,7),2)); // base binario = inteiro 
		setF(Integer.parseInt(comando.substring(7),2)); // 
	}
	
	/***
	 *  As partes superiores e inferiores do registrador 'f' são trocadas.
	 *  Se 'd' é zero, o resultado é salvo em 'w', se 'd' é 1, o resultado é salvo em 'f'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		//inverte
		byte lower = (byte) ((mem.get(this.f) & 0x0f) << 4);
		byte upper = (byte) ((mem.get(this.f) & 0xf0) >> 4);
		
		byte result = (byte) (lower | upper);
		
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
