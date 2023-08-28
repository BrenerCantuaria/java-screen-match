package br.com.alura.screenmatch.excecao;

public class ErrorConversaoDeAnoExecption extends RuntimeException {
    private String mensagem;
    public ErrorConversaoDeAnoExecption(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
