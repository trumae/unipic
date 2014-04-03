package instrucoes;
import unipic.Instrucao;
/**
 * Classe referente a instrucao ADDWF ...
 */
public class ADDWF extends Instrucao{
	private String match = "^000111[0|1]{6}$";
	
	@Override
	public boolean matcher(String comando){
		return comando.matches(match);
	}
	
	@Override
	public Instrucao getInstrucao(String comando){
		ADDWF inst = new ADDWF();
		inst.setD(Integer.parseInt(comando.substring(6,7),2));
		inst.setF(Integer.parseInt(comando.substring(7),2));
		
		return inst;
	}
}
