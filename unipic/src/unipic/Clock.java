package unipic;

public class Clock {
	private int tempo;
	CPU cpu;
	
	public void setTempo(int time){
		this.tempo=time;	
	}
	
	public int getTempo(){
		return tempo;
	}
	
	public void start() throws InterruptedException{
			while(true){
				  Thread.sleep(tempo);
			}
	}
	
}
