package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    //atributos
    private String id;
    private String nome;
    private String cpf;
    private String genero;
    private String dataDeAniversario;

    private void tamanhoDoCpf(String cpf){
        if (cpf.length() == 11){  //cpf possui 11 numeros
            System.out.println("cpf válido");
        }else {
            System.out.println("cpf com tamanho inválido ou vazio");
        }
    }
    public void exibirDados(){
        System.out.println("ID: "+ id + " ,Nome: "+ nome + " ,Cpf: "+ cpf + " ,Genero: "+ genero +" ,Data de Nascimento: "+ dataDeAniversario);

    }

}


