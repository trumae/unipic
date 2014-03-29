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
	public void run() {
		
	}

	/**
	 * Carrega o programa que sera executado 
	 * @param string Nome do arquivo com o programa
	 */
	public void loadProgram(String string) {
		
	}

	public void step() {
		// TODO Auto-generated method stub
		System.out.println("Passo");
	}

}
