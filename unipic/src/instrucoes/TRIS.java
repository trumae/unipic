package instrucoes;
import unipic.Instrucao;

	public class TRIS extends Instrucao{
		private String match = "^000000000[0|1]{3}$";
		
		public boolean matcher(String comando){
			return comando.matches(match);
		}
		
		@Override
		public Instrucao getInstrucao(String comando){
			TRIS inst = new TRIS();
			//     ** Vide Pagina 54 do manual da PIC **
			
			return inst;
		}
			
}
