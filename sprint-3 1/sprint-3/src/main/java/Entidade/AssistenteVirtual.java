package Entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AssistenteVirtual {
    private String texto;
    private String resposta;

    public static String responder(String pergunta){
        if(pergunta.toLowerCase().contains("quanto custa uma passagem ?")){
            return "O bilhete unitário do metrô de São Paulo custa R$ 5,00 e é válido para uma viagem. Esse valor é válido para todas as linhas operadas pelo Metrô, CPTM, ViaQuatro e ViaMobilidade\n";

        }else if(pergunta.toLowerCase().contains("demora quanto tempo da estação capão redondo até chacara klabin")){
            return "A viagem entre as estações Capão e Chácara Klabin leva aproximadamente 40 a 50 minutos no Metrô de São Paulo\n";

        }else if(pergunta.toLowerCase().contains("qual o horário que o metrô funciona ?")){
            return "O Metrô de São Paulo geralmente funciona de segunda a sábado, das 4h40 até meia-noite. Aos domingos, o horário de funcionamento é de 4h40 até 23h00. No entanto, esses horários podem variar de acordo com as alterações de operação, como manutenções programadas ou eventos especiais.\n";

        }else if(pergunta.toLowerCase().contains("o metrô tem acessibilidade para pessoas com deficiência ?")){
            return " Sim, o Metrô de São Paulo possui acessibilidade em todas as suas estações e trens. Isso inclui:\n" +
                    "Plataformas acessíveis para cadeirantes.\n" +
                    "Elevadores e escadas rolantes.\n" +
                    "Sinalização em braille.\n" +
                    "Áudio nas estações e trens para deficientes visuais.\n";

        }else if(pergunta.toLowerCase().contains("quais são as formas de pagamento no metrô ?")){
            return "As formas de pagamento incluem:\n" +
                    "Bilhete Único (cartão recarregável que pode ser usado no Metrô, ônibus e CPTM).\n" +
                    "Cartão de Transporte Comum (para quem não possui o Bilhete Único).\n" +
                    "Cartão de crédito ou débito (em algumas estações e máquinas de venda automática).\n" +
                    "Cartão Metrô (em parceria com a operadora de transporte), mas o Bilhete Único é o mais utilizado.\n";

        }else if(pergunta.toLowerCase().contains("posso levar minha bicicleta no metrô ?")){
            return "Sim, é permitido levar bicicletas no Metrô de São Paulo, mas com algumas regras:\n" +
                    "Durante horários de pico, não é permitido transportar bicicletas.\n" +
                    "Fora dos horários de pico, você pode levar sua bicicleta, desde que ela não ocupe espaço excessivo.\n" +
                    "Algumas estações oferecem bicicletários para quem deseja deixar a bicicleta e continuar viagem.\n";

        }else {
            return "Desculpe não sei a resposta, mas voce pode ligar no telefone: 0800 071 8020 \n";
        }
    }

}
