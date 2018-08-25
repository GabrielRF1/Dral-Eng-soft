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
public abstract class Personagem {

    private Integer HP;
    private Integer Energy;
    private final Jogador master;
    protected Point pontoAtual;
    public Boolean moveu;

    public Personagem(int HP, int Energy, Jogador master, Point atual) {
        this.HP = HP;
        this.Energy = Energy;
        this.master = master;
        this.pontoAtual = atual;
    }

    public Jogador getMaster() {
        return master;
    }

    public void mover(Point p) {
        if (!moveu) {
            if (isInRange(p)) {
                Tabuleiro.getObject().addToCell(pontoAtual, null);
                Tabuleiro.getObject().addToCell(p, this);
                pontoAtual = p;
                moveu = true;
            } else {
                moveu = false;
            }
        }
    }

    @Override
    public String toString() {
        return "";
    }

    public abstract boolean isInRange(Point p);
}
