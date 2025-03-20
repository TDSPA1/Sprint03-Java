package org.example;

import Entidade.*;
import Entidade.InfraestruturaVia;
import Entidade.Linha;
import Repositorio.LinhaRepository;
import Repositorio.RegistroDeIncidenteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static Entidade.AssistenteVirtual.responder;

public class Main {
    public static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Sistema iniciando...");

        //instanciando as classes

        Usuario usuario1 = new Usuario("1", "Renato", "12345678901", "masculino", "06/12/2002");
        Usuario usuario2 = new Usuario("2", "Gabriel", "23456789101", "masculino", "01/01/2005");
        Usuario usuario3 = new Usuario("3", "Fabio", "34567890120", "masculino", "02/02/1990");

        //Estacao estacao1 = new Estacao("1", "Trianon-Masp", "verde");
        // Estacao estacao2 = new Estacao("2", "Capão Redondo", "lilás");

        Linha linha1 = new Linha("1", "Linha 2-verde", "verde");
        Linha linha2 = new Linha("2", "Linha 5-lilás", "lilás");

        Passagem pagamento1 = new Passagem("1", "Renato", 5.00, "pix", "10:01");
        Passagem pagamento2 = new Passagem("2", "Fabio", 2.50, "débito", "6:13");

        InfraestruturaVia infraestrutura1 = new InfraestruturaVia("1", "Santo Amaro", "bom", "1/11/2024", "lilás");
        InfraestruturaVia infraestrutura2 = new InfraestruturaVia("2", "Ana Rosa", "ruim", "1/01/2024", "verde");

        Manutencao manutencao1 = new Manutencao("1", "conserto da via", "Felipe", "trilho com problema", "Linha Verde->na estacao Ana Rosa");

        Notificacao notificacao1 = new Notificacao("1", usuario2, "A Santo Amaro está congestionada", "03/11/2024");

        RegistroDeIncidente registroDeIncidente1 = new RegistroDeIncidente("1", "11/08/2024", "Manutencao", "TransporteFerroviario");

        //Reserva reserva1 = new Reserva("1", usuario1, estacao2, estacao1, "06/11/2024", true); //True para confirmado a reserva , e False para reserva não confirmado

        TransporteFerroviario trem1 = new TransporteFerroviario("1", 10, 100, 1, "lilás", "10:00", "10:30");

        //exibindo os metódos das classes

        usuario1.exibirDados();
        usuario2.exibirDados();
        usuario3.exibirDados();

        //estacao1.exibirEstacoes();
        //estacao2.exibirEstacoes();

        linha1.exibirDetalhes();
        linha2.exibirDetalhes();

        pagamento1.exibirDetalhes();
        pagamento2.exibirDetalhes();

        infraestrutura1.exibirInformacao();
        infraestrutura2.exibirInformacao();

        manutencao1.exibirManutencao();

        notificacao1.exibirNotificacao();
        notificacao1.enviarNotificacao();

        registroDeIncidente1.exibirIncidente();

        //reserva1.exibirDetalhesDaReserva();
        // reserva1.confirmarReserva();

        trem1.exibirDetalhes();

        var linhaRepository = new LinhaRepository();
        var RegistroDeIncidenteRepository = new RegistroDeIncidenteRepository();
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            System.out.println("Qual dessas pergunta você gostaria de saber ?");
            System.out.println("1-quanto custa uma passagem ?");
            System.out.println("2-demora quanto tempo da estação capão redondo até chacara klabin");
            System.out.println("3-quais o horário que o metro funciona ?");
            System.out.println("4-o metro tem acessibilidade para pessoas com deficiência ?");
            System.out.println("5-quais são as formas de pagamento no metrô ?");
            System.out.println("6-posso levar minha bicicleta no metrô ?");
            System.out.println("7-Cadastrar linhas");
            System.out.println("8-Remover linhas");
            System.out.println("9-listar as linhas");
            System.out.println("10-Exportar arquivos");
            System.out.println("11-Importar arquivos");
            System.out.println("12-para sair do programa");
            ;
            var opcao = scanner.nextInt();
            scanner.nextLine();
            //utilizei a classe AssistenteVirtual para responder as perguntas
            switch (opcao) {
                case 1:
                    System.out.println(responder("quanto custa uma passagem ?"));
                    break;
                case 2:
                    System.out.println(responder("demora quanto tempo da estação capão redondo até chacara klabin"));
                    break;
                case 3:
                    System.out.println(responder("qual o horário que o metrô funciona ?"));
                    break;
                case 4:
                    System.out.println(responder("o metrô tem acessibilidade para pessoas com deficiência ?"));
                    break;
                case 5:
                    System.out.println(responder("quais são as formas de pagamento no metrô ?"));
                    break;
                case 6:
                    System.out.println(responder("posso levar minha bicicleta no metrô ?"));
                    break;
                case 7 :
                    CadastrarLinha(linhaRepository);
                    System.out.println("linha cadastrado com sucesso");
                    break;
                case 8:
                    RemoverLinha(linhaRepository);
                    System.out.println("linha removido com sucesso");
                    break;
                case 9 :
                    ListarLinhas(linhaRepository);
                    break;
                case 10 :
                    RegistroDeIncidenteRepository.exportarParaJson();
                    break;
                case 11:
                    System.out.println("Digite o nome do arquivo:");
                    var nomeArquivo = scanner.nextLine();
                    RegistroDeIncidenteRepository.importar(nomeArquivo);
                    break;
                case 12:
                    System.out.println("Saindo do programa...");
                    break label;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            logger.info("SISTEMA FINALIZANDO ...");

        }

    }
    public static void CadastrarLinha(LinhaRepository repository){
        try{
            var scan = new Scanner(System.in);
            System.out.println("Qual o id da linha: ");
            var id = scan.nextLine();
            System.out.println("Qual o nome da linha: ");
            var nome = scan.nextLine();
            System.out.println("Qual a cor da linha: ");
            var cor = scan.nextLine();
            var linha = new Linha(id,nome,cor);
            repository.adicionar(linha);
            logger.info("linha registrada com sucesso {} ",linha);
        }
        catch (Exception e ){
            System.out.println("Erro ao cadastrar");
            logger.error("Erro ao registar a linha",e);
        }

    }
    public static void RemoverLinha(LinhaRepository repository){
        System.out.println("Digite o id da linha que deseja remover: ");
        var scan = new Scanner(System.in);
        var id = scan.nextLine();
        scan.nextLine();
        repository.deleteById(id);
    }
    public static void ListarLinhas(LinhaRepository repository){
        List<Linha> linhas = repository.listar();
        if(linhas != null && !linhas.isEmpty()){
            System.out.println("lista das linhas");
            for(Linha linha : linhas){
                System.out.println("ID: " + linha.getId()+ ",Nome: "+ linha.getNome() + ",Cor: "+ linha.getCor());
            }
        }else{
            logger.error("nenhuma linha encontrada");
            System.out.println("nenhuma linha encontrada");
        }
    }



}

