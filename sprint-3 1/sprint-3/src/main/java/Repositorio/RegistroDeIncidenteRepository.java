package Repositorio;

import Entidade.RegistroDeIncidente;
import Extensions.LocalDateTimeGsonAdapter;
import Infrastructure.DatabaseConfig;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.example.Main.logger;

public class RegistroDeIncidenteRepository implements CrudRepository<RegistroDeIncidenteRepository> {

    private List<RegistroDeIncidenteRepository> registros = new ArrayList<>();



    @Override
    public void adicionar(RegistroDeIncidenteRepository object) {
        registros.add(object);

    }

    @Override
    public void remover(RegistroDeIncidenteRepository object) {
        registros.remove(object);

    }

    @Override
    public void atualizar(String id, RegistroDeIncidenteRepository object) {
        for(RegistroDeIncidenteRepository r :registros)
            if(r.getClass().equals(id))
                r = object;

    }

    @Override
    public List<RegistroDeIncidenteRepository> listarTodos() {
        return List.of();
    }

    @Override
    public List<RegistroDeIncidenteRepository> listar() {
        return registros;
    }

    @Override
    public void deleteById(String  id) {
        //var query = "DELETE FROM COLECAO WHERE ID = ?";
        var query = "UPDATE COLECAO SET DELETED = 1 WHERE ID = ?";
        try(var conn =  DatabaseConfig.getConnection())
        {
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            var result = stmt.executeUpdate();
            if(result > 0)
                logger.info("Colecao removido com sucesso!");
        }
        catch (SQLException e){
            logger.error(e);
        }
    }

    public void importarDeJson(String arquivo){
        try{
            var gson = new  GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeGsonAdapter())
                    .create();
            var caminho = "./reports/" + arquivo;
            var reader = new FileReader(caminho);
            var colecoesDoJson = gson.fromJson(reader, RegistroDeIncidenteRepository[].class);
            for(var c: colecoesDoJson)
                adicionar(c);
        }
        catch (Exception e){
            logger.error("Erro ao importar arquivo", e);
            System.out.println("Erro ao importar o arquivo");
        }
    }
    public void exportarParaJson(){
        var guid = UUID.randomUUID().toString();
        var caminho = "./reports/"+
                LocalDateTime.now() +
                guid +
                "_incidentes.json";
        try{
            var diretorio = new File("./reports/");
            if(!diretorio.exists()){
                diretorio.mkdirs();
            }
            var gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeGsonAdapter())
                    .setPrettyPrinting()
                    .create();
            var json = gson.toJson(listar());
            var file = new File(caminho);
            var fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();
        }
        catch (Exception e){
            logger.error("Erro ao exportar arquivo", e);
            System.out.println("Erro ao exportar o arquivo");
        }
    }
    public void importar(String c){
        String caminho = "./reports/" + c;
        try{
            var file = new File(caminho);
            var reader = new FileReader(file);
            var conteudo = "";
            while (reader.ready())
                conteudo += (char) reader.read();
            System.out.println(conteudo);
        }
        catch (IOException e){
            System.out.println("Erro ao importar o arquivo");
        }
    }

    public void exportar() {
        var guid = UUID.randomUUID().toString();
        var conteudo = "Este texto será o conteudo que será exportado para o meu arquivo";
        var caminho = "./reports/"+
                //LocalDateTime.now() +
                guid +
                "_colecoes.txt";
        try{
            var file = new File(caminho);
            if(!file.exists())
                file.createNewFile();
            var writer = new FileWriter(file);
            writer.write(conteudo);
            writer.close();
            System.out.println("Arquivo exportado com sucesso");
        }
        catch (IOException e){
            System.out.println("Erro ao exportar o arquivo");
            throw new RuntimeException(e);
        }
    }

}
