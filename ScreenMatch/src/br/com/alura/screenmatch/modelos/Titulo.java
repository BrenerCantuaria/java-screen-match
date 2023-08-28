package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErrorConversaoDeAnoExecption;


public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLacamento;
    private boolean incluidoNoPlano;
    private double somaDasAvalicoes;
    private int totalAvalicao;
    private int duracaoEmMinutos;


    public Titulo(String nome, int anoDeLacamento) {
        this.nome = nome;
        this.anoDeLacamento = anoDeLacamento;
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        if (tituloOmdb.year().length() > 4) {
            throw new ErrorConversaoDeAnoExecption("Não consegui converter o ano porque tem mais de 4 caracteres.");
        }
        this.anoDeLacamento = Integer.valueOf(tituloOmdb.year().substring(0, 4));
        this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runtime().substring(0, 3));


    }

    //------------------- GETTER ----------------------
    public String getNome() {
        return nome;
    }

    public int getAnoDeLacamento() {
        return anoDeLacamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public double getSomaDasAvalicoes() {
        return somaDasAvalicoes;
    }

    //--------------------- SETTER --------------------------
    public void setNome(String nome) {
        //atributo //parametro da função
        this.nome = nome;
    }

    public void setAnoDeLacamento(int anoDeLacamento) {
        this.anoDeLacamento = anoDeLacamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


    //--------------------- MÉTODOS -------------------------
    public int getTotalAvalicao() {
        return totalAvalicao;
    }

    public void exibiFichaTecnica() {
        System.out.print("Nome: " + nome);
        System.out.println("\nAno de lançamento: " + anoDeLacamento);
    }

    public void avalia(double nota) {
        somaDasAvalicoes += nota;
        totalAvalicao++;
    }

    public double obterMedia() {
        return somaDasAvalicoes / totalAvalicao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome=" + nome + ", anoDeLacamento= " + anoDeLacamento + " duração= " + duracaoEmMinutos + ") ";
    }
}
