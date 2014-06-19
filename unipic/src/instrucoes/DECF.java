package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class DECF extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0000 11df ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2));
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
	
	public void run(Memoria mem, CPU cpu){
		//Armazena valor d f
		byte valorEmF = mem.get(this.f);
		//Decrementa -1 o valor armazenado em f
		byte resultado = (byte) (valorEmF - 1);
		
		//Se o valor em D for igual a zero, o resultado eh armazenado em W
		if(this.d==0){
			cpu.setW(resultado);
		} else {
		//Senao o resultado eh armazenado em f
			mem.set(this.f,resultado);
		}
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
