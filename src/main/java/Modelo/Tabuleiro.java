/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Point;

/**
 *
 * @author Gabriel
 */
public class Tabuleiro {

    private Celula[][] tabuleiro;
    private static Tabuleiro tab;

    private Tabuleiro() {
        tabuleiro = new Celula[28][28];
        initCells();
    }

    public void addToCell(Point pt, Personagem p) {
        tabuleiro[pt.x][pt.y].setPersonagem(p);
    }

    private void initCells() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[0].length; j++) {
                tabuleiro[i][j] = new Celula();
            }
        }
    }

    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }

    public static Tabuleiro getObject() {
        if (tab == null) {
            tab = new Tabuleiro();
        }
        return tab;
    }
}
