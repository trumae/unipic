package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;
		
public class INCF extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * comando 0010 10df ffff
	 */
	@Override
	public void setup(String comando){
		setD(Integer.parseInt(comando.substring(6,7),2));
		setF(Integer.parseInt(comando.substring(7),2)); 
	}

	/***
	 *  Os conteúdos do registro 'f' são incrementados
	 *  Se o bit 'd' é '0', o resultado é colocado no registro 'W'
	 *  Se o bit 'd' é '1', o resultado é colocado de volta no registro 'f'
	 */
	public void run(Memoria mem, CPU cpu){
		 
		byte novoF = mem.get(f);
		novoF ++;
		mem.set(f,novoF);
		
		if (this.d == 0){			
			cpu.setW(novoF);			
		}
		
		else {			
			mem.set(f,novoF);			
		}
			
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}