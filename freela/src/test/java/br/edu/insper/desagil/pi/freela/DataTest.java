package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {
    private Data data;

    @BeforeEach
    void setUp(){
        data = new Data();
    }


    @Test

    void constroi(){
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(1970, data.getAno());
    }

    @Test
    void dataBaixa(){
        data.atualiza(1969, 0, 0);
        assertEquals(1, data.getDia());
        assertEquals(1, data.getMes());
        assertEquals(1970, data.getAno());
        assertEquals(0, data.minutos());
    }

    @Test
    void dataAlta(){
        data.atualiza(2071,13,32);
        assertEquals(31, data.getDia());
        assertEquals(12, data.getMes());
        assertEquals(2070, data.getAno());
        assertEquals(53084160, data.minutos());
    }






}
