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
public class Arqueiro extends Personagem {

    public Arqueiro(int HP, int Energy, Jogador master, Point atual) {
        super(HP, Energy, master, atual);
    }

    @Override
    public String toString() {
        return "Arqueiro";
    }

    @Override
    public boolean isInRange(Point p) {
        if (Math.abs(pontoAtual.x - p.x) <= 8 && Math.abs(pontoAtual.y - p.y) <= 8) {
            return true;
        }
        return false;
    }

}
