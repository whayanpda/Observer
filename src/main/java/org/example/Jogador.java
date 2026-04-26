package org.example;

import java.util.Observable;
import java.util.Observer;

public class Jogador implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void observarBoss(Boss boss) {
        boss.addObserver(this);
    }

    @Override
    public void update(Observable boss, Object arg) {
        this.ultimaNotificacao = this.nome + " recebeu alerta: " + arg;
    }
}
