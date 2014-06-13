package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class ANDWF extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0001 01df ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2));
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
		
	public void run(Memoria mem, CPU cpu){
		//Armazena valor de W
		byte w = cpu.getW();
		//Armazena valor de f
		byte valorEmF = mem.get(this.f);
		
		//Realiza uma operacao logica AND entre W e f
		byte and = (byte) (w & valorEmF);
		
		//Se o valor em D for igual a zero, o resultado da operacao eh armazenado em W
		if(this.d==0){
			cpu.setW(and);
		} else {
		//Senao o resultado eh armazenado em f
			mem.set(this.f,and);
		}
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
