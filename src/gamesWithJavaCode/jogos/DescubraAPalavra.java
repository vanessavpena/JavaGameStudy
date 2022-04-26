package gamesWithJavaCode.jogos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DescubraAPalavra extends Jogo {

	private Scanner s = new Scanner(System.in);
	private int tentativas;
	private int tentativasPadrao = 3;
	private String palavra;
	private String palavraEmbaralhada;
	private String[] palavras = { "animais", "papagaio", "periquito", "barco", "carro", "moto" };

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String word) {
		this.palavra = word;
	}

	public String getPalavraEmbaralhada() {
		return palavraEmbaralhada;
	}

	public void setPalavraEmbaralhada(String wordShuffled) {
		this.palavraEmbaralhada = wordShuffled;
	}

	public String[] getPalavras() {
		return palavras;
	}

	public void setPalavras(String[] words) {
		this.palavras = words;
	}

	// Construtor inicia com o padrão de 3 tentativas.
	public DescubraAPalavra() {
		this.tentativas = tentativasPadrao;
	}

	// Construtor inicia com o número de tentativas escolhido.
	public DescubraAPalavra(int tentativas) {
		this.tentativas = tentativas;
	}

	// Seleciona a palavra que será embaralhada e o jogador deverá ordenar.
	public String selecionaPalavra() {
		palavra = palavras[(int) Math.floor(Math.random() * palavras.length)];
		return palavra;
	}

	// Embaralha a palavra selecionada.
	public String embaralhaPalavra() {
		palavraEmbaralhada = "";
		List<String> letras = Arrays.asList(palavra.split(""));
		Collections.shuffle(letras);
		for (String letra : letras) {
			palavraEmbaralhada += letra;
		}
		if (palavraEmbaralhada.equals(palavra)) {
			embaralhaPalavra();
		}
		return palavraEmbaralhada;
	}

	// Prepara o jogo
	public void setJogo() {
		tentativas = tentativasPadrao;
		System.out.println("Advinhe a palavra!");
		System.out.println(String.format("Você tem %d tentativas.", getTentativas()));
		palavra = selecionaPalavra();
		palavraEmbaralhada = embaralhaPalavra();
		System.out.println(palavraEmbaralhada);
	}
	
	// Prepara o jogo
		public void setJogo(int tentativas) {
			this.tentativas = tentativas;
			System.out.println("Advinhe a palavra!");
			System.out.println(String.format("Você tem %d tentativas.", getTentativas()));
			palavra = selecionaPalavra();
			palavraEmbaralhada = embaralhaPalavra();
			System.out.println(palavraEmbaralhada);
		}

	public void jogo() {
		setJogo();

		while (tentativas >= 1) {
			String palpite = s.nextLine();
			if (palpite.equals(palavra) && tentativas >= 1) {
				System.out.println("Parabéns! Você acertou a palavra: " + palavra);
				break;
			} else if (!palpite.equals(palavra) && tentativas > 1) {
				System.out.println("Tente de novo! Você não acertou a palavra ainda.");
			} else if (!palpite.equals(palavra) && tentativas == 2) {
				System.out.println("Tente de novo! Você não acertou a palavra ainda.");
				System.out.println("Essa é sua última chance.");
			} else if (!palpite.equals(palavra) && tentativas == 1) {
				System.out.println("Que pena! Não foi dessa vez...");
			}
			tentativas--;
		}
		if (querJogarDeNovo()) {
			jogo();
		} else {
			System.out.println("Fui...");
		}
	}

}
