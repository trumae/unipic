package instrucoes;

import unipic.Instrucao;

public class CLRW extends Instrucao{
private String match = "^000001000000$";
	
	public boolean matcher(String comando){
		return comando.matches(match);
	}
	
	@Override
	public Instrucao getInstrucao(String comando){
		CLRW inst = new CLRW();
		//     ** Vide Pagina 53 do manual da PIC **
		
		return inst;
	}
}
