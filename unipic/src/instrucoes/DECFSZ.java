package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
	
public class DECFSZ extends Instrucao{
	/***
	 *  Inicia a instrucao 
	 * @param comando 0010 11df ffff
	 */
	
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2));
		this.setF(Integer.parseInt(comando.substring(7),2));
	}
	
	public void run(Memoria mem, CPU cpu){
		//Armazena o valor de f
		byte valorEmF = mem.get(this.f);
		//Se o valorEmF for zero, executa a instrucao NOP
		if(valorEmF == 0){
			//Esta instrucao serve apenas para pular um ciclo
				Instrucao nop = new NOP();
				nop.setup("000000000000");
				nop.run(mem, cpu);
				
		} else {
		//Sendo diferente de zero, o valor eh decrementado -1 o valorEmF
			byte resultado = (byte) (valorEmF - 1);
			//Se o valor em D for igual a zero, o resultado eh armazenado em W
			if(this.d==0){
				cpu.setW(resultado);
			} else {
			//Senao o resultado eh armazenado em f
				mem.set(this.f,resultado);
			}
		}
		//Incrementa PCL
		mem.setPCL((byte) (mem.getPCL() + 1));	
	}	
}
