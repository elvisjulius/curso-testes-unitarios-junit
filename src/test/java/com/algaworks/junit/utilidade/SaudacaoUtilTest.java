package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SaudacaoUtilTest {

    @Test
    public void saudacaoDia() {
        String saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void saudacaoTarde() {
        String saudacao = SaudacaoUtil.saudar(12);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void saudacaoNoite() {
        String saudacao = SaudacaoUtil.saudar(18);
        assertEquals("Boa noite", saudacao);
    }


    @Test
    public void deveLancarException(){
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-10));

        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException(){
        assertDoesNotThrow(()-> SaudacaoUtil.saudar(0));
    }
}