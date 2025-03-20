package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegistroDeIncidente {
    private String id;
    private String dataDOIncidente;
    private String status;
    private String transporte;

    public void exibirIncidente() {
        System.out.println("ID: " + id + ", Transporte: " + transporte + ", Data: " + dataDOIncidente + ", Status: " + status);
    }

}

