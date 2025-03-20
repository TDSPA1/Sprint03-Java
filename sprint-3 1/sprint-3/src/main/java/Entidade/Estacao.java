package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Estacao {
    private String id;
    private String nome;
    private String linha;
    private ArrayList<Estacao>estacoes = new ArrayList<>();

    public void adicionarEstacao(Estacao estacao){
        estacoes.add(estacao);
        System.out.println("Estacao adicionada: "+ estacao.getNome());
    }
    public void exibirEstacoes(){
        System.out.println("ID: "+ id +", Nome: "+ nome +", Linha: "+ linha);
    }



}
