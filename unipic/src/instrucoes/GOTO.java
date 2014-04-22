package instrucoes;
import unipic.Instrucao;

	public class GOTO extends Instrucao{
		private String match = "^101[0|1]{9}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			GOTO inst = new GOTO();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}

	