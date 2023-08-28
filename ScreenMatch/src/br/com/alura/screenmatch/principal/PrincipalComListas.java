package br.com.alura.screenmatch.principal;
import java.util.*;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.Serie;



public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão",1970);
        meuFilme.avalia(9);
        Serie lost = new Serie("Lost",2000);
        Filme outroFilme = new Filme("Avatar caminho das aguas",2022);
        meuFilme.avalia(10);
        Filme filmeDoBrener = new Filme("Dogvill",2003);
        meuFilme.avalia(10);

        Filme f1 = filmeDoBrener;
        
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoBrener);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }


        List<String> buscarPorArtista= new LinkedList<>();
        buscarPorArtista.add("Adam Sandler");
        buscarPorArtista.add("Paulo");
        buscarPorArtista.add("Jacqueline");

        System.out.println(buscarPorArtista);
        Collections.sort(buscarPorArtista);
        System.out.println("Depois da ordenação:"+ buscarPorArtista);

        Collections.sort(lista);
        System.out.println("Lista de filmes ordenados:"+lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLacamento));
        System.out.println("Lista de filmes ordenado por ano:"+lista);
    }
}
