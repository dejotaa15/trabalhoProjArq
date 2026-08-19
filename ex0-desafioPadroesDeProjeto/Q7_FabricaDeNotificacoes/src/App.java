public class App {
    public static void main(String[] args) {
        enviarNotificacao("EMAIL", "aluno@exemplo.com", "Aula de padrões às 19h30");
        enviarNotificacao("SMS", "51999999999", "Aula de padrões às 19h30");
    }

    private static void enviarNotificacao(String tipo, String destinatario, String mensagem) {
        Notificacao notificacao;

        if (tipo.equals("EMAIL")) {
            notificacao = new NotificacaoEmail();
        } else if (tipo.equals("SMS")) {
            notificacao = new NotificacaoSMS();
        } else {
            throw new IllegalArgumentException("Tipo de notificação desconhecido: " + tipo);
        }

        notificacao.enviar(destinatario, mensagem);
    }
}
