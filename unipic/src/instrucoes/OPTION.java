package instrucoes;

import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class OPTION extends Instrucao {
	Memoria memo = new Memoria();

	@Override
	public void setup(String comando) {

	}

	public void run(Memoria mem, CPU cpu) {
		/**
		 * O conteudo do registrador w de ser carregado no registrador OPTION
		 */
		memo.OPTION = cpu.getW();

		mem.setPCL((byte) (mem.getPCL() + 1));
	}
}
