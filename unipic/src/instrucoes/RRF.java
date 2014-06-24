package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class RRF extends Instrucao{
	
	/***
	 * 
	 *  Inicia a instrução 
	 * @param comando 0011 00df ffff
	 * 
	 **/
	@Override
	public void setup(String comando){

		setD(Integer.parseInt(comando.substring(6, 7), 2));
		setF(Integer.parseInt(comando.substring(7), 2));
	}
		
	/***
	 * 
	 * O Conteudo de 'F' é deslocado 1 bit
	 * para a direita, se o d for igual a 0,
	 * o resultado é colocado em 'W', senão 
	 * o resultado é colocado de volta em 'F'
	 * Inicia a instrução 
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 * 
	 **/
	public void run(Memoria mem, CPU cpu){
		
		byte resultado = (byte) ((mem.get(this.f) & 0x80) >> 7);
		
		if(this.d !=0){
			
			mem.set(this.f, resultado);
		} else {
			
			cpu.setW(resultado);
		}
		
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}

