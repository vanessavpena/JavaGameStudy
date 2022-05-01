package gamesWithJavaCode.jogos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JogoDaVelha extends Jogo {

	private Scanner s = new Scanner(System.in);
	private String[] playerMark = { "X", "O" };
	private int playerTime;
	private String[] positions = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private List<String> playedPositions = new ArrayList<String>();
	private int posicao;
	private boolean vencedor;
	private int resposta;

	public void jogo() {
		setJogo();
		if (querJogarDeNovo()) {
			jogo();
		} else {
			System.out.println("Fui...");
		}
	}

	public void setJogo() {
		cleanPositions();
		System.out.println("Jogo Da Velha");
		System.out.println("Quem será seu adversário?");
		System.out.println("1 - meu amigo aqui do meu lado.");
		System.out.println("2 - o computador.");
		System.out.println("Se uma resposta não for identificada, você jogará contra o computador.");
		resposta = s.nextInt();
		switch (resposta) {
		case 1:
			modoJogXJog();
			break;
		case 2:
			modoJogXAI();
			break;
		default:
			modoJogXAI();
			break;
		}
	}

	public void modoJogXAI() {
		playerTime = 0;
		vencedor = false;
		setBoard();
		do {

			if (playerTime == 0) {
				System.out.println(String.format(("Escolha sua posição %s:"), playerMark[playerTime]));
				posicao = s.nextInt();
				positions[posicao - 1] = playerMark[playerTime];
				playedPositions.add(String.valueOf(posicao - 1));
				vencedor = venceu();
				playerTime = trocaJogador(playerTime, vencedor);
				setTurnPlayed();
			} else {
				System.out.println(String.format(("Escolha sua posição %s:"), playerMark[playerTime]));
				posicao = pcPlayer(playedPositions);
				positions[posicao - 1] = playerMark[playerTime];
				playedPositions.add(String.valueOf(posicao - 1));
				vencedor = venceu();
				playerTime = trocaJogador(playerTime, vencedor);
				setTurnPlayed();
			}

		} while (vencedor == false);

	}

	public void modoJogXJog() {
		playerTime = 0;
		vencedor = false;
		setBoard();
		do {
			System.out.println(String.format(("Escolha sua posição %s:"), playerMark[playerTime]));
			posicao = s.nextInt();
			positions[posicao - 1] = playerMark[playerTime];
			playedPositions.add(String.valueOf(posicao - 1));
			vencedor = venceu();
			playerTime = trocaJogador(playerTime, vencedor);
			setTurnPlayed();

		} while (vencedor == false);
	}

	public int trocaJogador(int playerTime, Boolean vencedor) {
		if (playerTime == 0 && vencedor == false) {
			playerTime = 1;
		} else if (playerTime == 1 && vencedor == false) {
			playerTime = 0;
		}
		return playerTime;
	}

	public int pcPlayer(List<String> playerPositions) {
		Boolean isOnList = false;
		int pos;
		do {
			pos = (int) Math.floor(Math.random() * 9);
			for (int i = 0; i < playerPositions.size(); i++) {
				if ((playerPositions.contains(String.valueOf(pos)))) {
					isOnList = true;
				}
			}
		} while (isOnList == true);
		return pos;
	}

	public void setBoard() {
		System.out.println(positions[6] + " | " + positions[7] + " | " + positions[8]);
		System.out.println("---------");
		System.out.println(positions[3] + " | " + positions[4] + " | " + positions[5]);
		System.out.println("---------");
		System.out.println(positions[0] + " | " + positions[1] + " | " + positions[2]);
	}

	public Boolean venceu() {
		boolean venceu = false;
		if (positions[6] == positions[7] && positions[6] == positions[8]) {
			venceu = true;
		} else if (positions[3] == positions[4] && positions[3] == positions[5]) {
			venceu = true;
		} else if (positions[0] == positions[1] && positions[0] == positions[2]) {
			venceu = true;
		} else if (positions[0] == positions[3] && positions[0] == positions[6]) {
			venceu = true;
		} else if (positions[1] == positions[4] && positions[1] == positions[5]) {
			venceu = true;
		} else if (positions[2] == positions[5] && positions[2] == positions[8]) {
			venceu = true;
		} else if (positions[0] == positions[4] && positions[0] == positions[8]) {
			venceu = true;
		} else if (positions[2] == positions[4] && positions[2] == positions[6]) {
			venceu = true;
		}
		return venceu;
	}

	public void setTurnPlayed() {
		if (vencedor == true) {
			setBoard();
			System.out.println(String.format("Vencedor: %s", playerMark[playerTime]));
		} else {
			setBoard();
		}
	}
	public void cleanPositions() {
		for(int i = 0; i < positions.length; i ++) {
			positions[i] = String.valueOf(i+1);
		}
	}

}
