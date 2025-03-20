package Repositorio;

import Entidade.TransporteFerroviario;

import java.util.List;

public interface CrudRepository<T> {
 //crud = c->criar (adicionar) r-->remover u -->atualizar(uptdate) d--> deletar(deleted)
 //<T> significa objeto generico
    void adicionar(T object);
    void remover(T object);
    void atualizar(String id, T object);
    List<T> listarTodos();
    List<T> listar();

    void deleteById(String id);
}
