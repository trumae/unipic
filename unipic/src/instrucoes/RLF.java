package instrucoes;
import unipic.Instrucao;

	public class RLF extends Instrucao{
		private String match = "^001101[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			RLF inst = new RLF();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
