package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Passagem {
    private String id;
    private String nome;
    private double valor;
    private String formaDePagamento;
    private String horarioDePagamento;

    public void exibirDetalhes() {
        System.out.println("ID: " + id + " ,Nome: "+ nome + " ,Valor: " + valor + " ,forma de pagamento: " + formaDePagamento +" ,horario: "+horarioDePagamento);
    }


}

