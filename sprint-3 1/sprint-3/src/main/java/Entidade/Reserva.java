package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    private String id;
    private Usuario usuario;
    private Estacao estacaoOrigem;
    private Estacao estacaoDestino;
    private String data;
    private boolean statusDaReserva;

    public void exibirDetalhesDaReserva(){
        System.out.println("Reserva ID: " + id + ", Usuário: " + usuario.getNome() + ", De: " + estacaoOrigem.getNome() + ", Para: " + estacaoDestino.getNome() + ", Data: " + data);
    }

    public void confirmarReserva(){
        this.statusDaReserva = true;
        System.out.println("reserva confirmada para passageiro: "+ usuario.getNome());
    }

}
