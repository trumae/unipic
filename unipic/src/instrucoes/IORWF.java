package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class IORWF extends Instrucao{
	
	/***
	 * 
	 *  Inicia a instrução 
	 * @param comando 0001 00df ffff
	 * 
	 **/
	@Override
	public void setup(String comando){
		
		setD(Integer.parseInt(comando.substring(6,7), 2));
		setF(Integer.parseInt(comando.substring(7), 2));
	}
		
	/***
	 * 
	 *  Faco um operacao 'OR' entre o 'W' e o 'F'
	 *  se o resultado da operacao for 0, seto resultado
	 *  em 'W', senao seto em 'F'
	 * @param mem memória a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 * 
	 */
	public void run(Memoria mem, CPU cpu){
		
		byte resultado = ((byte) (cpu.getW() | mem.get(this.f)));
	
		if(this.d==0){
			
			cpu.setW(resultado);
		} else {
			
			mem.set(this.f, resultado);
		}
		
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}

