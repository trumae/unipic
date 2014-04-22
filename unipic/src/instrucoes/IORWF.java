package instrucoes;
import unipic.Instrucao;

	public class IORWF extends Instrucao{
		private String match = "^000100[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			IORWF inst = new IORWF();
			//     ** Vide Pagina 53 do manual da PIC **
			
			return inst;
		}
			
	}

