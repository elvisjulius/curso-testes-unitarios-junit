package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.event.ContainerAdapter;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Nested
    class Saque{
        @Test
        void saqueNaoRealizado() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(1000));
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                    () -> contaBancaria.saque(new BigDecimal(0)));

            assertEquals("O valor não pode ser nulo ou igual ou menor que 0", illegalArgumentException.getMessage());

        }

        @Test
        void saqueNaoPodeSerMaiorQueSaldo() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(1000));
            RuntimeException runtimeException = assertThrows(RuntimeException.class,
                    () -> contaBancaria.saque(new BigDecimal(1001)));

            assertEquals("Saldo insuficiente", runtimeException.getMessage());

        }

        @Test
        void saqueRealizadoMudaSaldo() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(1000));

            contaBancaria.saque(new BigDecimal(499));
            assertEquals(new BigDecimal(501), contaBancaria.saldo());

        }
    }

    @Nested
    class Deposito{

        @Test
        void depositoNaoPodeSerNuloZeroOuMenorQueZero() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(1000));
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                    () -> contaBancaria.deposito(new BigDecimal(0)));

            assertEquals("O valor não pode ser nulo ou igual ou menor que 0", illegalArgumentException.getMessage());
        }

        @Test
        void depositoRealizadoMudaSaldo() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal(1000));

            contaBancaria.deposito(new BigDecimal(499));
            assertEquals(new BigDecimal(1499), contaBancaria.saldo());

        }
    }

    @Nested
    class Saldo{

        @Test
        void saldoNaoPodeSerNulo() {
            assertThrows(IllegalArgumentException.class, () -> {
                new ContaBancaria(null);
            }, "O Saldo não pode ser nulo");
        }

        @Test
        void podeSerZeroOuNegativo() {

            ContaBancaria contaBancaria = new ContaBancaria(new BigDecimal("-10.5"));

            assertEquals(new BigDecimal("-10.5"), contaBancaria.saldo());
        }
    }
}