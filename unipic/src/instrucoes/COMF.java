package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class COMF extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0010 01df ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2));
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
		
	public void run(Memoria mem, CPU cpu){
		//Armazena valor de f
		byte valorEmF = mem.get(this.f);
		//Os bits do registro f sao complementados
		byte complemento = (byte) (~valorEmF & 0xFF);
		
		//Se o valor em D for igual a zero, o resultado eh armazenado em W
		if(this.d==0){
			cpu.setW(complemento);
		} else {
		//Senao o resultado eh armazenado em f
			mem.set(this.f,complemento);
		}
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}

	

