package instrucoes;
import unipic.Instrucao;

	public class INCFSZ extends Instrucao{
		private String match = "^001111[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			INCFSZ inst = new INCFSZ();
			//     ** Vide Pagina 53 do manual da PIC **
			
			return inst;
		}
			
	}

