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
	
	public void run(){
		byte w = CPU.getW();
		byte valorEmF = Memoria.get(this.f);
		
		byte soma = (byte) (w+valorEmF);
		
		if(this.d==0){
			CPU.setW(soma);
		}
		else{
			Memoria.set(this.f,soma);
		}
	}
	
}
