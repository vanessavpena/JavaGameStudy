package gamesWithJavaCode.main;

import java.util.Scanner;

import gamesWithJavaCode.jogos.AdvinharNumero;
import gamesWithJavaCode.jogos.DescubraAPalavra;
import gamesWithJavaCode.jogos.Forca;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	private static int jogo;

	public static void menuPrincipal() {

		DescubraAPalavra dp = new DescubraAPalavra();
		AdvinharNumero an = new AdvinharNumero();
		Forca f = new Forca();

		System.out.println("Qual jogo você quer jogar?");
		System.out.println("Digite o número do jogo desejado:");
		System.out.println("1 - Descubra a palavra");
		System.out.println("2 - Advinhe o número");
		System.out.println("3 - Forca");
		System.out.println("4 - Sair");
		
		jogo = sc.nextInt();
		
		do {	
		if(jogo == 1) {
				dp.jogo();
				menuPrincipal();
			}
			else if(jogo == 2) {
				an.jogo();
				menuPrincipal();
			}
			else if(jogo == 3) {
				f.jogo();
				menuPrincipal();
			}
			else if(jogo == 4) {
				sair();
			}
			else {
				menuPrincipal();
			}
		}while(jogo != 4);
	}

	public static void sair() {
		System.out.println("Encerrando...");
		System.out.println("Tchau.");

	}
}
