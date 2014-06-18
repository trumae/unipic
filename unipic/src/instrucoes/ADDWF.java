package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
/**
 * Classe referente a instrucao ADDWF ...
 */
public class ADDWF extends Instrucao{
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2)); // base binario = inteiro 
		this.setF(Integer.parseInt(comando.substring(7),2)); // 
	}
	
	public void run(Memoria mem, CPU cpu){
		byte w = cpu.getW();
		byte valorEmF = mem.get(this.f);
		
		byte soma = (byte) (w+valorEmF);
		
		if(this.d==0){
			cpu.setW(soma);
		} else {
			mem.set(this.f,soma);
		}
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
	
}
