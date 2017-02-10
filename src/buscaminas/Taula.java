/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Llorenç
 */
import java.util.Random;
import java.util.Scanner;

public class Taula {

    private int[][] mines;
    private char[][] TaulaJoc;
    private int Linea, Columna;
    Random aleatori = new Random();
    Scanner input = new Scanner(System.in);

    public Taula() {
        mines = new int[10][10];
        TaulaJoc = new char[10][10];
        JugarMines();
        aleatoriMines();
        Omplir();
        JugarTaula();

    }

    public boolean guanyar() {
        int count = 0;
        for (int line = 1; line < 9; line++) {
            for (int columna = 1; columna < 9; columna++) {
                if (TaulaJoc[line][columna] == '_') {
                    count++;
                }
            }
        }
        if (count == 10) {
            return true;
        } else {
            return false;
        }
    }

    public void obrirVeinats() {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ((mines[Linea + i][Columna + j] != -1) && (Linea != 0 && Linea != 9 && Columna != 0 && Columna != 9)) {
                    TaulaJoc[Linea + i][Columna + j] = Character.forDigit(mines[Linea + i][Columna + j], 10);
                }
            }
        }

    }

    public int getPosition(int Linea, int Columna) {
        return mines[Linea][Columna];
    }

    public boolean setPosition() {

        do {
            System.out.print("\nLinea: ");
            Linea = input.nextInt();
            System.out.print("Columna: ");
            Columna = input.nextInt();

            if ((TaulaJoc[Linea][Columna] != '_') && ((Linea < 9 && Linea > 0) && (Columna < 9 && Columna > 0))) {
                System.out.println("Camp ja mostrat");
            }

            if (Linea < 1 || Linea > 8 || Columna < 1 || Columna > 8) {
                System.out.println("Tria un numero entre 1 i 8");
            }

        } while ((Linea < 1 || Linea > 8 || Columna < 1 || Columna > 8) || (TaulaJoc[Linea][Columna] != '_'));

        if (getPosition(Linea, Columna) == -1) {
            return true;
        } else {
            return false;
        }

    }

    public void mostrar() {
        System.out.println("\n     Lineas");
        for (int Linea = 8; Linea > 0; Linea--) {
            System.out.print("       " + Linea + " ");

            for (int Columna = 1; Columna < 9; Columna++) {
                System.out.print("   " + TaulaJoc[Linea][Columna]);
            }

            System.out.println();
        }

        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Columnas");

    }

    public void Omplir() {
        for (int line = 1; line < 9; line++) {
            for (int columna = 1; columna < 9; columna++) {

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (mines[line][columna] != -1) {
                            if (mines[line + i][columna + j] == -1) {
                                mines[line][columna]++;
                            }
                        }
                    }
                }

            }
        }

    }

    public void mostrarMines() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (mines[i][j] == -1) {
                    TaulaJoc[i][j] = '*';
                }
            }
        }

        mostrar();
    }

    public void JugarTaula() {
        for (int i = 1; i < mines.length; i++) {
            for (int j = 1; j < mines.length; j++) {
                TaulaJoc[i][j] = '_';
            }
        }
    }

    public void JugarMines() {
        for (int i = 0; i < mines.length; i++) {
            for (int j = 0; j < mines.length; j++) {
                mines[i][j] = 0;
            }
        }
    }

    public void aleatoriMines() {
        boolean raffled;
        int Linea, Columna;
        for (int i = 0; i < 10; i++) {

            do {
                Linea = aleatori.nextInt(8) + 1;
                Columna = aleatori.nextInt(8) + 1;

                if (mines[Linea][Columna] == -1) {
                    raffled = true;
                } else {
                    raffled = false;
                }
            } while (raffled);

            mines[Linea][Columna] = -1;
        }
    }
}
