package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.Calculadora;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.FiltroDeRecomendacao;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.setDuracaoEmMinutos(180);


        meuFilme.exibiFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);


        System.out.println("Total de avaliações: " + meuFilme.getTotalAvalicao());
        System.out.println("Soma das avaliações: " + meuFilme.getSomaDasAvalicoes());
        System.out.println("Duração do filme: "+ meuFilme.getDuracaoEmMinutos() + " minutos");
        System.out.println(meuFilme.obterMedia()+ "\n");


        Serie lost = new Serie("Lost",2000);
        lost.exibiFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos() + " minutos");



        Filme outroFilme = new Filme("Avatar caminho das aguas",2022);
        outroFilme.setDuracaoEmMinutos(200);


        Calculadora calculadora = new Calculadora();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme);


        /* ------------ FILME ---------------------------
        *  Para avaliar o filme é passado o obterMedia() / 2;
        * public double obterMedia() { return somaDasAvalicoes / totalAvalicao;}
        *
        *
        * Que vai retonar o valor de cada avaliação
        * public void avalia(double nota) {
             somaDasAvalicoes += nota;
             totalAvalicao++
        }
        * Passando para a classe public int getClassificacao() {
                return (int) obterMedia() / 2 ;
         }
        * o valor em casting que por sua vez executa FiltroRecomendacao
        *
        *---------------------------------- Episodio ---------------------------------
        * No episodio é usado o numero de vizualicao para avaliar a serie
        *  @Override
        public int getClassificacao() {
            if(TotalVisualizacoes > 100){
                return 4;
            }else{
                return 2;
            }
        }
        *
        *Que é passado pelo metodo getTotalDevisuazalicao
        * public int getTotalVisualizacoes() {
         return TotalVisualizacoes;
        }
        * */


        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);


        Filme filmeDoBrener = new Filme("Dogvill",2003);
        filmeDoBrener.setDuracaoEmMinutos(200);
        filmeDoBrener.avalia(10);


        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoBrener);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da Lista de Filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " +listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme: " +listaDeFilmes.get(0).toString());




    }
}
