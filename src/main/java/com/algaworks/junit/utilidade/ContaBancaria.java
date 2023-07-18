package com.algaworks.junit.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {
private BigDecimal saldo;
    public ContaBancaria(BigDecimal saldo) {

        if(saldo == null) throw new IllegalArgumentException("O Saldo não pode ser nulo");
        this.saldo = saldo;

        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - pode ser zero ou negativo
    }

    public void saque(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
        throw new IllegalArgumentException("O valor não pode ser nulo ou igual ou menor que 0");
        }

        int comparacao = valor.compareTo(this.saldo);


        if (comparacao > 0) throw new RuntimeException("Saldo insuficiente");

        this.saldo = saldo.subtract(valor);
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve subtrair o valor do saldo
        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
    }

    public void deposito(BigDecimal valor) {

        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("O valor não pode ser nulo ou igual ou menor que 0");
        }
        this.saldo = saldo.add(valor);
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        //TODO 2 - Deve adicionar o valor ao saldo
    }

    public BigDecimal saldo() {

        return this.saldo;
    }
}
