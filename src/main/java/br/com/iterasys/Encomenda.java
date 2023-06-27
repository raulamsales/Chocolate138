package br.com.iterasys;

public class Encomenda {
    public static int calcularBarrasChocolates(int barras) {
        byte quantidadePorCaixa = 12;

        int caixas = barras / quantidadePorCaixa;

        int unidades = barras % quantidadePorCaixa;

            System.out.println("Quantidade de Caixas " + caixas + " e " + unidades + " unidades");

        return caixas;
    }
}