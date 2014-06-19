package instrucoes;
import unipic.CPU;
import unipic.Instrucao;
import unipic.Memoria;

public class ANDLW  extends Instrucao{
	@Override
	public void setup(String comando){
			this.setK(Integer.parseInt(comando.substring(5),8)); 
	}
		
	public void run(Memoria mem, CPU cpu){
		
	}
	
}
