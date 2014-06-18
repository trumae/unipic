package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class BTFSS extends Instrucao{
	/***
	 *  Inicia a instru��o 
	 * @param comando 0111 bbbf ffff
	 */
	@Override
	public void setup(String comando){
		setB(Integer.parseInt(comando.substring(4,7),2)); // base binario = inteiro 
		setF(Integer.parseInt(comando.substring(7),2)); // 
	}

	/***
	 *  Se o bit 'b' no registrador 'f' � '1', ent�o a pr�xima instru��o � ignorada.
	 *  Se o bit 'b' � '1', ent�o a pr�xima instru��o anexada durante o processo de
	 *  execu��o de instru��es atual � descartada e um NOP � executado em seu lugar,
	 *  fazendo desta uma instru��o de 2 ciclos.
	 * @param mem mem�ria a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		// variavel no formato 000x 000 que servir� par pegar o bit 'b' do 'f'
		byte procurador = (byte) (0 | (1 << this.b));
		
		// pega o bit 'procurador' em f
		byte bitProcurado = (byte) (mem.get(this.f) & procurador);
		
		// se o bit for zero, executa um NOP
		if(bitProcurado != 0){
			Instrucao nop = new NOP();
			nop.setup("000000000000");
			nop.run(mem, cpu);
		}
		
		// incrementa o PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
