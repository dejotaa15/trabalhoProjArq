public class NotificacaoSMS implements Notificacao {
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("Enviando SMS para " + destinatario + ": " + mensagem);
    }
}
