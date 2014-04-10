package instrucoes;
import unipic.Instrucao;

	public class BCF extends Instrucao{
		private String match = "^0100[0|1]{3}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			BCF inst = new BCF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
