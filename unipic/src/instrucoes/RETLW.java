package instrucoes;
import unipic.Instrucao;

	public class RETLW extends Instrucao{
		private String match = "^1000[0|1]{8}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			RETLW inst = new RETLW();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
}
