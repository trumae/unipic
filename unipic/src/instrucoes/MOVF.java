package instrucoes;
import unipic.Instrucao;

	public class MOVF extends Instrucao{
		private String match = "^001000[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			MOVF inst = new MOVF();
			//     ** Vide Pagina 53 do manual da PIC **
			
			return inst;
		}
			
	}

	
	
	
	

