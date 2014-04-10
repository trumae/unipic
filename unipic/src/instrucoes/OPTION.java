package instrucoes;
import unipic.Instrucao;

	public class OPTION extends Instrucao{
		private String match = "^000000000010$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			OPTION inst = new OPTION();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
}
