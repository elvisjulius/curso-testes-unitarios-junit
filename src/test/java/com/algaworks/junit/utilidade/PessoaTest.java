package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void assercaoAgrudapa(){
        Pessoa pessoa = new Pessoa("Elvis", "Julius");

        assertAll("Asserções de pessoa",
                ()-> assertEquals("Elvis", pessoa.getNome()),
                ()-> assertEquals("Julius", pessoa.getSobrenome()));
    }

}