package unipic;

public class PIC {
	private Flash flash;
	private RAM ram;
	private CPU cpu;
	private Pino pinos[] = new Pino[6];
	private WatchDog watchDog;

	/**
	 * Executa o programa carregado
	 */
	public void run(int numCiclos) {
		ram.reset();
		try {
			for(int i = 0; i < numCiclos; i++)
				step();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Carrega o programa que sera executado
	 * 
	 * @param string
	 *            Nome do arquivo com o programa
	 */
	public void loadProgram(String filename) {
		try {
			Carregador c = new Carregador();
			flash.programa = c.load(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void step() {
		System.out.println("Passo");
		Instrucao instr = flash.programa.elementAt(ram.getPCL());
		instr.run(ram, cpu);
	}

}
