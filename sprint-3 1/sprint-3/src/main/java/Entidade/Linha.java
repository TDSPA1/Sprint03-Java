package Entidade;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Linha {
    private String id;
    private String nome;
    private String cor;

    public void exibirDetalhes(){
        System.out.println("ID :"+ id + "Nome: "+ nome + "Cor: "+ cor);
    }

}
