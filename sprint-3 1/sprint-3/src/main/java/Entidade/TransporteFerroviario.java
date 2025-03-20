package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransporteFerroviario {
    private String id;
    private int numeroDeVagao;
    private int capacidadeMax;
    private int capacidadeMin;
    private String linhaDaRota;
    private String horarioSaida;
    private String horarioChegada;

    public void exibirDetalhes() {
        System.out.println("ID: " + id + " ,numeroDeVagao:  " + numeroDeVagao + " ,capacidadeMax : " + capacidadeMax + " ,capacidadeMin: " + capacidadeMin);
    }

}
