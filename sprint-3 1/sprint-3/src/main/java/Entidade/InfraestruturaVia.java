package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InfraestruturaVia {
    private String id;
    private String localizacao;
    private String estadoDeConservacao;
    private String dataDeManutencao;
    private String linha;

    public void exibirInformacao(){
        System.out.println("ID: " + id + ", Localizcao: " + localizacao + ", Estado de conservacao: " + estadoDeConservacao + ", Data de manutencao: " + dataDeManutencao + ",Linha: "+ linha);
    }

}

