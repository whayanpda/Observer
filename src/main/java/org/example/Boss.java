package org.example;

import java.util.Observable;

public class Boss extends Observable {

    private String nome;
    private int vida;
    private boolean alertaVidaBaixaEnviado;

    public Boss(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public void receberDano(int dano) {
        int vidaAnterior = this.vida;
        this.vida -= dano;

        if (vidaAnterior > 50 && this.vida <= 50 && !alertaVidaBaixaEnviado) {
            alertaVidaBaixaEnviado = true;
            setChanged();
            notifyObservers("Boss " + nome + " esta com pouca vida! (" + vida + " HP)");
        }
    }

    @Override
    public String toString() {
        return "Boss{" +
                "nome='" + nome + '\'' +
                ", vida=" + vida +
                '}';
    }
}
