package unipic;

public class Clock {
	private int tempo;
	PIC pic;
	
	public void setTempo(int time){
		this.tempo=time;	
	}
	
	public int getTempo(){
		return tempo;
	}
	
	public void setPic(PIC pic){
		this.pic = pic;
	}
	public PIC getPic(){
		return pic;
	}
	
	public void start() throws InterruptedException{
			while(true){
				  Thread.sleep(tempo);
				  pic.step();
			}
	}
	
}
