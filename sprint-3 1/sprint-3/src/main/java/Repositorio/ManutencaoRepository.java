package Repositorio;

import Entidade.Manutencao;

import java.util.ArrayList;
import java.util.List;

public class ManutencaoRepository implements CrudRepository<Manutencao> {
    private List<Manutencao> manutencoes = new ArrayList<>();


    @Override
    public void adicionar(Manutencao object) {
        manutencoes.add(object);

    }

    @Override
    public void remover(Manutencao object) {
        manutencoes.remove(object);

    }

    @Override
    public void atualizar(String id, Manutencao object) {
        for(Manutencao m :manutencoes)
            if(m.getId().equals(id))
                m = object;

    }

    @Override
    public List<Manutencao> listarTodos() {
        return List.of();
    }

    @Override
    public List<Manutencao> listar() {
        return manutencoes;
    }

    @Override
    public void deleteById(String id) {

    }


}
