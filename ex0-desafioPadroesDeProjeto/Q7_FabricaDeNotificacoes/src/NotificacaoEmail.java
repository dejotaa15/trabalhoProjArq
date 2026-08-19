public class NotificacaoEmail implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando EMAIL para " + destinatario + ": " + mensagem);
    }
}
