package gamesWithJavaCode.jogos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Forca extends Jogo {

	private Scanner s = new Scanner(System.in);
	private int tentativas;
	private String palavra;
	private int tentativasPadrao = 10;
	String[] letrasAcertadas;

	private String[] palavras = { "animais", "papagaio", "periquito", "barco", "carro", "moto" };

	public Forca() {
		this.tentativas = tentativasPadrao;
	}

	public Forca(int tentativas) {
		this.tentativas = tentativas;
	}

	// Seleciona a palavra que será embaralhada e o jogador deverá descobrir.
	public String selecionaPalavra() {
		palavra = palavras[(int) Math.floor(Math.random() * palavras.length)];
		return palavra;
	}

	public void printArrayWord(String[] word) {
		for (String w : word) {
			System.out.print(w);
		}
		System.out.println("");
	}

	// Prepara o jogo
	public void setJogo() {
		tentativas = tentativasPadrao;
		System.out.println("Forca.");
		System.out.println("Advinhe a palavra!");
		System.out.println("Acentos e cedilha devem ser considerados.");
		System.out.println(String.format("Você tem %d tentativas.", tentativas));
		palavra = selecionaPalavra();
		System.out.println(String.format("A palavra tem %d letras.", palavra.length()));
		for (int i = 0; i < palavra.length(); i++) {
			System.out.print("_ ");
		}
		System.out.println("");
	}

	// Prepara o jogo
	public void setJogo(int tentativas) {
		this.tentativas = tentativas;
		System.out.println("Forca.");
		System.out.println("Advinhe a palavra!");
		System.out.println("Acentos e cedilha devem ser considerados.");
		System.out.println(String.format("Você tem %d tentativas.", tentativas));
		palavra = selecionaPalavra();
		System.out.println(String.format("A palavra tem %d letras.", palavra.length()));
		for (int i = 0; i < palavra.length(); i++) {
			System.out.print("_ ");
		}
		System.out.println("");
	}

	// Monta o jogo, define ponteiros e contadores
	public void jogo() {
		setJogo();
		letrasAcertadas = preencheVarLetrasAcertadas(palavra);
		while (tentativas > 0) {
			System.out.println("Tentativa: " + tentativas);
			String letra = s.nextLine();
			if (letra.length() == 1) {
				List<String> wordList = Arrays.asList(palavra.split(""));
				Iterator<String> it = wordList.iterator();
				int count = 0;
				int p = -1;
				while (it.hasNext()) {
					String nl = it.next();
					p++;
					if (nl.equals(letra)) {
						count++;
						letrasAcertadas[p] = letra;
					}
				}

				printArrayWord(letrasAcertadas);

				if (count > 0) {
					System.out.println("Acertou.");
				} else {
					System.out.println("Errou.");
				}

				if (descobriuPalavra(letrasAcertadas, palavra)) {
					System.out.println("Parabéns, você descobriu a palavra!");
					break;
				}else if (descobriuPalavra(letrasAcertadas, palavra) == false && tentativas == 1) {
					System.out.println("Que pena, não foi dessa vez...");
				} 

			} else if (letra.length() == palavra.length()) {
				if (letra.equals(palavra)) {
					System.out.println("Parabéns, você acertou a palavra!");
					break;
				}
				else if(letra.equals(palavra)==false && tentativas == 1){
					System.out.println("Que pena, não foi dessa vez...");
				}
				else {
					System.out.println("Errou.");
				}
			} else {
				System.out.println("Insira apenas uma letra ou a palavra.");
			}
			tentativas--;
		}
		if (querJogarDeNovo()) {
			jogo();
		} else {
			System.out.println("Fui...");
		}

	}

	public String[] preencheVarLetrasAcertadas(String palavra) {
		String[] letrasAcertadas = new String[palavra.length()];
		for (int i = 0; i < palavra.length(); i++) {
			letrasAcertadas[i] = " _ ";
		}
		return letrasAcertadas;
	}

	public Boolean descobriuPalavra(String[] letrasAcertadas, String palavra) {
		String lA = "";
		for (int j = 0; j < letrasAcertadas.length; j++) {
			lA += letrasAcertadas[j];
		}
		return (lA.equals(palavra));
	}

}
