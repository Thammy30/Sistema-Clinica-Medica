package solucao_decorator;

public abstract class NotificacaoDecorator implements Notificacao {
    protected Notificacao wrappee;

    public NotificacaoDecorator(Notificacao wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void enviar(String mensagem, String destino) {
        wrappee.enviar(mensagem, destino);
    }
}