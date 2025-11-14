package com;

import java.util.Arrays;
import java.util.Scanner;

public class TresEnRaya {
	private static char[][] tablero = new char[3][3];
	private static final char JUGADOR_1 = 'x';
	private static final char JUGADOR_2 = 'o';
	
	public static char turno = JUGADOR_1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0; 
		do { 
			 mostrarMenu(); 
			 opcion = sc.nextInt(); 
			 switch (opcion) {
			 case 1:
				 jugar(sc);
				 break;
			 case 2:
				 mostrarInstrucciones();
				 break;
			 case 3:
				 System.out.println("Vuelve pronto.");
				 break;
			 } 
		 } while (opcion != 3);

	}
	
	private static void mostrarMenu() {
		System.out.println("Bienvenido al 3 en raya.\n");
		System.out.println("Seleccione una opción:");
		System.out.println("1) Jugar      2) Intrucciones     3) Salir");
	}

	private static void mostrarInstrucciones() {
		System.out.println("Instrucciones:");
		System.out.println("El jugador X comienza.");
		System.out.println("Se introduce fila y columna entre 0 y 2.");
		System.out.println("Gana el que consiga 3 en raya.");
	}

	private static void jugar(Scanner sc) {
		int columna, fila;
		char jugador = 'x';
		inicializarTablero();
		
		do {
			if (jugador == 'x') jugador = 'o';
			else jugador = 'x';
			
			System.out.println("Jugador " + jugador);
			System.out.println("Fila:");
			fila = sc.nextInt();
			System.out.println("Columna:");
			columna = sc.nextInt();
			
			if (columna < 0 || columna >= 3 || fila < 0 || fila >= 3) {
				System.out.println("Espacio no existente, pruebe otra vez:");
				if (jugador == 'x') jugador = 'o';
				else jugador = 'x';
				continue;
			}
			
			if (tablero[fila][columna] == ' ') {
				tablero[fila][columna] = jugador;
			} else {
				System.out.println("Espacio ya ocupado, pruebe otra vez:");
				if (jugador == 'x') jugador = 'o';
				else jugador = 'x';
				continue;
			}
			
			mostrarTablero();
			
		} while (!hayGanador() && !tableroLleno());
		
		if (hayGanador()) System.out.println("Ha ganado " + jugador);
		else System.out.println("Empate");
		
	}

	private static void inicializarTablero() {
		
		for (int i = 0; i < 3; i++) {
			Arrays.fill(tablero[i], ' ');
		}
		
		mostrarTablero();
	}

	private static void mostrarTablero() {
		System.out.println();
		for (int f = 0; f < 3; f++) {
			for (int c = 0; c < 3; c++) {
				if (c == 0) System.out.print(" ");
				System.out.print(tablero[f][c]);
				if (c != 2) System.out.print(" | ");
			}
			System.out.println();
			if (f != 2) System.out.println("-----------");
		}
		System.out.println();
	}

	private static boolean hayGanador() {
	    // Filas y columnas
	    for (int i = 0; i < 3; i++) {
	        if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2])
	            return true;
	        if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i])
	            return true;
	    }

	    // Diagonales
	    if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2])
	        return true;
	    if (tablero[2][0] != ' ' && tablero[2][0] == tablero[1][1] && tablero[1][1] == tablero[0][2])
	        return true;

	    return false;
	}

	private static boolean tableroLleno() {
		for (int f = 0; f < 3; f++) {
			for (int c = 0; c < 3; c++) {
				if (tablero[f][c] == ' ') {
					return false;
				}
			}
		}
		
		return true;
	}

}