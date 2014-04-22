package instrucoes;
import unipic.Instrucao;

	public class IORLW  extends Instrucao{
		private String match = "^1101[0|1]{8}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			IORLW inst = new IORLW();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
	}
