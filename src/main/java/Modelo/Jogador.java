/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controle.OccupiedException;
import Controle.OutOfBaseException;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Jogador {

    private ArrayList<Personagem> personagens;
    private final Integer side;

    public Jogador(int side) {
        personagens = new ArrayList<>();
        this.side = side;
    }

    public void inicializarPecas(Point pt, Personagem perso) throws OutOfBaseException, OccupiedException {
        if (side == 0 && pt.y > 5) {
            throw new OutOfBaseException();
        } else if (side == 1 && pt.y < 23) {
            throw new OutOfBaseException();
        }
        if (Tabuleiro.getObject().getTabuleiro()[pt.x][pt.y].getPersonagem() != null) {
            throw new OccupiedException();
        }
        perso.moveu = false;
        Tabuleiro.getObject().addToCell(pt, perso);
        personagens.add(0, perso);
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public Integer getSide() {
        return side;
    }

}
