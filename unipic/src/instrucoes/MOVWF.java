package instrucoes;
import unipic.Instrucao;

	public class MOVWF extends Instrucao{
		private String match = "^0000001[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			MOVWF inst = new MOVWF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}

	

