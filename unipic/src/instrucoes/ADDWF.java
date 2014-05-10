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
		int w = CPU.getW();
		int valorEmF = Memoria.get(this.f);
		
		int soma = w+valorEmF;
		
		if(this.d==0){
			CPU.setW(soma);
		}
		else{
			Memoria.set(this.f,soma);
		}
	}
	
}
