package instrucoes;
import unipic.Instrucao;

public class CLRF extends Instrucao{
	
private String match = "^0000011[0|1]{5}$";
	
	public boolean matcher(String comando){
		return comando.matches(match);
	}
	
	@Override
	public Instrucao getInstrucao(String comando){
		CLRF inst = new CLRF();
		//     ** Vide Pagina 53 do manual da PIC **
		
		return inst;
	}
		
	
	
	
	
	
	
	

}
