package unipic;

public class Clock {
	int tempo;
	public void setTempo(int time){
		this.tempo=time;	
	}
	
	public void Cronometro() throws InterruptedException{
			while(System.currentTimeMillis() < tempo){
				  wait();
			}
	}
	
}
