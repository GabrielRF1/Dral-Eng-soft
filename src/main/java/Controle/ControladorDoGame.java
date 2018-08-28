/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Jogador;
import Modelo.Personagem;
import Modelo.Tabuleiro;
import java.awt.Point;

/**
 *
 * @author Gabriel
 */
public class ControladorDoGame {

    private Integer turnoAtual;
    private Jogador jogadores[];
    private boolean firstDeployer;
    private static ControladorDoGame controle;

    private ControladorDoGame() {
        turnoAtual = 0;
        jogadores = new Jogador[2];
        firstDeployer = true;
    }

    public void setJogadores(Jogador j1, Jogador j2) {
        jogadores[0] = j1;
        jogadores[1] = j2;
    }

    public boolean isFirstDeployer() {
        return firstDeployer;
    }

    public void setFirstDeployer(boolean oneHasDeployed) {
        this.firstDeployer = oneHasDeployed;
    }

    public Integer getTurnoAtual() {
        return turnoAtual;
    }

    public static ControladorDoGame getObject() {
        if (controle == null) {
            controle = new ControladorDoGame();
        }
        return controle;
    }

    public boolean ChecarfimTurno() {
        int x = 0;
        for (int i = 0; i < jogadores[turnoAtual].getPersonagens().size(); i++) {
            if (jogadores[turnoAtual].getPersonagens().get(i).moveu) {
                x++;
            }
        }
        return (x == jogadores[turnoAtual].getPersonagens().size());
    }

    public void trocaTurco() {
        for (int i = 0; i < jogadores[turnoAtual].getPersonagens().size(); i++) {
            jogadores[turnoAtual].getPersonagens().get(i).moveu = false;
        }
        turnoAtual = (turnoAtual + 1) % 2;
    }

    public void jogarTurno(Point lastClicked, Point ponto) {
        Personagem peca = Tabuleiro.getObject().getTabuleiro()[lastClicked.x][lastClicked.y].getPersonagem();
        if (peca.getMaster().getSide().equals(jogadores[turnoAtual].getSide())) {
            moverPeca(peca, ponto);
            if (ChecarfimTurno()) {
                trocaTurco();
            }
        }
    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void locaisDasPecas() {

    }

    private void moverPeca(Personagem peca, Point ponto) {
        peca.mover(ponto);
        return;

    }
}
