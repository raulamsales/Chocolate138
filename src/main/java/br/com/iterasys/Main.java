package br.com.iterasys;


public class Main {
    public static void main(String[] args) {
        //chamarEncomenda();
        //chamarMultiply();
        chamarSomar();
    }

    public static void chamarEncomenda(){
        int barras = 20;
        Encomenda.calcularBarrasChocolates(barras);
    }

    public static void chamarSomar(){
        System.out.println("Sum result: " + Calculadora.somarInt(20, 5));
    }

    public static void chamarMultiply(){
        System.out.println("Multiply result: " + Calculadora.multiplyInt(20, 5));
    }
}