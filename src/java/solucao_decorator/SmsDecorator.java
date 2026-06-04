package solucao_decorator;

public class SmsDecorator extends NotificacaoDecorator {

    public SmsDecorator(Notificacao wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem, String destino) {
        System.out.println("SMS enviado para " + destino + ": " + mensagem);
        super.enviar(mensagem, destino);
    }
}
