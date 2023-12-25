package com.algaworks.junit.utilidade;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SaudacaoUtilTest {

    //Given, When, Then
    @Test
    public void dada_um_horario_de_manha_quando_saudar_entao_deve_retornar_bom_dia() {
        int horaValida = 9;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudacao);

        Assertions.assertThat(saudacao)
                .withFailMessage("Saudação incorreta!")
                .isEqualTo("Bom dia");
    }

    @Test
    public void dada_um_horario_as_5_da_manha_quando_saudar_entao_deve_retornar_bom_dia() {
        int horaValida = 5;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudacao);
    }

    @Test
    public void dada_um_horario_a_tarde_quando_saudar_entao_deve_retornar_boa_tarde() {
        int horaValida = 12;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa tarde", saudacao);
    }

    @Test
    public void dada_um_horario_noturno_quando_saudar_entao_deve_retornar_boa_noite() {
        int horaValida = 4;
        String saudacao = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudacao);
    }


    @Test
    public void dado_uma_hora_invalida_quando_saudar_deve_lancar_exception(){
        int horaInvalida = -10;

        Executable chamadaInvalidaDeMetodo = () -> SaudacaoUtil.saudar(horaInvalida);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,chamadaInvalidaDeMetodo);

        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    public void dado_uma_hora_valida_quando_saudar_nao_deve_lancar_exception(){
        int horaValida = 0;

        Executable chamadaValidaDeMetodo = ()-> SaudacaoUtil.saudar(0);

        assertDoesNotThrow(chamadaValidaDeMetodo);
    }

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,8,9,10,11})
    public void Dado_um_horario_matinal_Quando_saudar_Entao_deve_retornar_bom_dia(int hora){
    String saudacao = SaudacaoUtil.saudar(hora);
    assertEquals("Bom dia", saudacao);
    }
}