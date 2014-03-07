package unipic;

public class Main {

	public static void main(String[] args) {
		System.out.println("UNIPIC - Simulador de Microcontrolador Microchip PIC");
		
		PIC pic = new PIC();
		pic.loadProgram("testes.hex");
		pic.run();
	}

}
