package Repositorio;

import Entidade.Linha;
import Infrastructure.DatabaseConfig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Main.logger;

public class LinhaRepository implements CrudRepository<Linha> {
    private List<Linha> linhas = new ArrayList<>();

    @Override
    public void adicionar(Linha object) {
        var query = "INSERT INTO COLECAO (DELETED, NOME, ID, COR) VALUES (?,?,?,?)";
        try(var conn = DatabaseConfig.getConnection())
        {
            var stmt = conn.prepareStatement(query);
            stmt.setBoolean(1, false);
            stmt.setString(2, object.getNome());
            stmt.setString(3, object.getId());
            stmt.setString(4, object.getCor());
            var result = stmt.executeUpdate();
            if(result > 0)
                logger.info("LINHA adicionado com sucesso!");
        }
        catch(SQLException e){
            logger.error(e);
        }

    }

    @Override
    public void remover(Linha object) {
        linhas.remove(object);

    }

    @Override
    public void atualizar(String id, Linha object) {
        for(Linha l : linhas)
            if(l.getId().equals(id))
                l = object;

    }

    @Override
    public List<Linha> listarTodos() {
        return linhas;
    }

    @Override
    public List<Linha> listar() {
        var linhaLl = new ArrayList<Linha>();
        var query = "SELECT * FROM linha WHERE DELETED = 0";
        try (var connection = DatabaseConfig.getConnection())
        {
            var statement = connection.prepareStatement(query);
            var result = statement.executeQuery();
            while (result.next())
            {
                var linha = new Linha();
                linha.setId(result.getString("id"));
                linha.setNome(result.getString("nome"));
                linhaLl.add(linha);
            }
        }
        catch (SQLException e){
            logger.error("Erro ao cadastrar linhas",e);
            throw new RuntimeException("Erro ao acessar o banco de dados",e);
        }
        return linhaLl;

    }

    @Override
    public void deleteById(String id) {
        linhas.removeIf(l ->l.getId().equals(id));

    }


}
