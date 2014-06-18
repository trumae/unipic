package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class BCF extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * @param comando 0100 bbbf ffff
	 */
	@Override
	public void setup(String comando){
		setB(Integer.parseInt(comando.substring(4,7),2)); // base binario = inteiro 
		setF(Integer.parseInt(comando.substring(7),2)); // 
	}

	/***
	 *  Bit 'b' no registrador 'f' é zerado
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		// zerando o bit
		// referencia: http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/
		byte dadoEditado = (byte) (mem.get(this.f) & ~( 1 << this.b ));
		
		mem.set(this.f, dadoEditado);
		
		// incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
