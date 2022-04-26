package gamesWithJavaCode.jogos;

import java.util.Scanner;

import gamesWithJavaCode.Interface.JogoInterface;

public abstract class Jogo implements JogoInterface {

	private Scanner scanner = new Scanner(System.in);
	
	public Jogo() {
	}

	public void jogo() {
		
	}
	
	public Boolean querJogarDeNovo(){
		System.out.println("Quer jogar de novo?");
		System.out.println("Digite: \n 1 para sim ou \n 0 para não.");
		String resposta = scanner.nextLine();
		if (resposta.equals("1")) {
			System.out.println("Então vamos lá!");
			return true;
		} else if (resposta.equals("0")) {
			System.out.println("Até a próxima! \nTchau...");
			return false;
		} else {
			System.out.println("Resposta inválida.\nJogo encerrado.");
			return false;
		}
	}
	
	

}
