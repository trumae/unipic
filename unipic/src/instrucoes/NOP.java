package instrucoes;
import unipic.Instrucao;

	public class NOP extends Instrucao{
		private String match = "^000000000000$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			NOP inst = new NOP();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}


