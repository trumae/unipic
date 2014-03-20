package unipic;

import java.util.Scanner;

public class Clock {
	public int getTempo(){
		Scanner ler = new Scanner( System.in );   
		int tempo;
		System.out.println("Um ciclo do Clock terá quantos segundos?");
		tempo=ler.nextInt();
		tempo*=1000;
		return tempo;
	}
	
	public void Cronometro(int tempo) throws InterruptedException{
		try{
			Thread.sleep(tempo);
		}
		catch(InterruptedException e){
			System.out.println("Erro inesperado.");
		}
	}
}
