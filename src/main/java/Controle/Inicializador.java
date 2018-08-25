/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Jogador;
import Visão.TabuleiroView;

/**
 *
 * @author Gabriel
 */
public class Inicializador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogador j1 = new Jogador(0);
        Jogador j2 = new Jogador(1);
        ControladorDoGame.getObject().setJogadores(j1, j2);
        TabuleiroView tv = new TabuleiroView();
        tv.setVisible(true);
    }
    
}
