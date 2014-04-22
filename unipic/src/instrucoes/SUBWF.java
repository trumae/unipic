package instrucoes;
import unipic.Instrucao;

	public class SUBWF extends Instrucao{
		private String match = "^000010[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			SUBWF inst = new SUBWF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}

