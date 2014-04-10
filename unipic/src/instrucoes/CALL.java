package instrucoes;
import unipic.Instrucao;

	public class CALL extends Instrucao{
		private String match = "^1001[0|1]{8}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			CALL inst = new CALL();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
