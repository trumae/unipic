package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class RLF extends Instrucao{
	/***
	 *  Inicia a instrução 
	 * comando 0011 01df ffff
	 */
	@Override
	public void setup(String comando){
		setD(Integer.parseInt(comando.substring(6,7),2));
		setF(Integer.parseInt(comando.substring(7),2)); 
	}

	/***
	 *  Os conteudos do registo 'f' sao rodados um bit para a esquerda atraves flag Carry. 
	 *  Se 'd' e '0 ', o resultado e colocada no registo W. 
	 *  Se 'd' e '1 ', o resultado e armazenado de volta no registro 'f'.
	 */
	public void run(Memoria mem, CPU cpu){
		 
		byte left = (byte) ((mem.get(this.f)) << 7);
		mem.set(f,left);
		
		if (this.d == 0){			
			cpu.setW(left);			
		}
		
		else {			
			mem.set(f,left);			
		}
			
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
