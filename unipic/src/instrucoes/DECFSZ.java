package instrucoes;
import unipic.Instrucao;
	
		public class DECFSZ extends Instrucao{
			private String match = "^001011[0|1]{1}[0|1]{5}$";
			
			public boolean matcher(String comando){
				return comando.matches(match);
			}
			
			@Override
			public Instrucao getInstrucao(String comando){
				DECFSZ inst = new DECFSZ();
				//     ** Vide Pagina 53 do manual da PIC **
				
				return inst;
			}
				
		}
