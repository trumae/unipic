package instrucoes;
import unipic.Instrucao;

public class ANDWF extends Instrucao{
	private String match = "^000101[0|1]{1}[0|1]{5}$";
	
	public boolean matcher(String comando){
		return comando.matches(match);
	}
	
	@Override
	public Instrucao getInstrucao(String comando){
		ANDWF inst = new ANDWF();
		//     ** Vide Pagina 54 do manual da PIC **
		
		return inst;
	}
		
}
