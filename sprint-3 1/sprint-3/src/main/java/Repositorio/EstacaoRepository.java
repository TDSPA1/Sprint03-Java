package Repositorio;

import Entidade.Estacao;

import java.util.ArrayList;
import java.util.List;

public class EstacaoRepository implements CrudRepository<Estacao>{
    private List<Estacao> estacoes = new ArrayList<>();

    @Override
    public void adicionar(Estacao object) {
        estacoes.add(object);

    }

    @Override
    public void remover(Estacao object) {
        estacoes.remove(object);

    }

    @Override
    public void atualizar(String id, Estacao object) {
        for(Estacao e :estacoes)
            if(e.getId().equals(id))
                e=object;

    }

    @Override
    public List<Estacao> listarTodos() {
        return List.of();
    }

    @Override
    public List<Estacao> listar() {
        return estacoes;
    }

    @Override
    public void deleteById(String id) {

    }


}
