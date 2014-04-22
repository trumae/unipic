package instrucoes;
import unipic.Instrucao;

	public class BTFSS extends Instrucao{
		private String match = "^0111[0|1]{3}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			BTFSS inst = new BTFSS();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
