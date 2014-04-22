package instrucoes;
	import unipic.Instrucao;
	
		public class DECF extends Instrucao{
			private String match = "^000011[0|1]{1}[0|1]{5}$";
			
			public boolean matcher(String comando){
				return comando.matches(match);
			}
			
			@Override
			public Instrucao getInstrucao(String comando){
				DECF inst = new DECF();
				//     ** Vide Pagina 53 do manual da PIC **
				
				return inst;
			}
				
		}
