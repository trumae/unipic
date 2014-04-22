package instrucoes;
import unipic.Instrucao;
		
			public class INCF extends Instrucao{
				private String match = "^001010[0|1]{1}[0|1]{5}$";
				
				public boolean matcher(String comando){
					return comando.matches(match);
				}
				
				@Override
				public Instrucao getInstrucao(String comando){
					INCF inst = new INCF();
					//     ** Vide Pagina 53 do manual da PIC **
					
					return inst;
				}
					
			}
