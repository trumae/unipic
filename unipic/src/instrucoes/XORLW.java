package instrucoes;
import unipic.Instrucao;

	public class XORLW extends Instrucao{
		private String match = "^1111[0|1]{8}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			XORLW inst = new XORLW();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	
}
