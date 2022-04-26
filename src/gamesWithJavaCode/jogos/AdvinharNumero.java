package gamesWithJavaCode.jogos;

import java.util.Scanner;

public class AdvinharNumero extends Jogo {

	private Scanner s = new Scanner(System.in);
	private int max;
	private int min;
	private int tentativas;
	private int tentativasPadrao = 3;
	private int numSecreto;
	private int palpiteNumerico;

	public AdvinharNumero() {
		this.tentativas = 3;
	}

	public AdvinharNumero(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public int getNumSecreto() {
		return numSecreto;
	}

	public void setNumSecreto(int numSecreto) {
		this.numSecreto = numSecreto;
	}

	public int getPalpiteNumerico() {
		return palpiteNumerico;
	}

	public void setPalpiteNumerico(int palpiteNumerico) {
		this.palpiteNumerico = palpiteNumerico;
	}

	public void getMaxAndMin() {
		try {
			System.out.println("Entre com o número máximo:");
			this.max = Integer.parseInt(s.nextLine());
			System.out.println("Entre com o número mínimo:");
			this.min = Integer.parseInt(s.nextLine());
		} catch (Exception e) {
			System.out.println("Número inválido.");
		}
	}

	public boolean fimJogo(int i, boolean acerto) {
		boolean r = false;
		if (acerto == true && i <= tentativas) {
			System.out.println("Parabéns!");
			r = true;
		} else if (acerto == false && i < tentativas) {
			System.out.println("Que pena, não foi dessa vez. Tente de novo!");
			r = false;
		} else if (i == tentativas) {
			System.out.println("Que pena, parece que você não descobriu!");
			r = false;
		}
		return r;
	}

	public boolean verificaPalpiteNumerico() {
		boolean acerto = false;
		if (palpiteNumerico == numSecreto) {
			System.out.println("Parabéns você acertou!");
			acerto = true;
		} else if (palpiteNumerico > numSecreto) {
			System.out.println("Não tão alto!");
			acerto = false;
		} else if (palpiteNumerico < numSecreto) {
			System.out.println("Não tão baixo!");
			acerto = false;
		}
		return acerto;
	}

	public void numeroSecretoRandomico() {
		int numeroSecreto = 0;
		do {
			numeroSecreto = (int) Math.floor(Math.random() * max);
		} while (numeroSecreto < min && numeroSecreto > max);

		this.numSecreto = numeroSecreto;
	}

	public void getSeuPalpiteNumerico() {
		try {
			System.out.println("Entre com o seu palpite:");
			this.palpiteNumerico = Integer.parseInt(s.nextLine());
			System.out.println(palpiteNumerico);
		} catch (Exception e) {
			System.out.println("Número inválido.");
		}
	}

	public void setJogo() {
		tentativas = tentativasPadrao;
		System.out.println("Advinhe o número.");
		System.out.println("Entre com um número máximo e mínimo para o computador escolher.");
		System.out.println("Em seguida tente descobrir que número ele escolheu.");
		getMaxAndMin();
		numeroSecretoRandomico();
		System.out.println(String.format("Advinhe o número que escolhi entre %d e %d!", min, max));
	}

	public void setJogo(int tentativas) {
		this.tentativas = tentativas;
		System.out.println("Advinhe o número.");
		System.out.println("Entre com um número máximo e mínimo para o computador escolher.");
		System.out.println("Em seguida tente descobrir que número ele escolheu.");
		getMaxAndMin();
		numeroSecretoRandomico();
		System.out.println(String.format("Advinhe o número que escolhi entre %d e %d!", min, max));
	}

	public void jogo() {

		setJogo();
		int i = 1;
		boolean encerraJogo = false;
		while (i <= tentativas && encerraJogo == false) {
			System.out.println(String.format("Tentativa %d de %d.", (tentativas - i + 1), tentativas));
			getSeuPalpiteNumerico();
			boolean r = verificaPalpiteNumerico();
			encerraJogo = fimJogo(i, r);
			i++;
		}
		if (querJogarDeNovo()) {
			jogo();
		} else {
			System.out.println("Fui...");
		}
	}

}
