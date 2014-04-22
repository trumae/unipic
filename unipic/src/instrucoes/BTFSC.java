package instrucoes;
import unipic.Instrucao;

	public class BTFSC extends Instrucao{
		private String match = "^0110[0|1]{3}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			BTFSC inst = new BTFSC();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
