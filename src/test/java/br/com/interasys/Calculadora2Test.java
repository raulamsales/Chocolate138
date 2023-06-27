package br.com.interasys;

import br.com.iterasys.Calculadora;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calculadora2Test {

    @DataProvider(name = "Massa")
    public Object[][] massa(){
        return new Object[][]{
                {1, 2, 3},
                {4, 5, 9},
                {7, 8, 15}
        };
    }

    @Test
    public void testeSomarInteirosPositivos(){
        // Arrange
        int n1 = 5;
        int n2 = 7;
        int resEsperado = 12;

        // Act
        int resObtido = Calculadora.somarInt( n1, n2);

        // Assert
        Assert.assertEquals(resObtido, resEsperado, "A soma de " + n1 + " e " + n2 + " deve ser " + resEsperado);
    }

    @Test(dataProvider = "Massa")
    public void testeMultiplicarDD(int n1, int n2, int resEsperado) {
        int resAtual =  Calculadora.somarInt(n1, n2);
        Assert.assertEquals(resAtual, resEsperado);
    }

}

