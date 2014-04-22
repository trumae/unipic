package instrucoes;
import unipic.Instrucao;

	public class SWAPF extends Instrucao{
		private String match = "^001110[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			SWAPF inst = new SWAPF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
