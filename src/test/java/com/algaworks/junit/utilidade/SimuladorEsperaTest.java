package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.time.Duration;

class SimuladorEsperaTest {

    @Test
    //@Disabled("não é mais aplicavel")
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    void deveEsperarENaoDarTimeout() {
        //Assumptions.assumeTrue("PROD".equals(System.getenv("ENV")), () -> "Abortando teste: Não deve ser executado em PROD");
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}