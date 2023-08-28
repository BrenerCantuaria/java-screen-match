package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErrorConversaoDeAnoExecption;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincialComBusca {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();



        while(!busca.equalsIgnoreCase("sair")) {
            System.out.print("Digite o nome do filme: ");
            busca = leitor.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=a29384bc";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                System.out.println(json);


                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);


                Titulo titulo = new Titulo(tituloOmdb);
                System.out.println("Titulo convertido:");
                System.out.println(titulo);

                titulos.add(titulo);

            } catch (NumberFormatException | IOException | InterruptedException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (ErrorConversaoDeAnoExecption e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);

        try{
            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
        }catch (NumberFormatException | IOException e){
            System.out.println(e);
        }

        System.out.println("Programa finalizou corretamente! :)");

    }
}
