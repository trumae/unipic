package instrucoes;
import unipic.Instrucao;

	public class CLRWDT extends Instrucao{
		private String match = "^000000000100$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			CLRWDT inst = new CLRWDT();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}

	