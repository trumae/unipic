package instrucoes;
import unipic.Instrucao;

	public class COMF extends Instrucao{
		private String match = "^001001[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			COMF inst = new COMF();
			//     ** Vide Pagina 53 do manual da PIC **
			
			return inst;
		}
			
	}

	

