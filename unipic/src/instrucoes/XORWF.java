package instrucoes;
import unipic.Instrucao;

	public class XORWF extends Instrucao{
		private String match = "^000110[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			XORWF inst = new XORWF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
