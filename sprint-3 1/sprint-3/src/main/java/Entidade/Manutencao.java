package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Manutencao {
    private String id;
    private String tipoDeManutencao;
    private String tecnicoResponsavel;
    private String descricao;
    private String localizacao;

    public void exibirManutencao() {
        System.out.println("ID: " + id + ", Tipo de manutencao: " + tipoDeManutencao + ", tecnico responsavel: " + tecnicoResponsavel + ", Descrição: " + descricao + ",localizacao: " + localizacao);
    }


}
