package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class MOVF extends Instrucao{
	
	/***
	 *  Inicia a instrucao 
	 * @param comando 0010 00df ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2));
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
		
	public void run(Memoria mem, CPU cpu){
		//Armazena valor de f
		byte valorEmF = mem.get(this.f);
		//Se o valor em D for igual a zero, o resultado da operacao eh armazenado em W
		if(this.d==0){
			cpu.setW(valorEmF);
		} else {
		//Senao o resultado eh armazenado em f
			mem.set(this.f,valorEmF);
		}
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}

	
	
	
	

