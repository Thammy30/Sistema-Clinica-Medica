package solucao_decorator;

public class EmailNotificacao implements Notificacao {

    @Override
    public void enviar(String mensagem, String destino) {
        System.out.println("EMAIL enviado para " + destino + ": " + mensagem);
    }
}