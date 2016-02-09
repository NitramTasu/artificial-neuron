package br.com.rede.main;

import java.util.Scanner;

import br.com.rede.neural.Neuronio;

public class Main {
	
	private static boolean exit = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float[] amostra = {0,-0.25f};
		Neuronio neuronio = new Neuronio();
		
		neuronio.iniPesos(2);
		
		int op;
		do{
			op = mostrarTela();	
			switch (op) {
			case 1:
				neuronio.treinamento(amostra, 1);
				break;
			case 2:
				int saida = neuronio.operacao(amostra);
				
				System.out.println("Saída :" + saida+"\n");
				break;

			default:
				break;
			}
			
		}while(op != 3);
		
		

	}

	private static int mostrarTela() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 - treinamento");
		System.out.println("2 - processamento");
		System.out.println("3 - sair");
		System.out.println("O que deseja fazer?");
		int op = scanner.nextInt();
		
		return op;
	}

}
