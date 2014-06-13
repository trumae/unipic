package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class CLRF extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0000 011f ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
	
	public void run(Memoria mem, CPU cpu){
		//Zera o conteudo do registro f indicado
		mem.set(this.f,(byte) 0x00);
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
