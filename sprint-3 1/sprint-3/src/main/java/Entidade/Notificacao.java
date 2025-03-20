package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Notificacao {
    private String id;
    private Usuario usuario;
    private String mensagem;
    private String dataEnvio;

    public void enviarNotificacao() {
        System.out.println("enviando notificacao para " + usuario.getNome() + ":" + mensagem);
    }

    public void exibirNotificacao() {
        System.out.println("ID: " + id + ", Usuário: " + usuario.getNome() + ", Mensagem: " + mensagem + ", Data: " + dataEnvio);
    }


}
