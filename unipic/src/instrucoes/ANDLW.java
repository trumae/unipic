package instrucoes;
import unipic.Instrucao;

	public class ANDLW  extends Instrucao{
		private String match = "^1110[0|1]{8}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			ANDLW inst = new ANDLW();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
