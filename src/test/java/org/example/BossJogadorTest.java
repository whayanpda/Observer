package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BossJogadorTest {

    @Test
    void deveNotificarJogadorQuandoVidaDoBossForMenorOuIgualACinquenta() {
        Boss boss = new Boss("Dragao", 100);
        Jogador jogador = new Jogador("Ana");
        jogador.observarBoss(boss);

        boss.receberDano(50);

        assertEquals(
                "Ana recebeu alerta: Boss Dragao esta com pouca vida! (50 HP)",
                jogador.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveNotificarJogadorQuandoVidaDoBossPermanecerAcimaDeCinquenta() {
        Boss boss = new Boss("Dragao", 100);
        Jogador jogador = new Jogador("Ana");
        jogador.observarBoss(boss);

        boss.receberDano(40);

        assertNull(jogador.getUltimaNotificacao());
    }


    @Test
    void deveNotificarApenasQuandoBossEntrarNaFaixaCritica() {
        Boss boss = new Boss("Dragao", 100);
        Jogador jogador = new Jogador("Ana");
        jogador.observarBoss(boss);

        boss.receberDano(40);
        boss.receberDano(20);

        assertEquals(
                "Ana recebeu alerta: Boss Dragao esta com pouca vida! (40 HP)",
                jogador.getUltimaNotificacao()
        );
    }

    @Test
    void naoDeveEnviarNovoAlertaDepoisQueBossJaEstiverComVidaBaixa() {
        Boss boss = new Boss("Dragao", 100);
        Jogador jogador = new Jogador("Ana");
        jogador.observarBoss(boss);

        boss.receberDano(60);
        boss.receberDano(10);

        assertEquals(
                "Ana recebeu alerta: Boss Dragao esta com pouca vida! (40 HP)",
                jogador.getUltimaNotificacao()
        );
    }
}
