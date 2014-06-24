
package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class GOTO extends Instrucao{
	
	/***
	 *  Inicia a instrucao 
	 * @param comando 101k kkkk kkkk
	 */
	
	@Override
	public void setup(String comando){
		this.setK(Integer.parseInt(comando.substring(3),2));
	}
	
	public void run(Memoria mem, CPU cpu){
		//Instrucao de dois ciclos, incrementando um antes de setar o endereco
		mem.setPCL((byte) (mem.getPCL() + 1));
		//O endereco do PC é alterado para o que foi passado junto com a instrucao
		mem.setPCL((byte) (mem.get(this.k)));
		//Depois desta linha o PC passa a rodar do endereco passado
	}
}
	