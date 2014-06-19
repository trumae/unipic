package unipic;

public class CPU {
	public byte W;
	public void step(){
		System.out.println("Uma instrucao");
	}
	public byte getW(){
		return W;
	}
	public void setW(byte valor){
		W = valor;
	}

}
