package solucao_decorator;

public class WhatsAppDecorator extends NotificacaoDecorator {

    public WhatsAppDecorator(Notificacao wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem, String destino) {
        System.out.println("WhatsApp enviado para " + destino + ": " + mensagem);
        super.enviar(mensagem, destino);
    }
}