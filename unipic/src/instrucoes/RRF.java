package instrucoes;
import unipic.Instrucao;

	public class RRF extends Instrucao{
		private String match = "^001100[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			RRF inst = new RRF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}