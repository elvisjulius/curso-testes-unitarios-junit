package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Deve Salvar com Bom dia")
    public void saudacaoDia() {
        int horaValida = 9;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    @DisplayName("Deve Salvar com Bom dia às 5 hrs")
    public void saudacaoDiaAPartirDas5() {
        int horaValida = 5;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void saudacaoTarde() {
        int horaValida = 12;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void saudacaoNoite() {
        int horaValida = 18;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }

    @Test
    public void saudacaoNoiteAs4hrs() {
        int horaValida = 4;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }


    @Test
    public void deveLancarException(){
        int horaInvalida = -10;

        Executable chamadaInvalidaDeMetodo = () -> SaudacaoUtil.saudar(horaInvalida);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,chamadaInvalidaDeMetodo);

        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    public void naoDeveLancarException(){
        int horaValida = 0;

        Executable chamadaValidaDeMetodo = ()-> SaudacaoUtil.saudar(0);

        assertDoesNotThrow(chamadaValidaDeMetodo);
    }
}