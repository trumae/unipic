package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class SUBWF extends Instrucao{
	/***
	 *  Inicia a instru��o 
	 * @param comando 0000 10df ffff
	 */
	@Override
	public void setup(String comando){
		this.setD(Integer.parseInt(comando.substring(6,7),2)); // base binario = inteiro 
		this.setF(Integer.parseInt(comando.substring(7),2)); // 
	}
	
	/***
	 *  Subtrai o registrador 'w' do registrador 'f'
	 *  Se 'd' � zero, o resultado � salvo em 'w', se 'd' � 1, o resultado � salvo em 'f'
	 * @param mem mem�ria a ser alterada
	 * @param cpu serve para usar os registradores do processador
	 */
	public void run(Memoria mem, CPU cpu){
		byte w = cpu.getW();
		byte valorEmF = mem.get(this.f);
		
		byte resultado = (byte) (valorEmF - w);
		
		if(this.d==0){
			cpu.setW(resultado);
		} else {
			mem.set(this.f,resultado);
		}
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}

