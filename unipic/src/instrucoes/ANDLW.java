package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class ANDLW  extends Instrucao{
	@Override
	public void setup(String comando){
			this.setK(Integer.parseInt(comando.substring(4),8)); 
	}
		
	public void run(Memoria mem, CPU cpu){
		byte w = cpu.getW();
		byte and = (byte) (w&k);
		cpu.setW(and);
		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}