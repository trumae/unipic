package instrucoes;
import unipic.Instrucao;

	public class BSF extends Instrucao{
		private String match = "^0101[0|1]{3}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			BSF inst = new BSF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
