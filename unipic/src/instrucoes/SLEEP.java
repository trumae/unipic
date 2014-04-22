package instrucoes;
import unipic.Instrucao;

	public class SLEEP extends Instrucao{
		private String match = "^000000000011$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			SLEEP inst = new SLEEP();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
}
