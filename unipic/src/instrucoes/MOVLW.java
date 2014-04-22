package instrucoes;
import unipic.Instrucao;

	public class MOVLW extends Instrucao{
		private String match = "^001000[0|1]{1}[0|1]{5}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			MOVLW inst = new MOVLW();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
}
