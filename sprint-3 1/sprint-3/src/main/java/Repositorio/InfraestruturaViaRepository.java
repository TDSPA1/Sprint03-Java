package Repositorio;

import Entidade.InfraestruturaVia;

import java.util.ArrayList;
import java.util.List;

public class InfraestruturaViaRepository implements CrudRepository<InfraestruturaVia> {
    private List<InfraestruturaVia> infraestruturas = new ArrayList<>();

    @Override
    public void adicionar(InfraestruturaVia object) {
        infraestruturas.add(object);

    }

    @Override
    public void remover(InfraestruturaVia object) {
        infraestruturas.remove(object);

    }

    @Override
    public void atualizar(String id, InfraestruturaVia object) {
        for(InfraestruturaVia i : infraestruturas)
            if(i.getId().equals(id))
                i = object;

    }

    @Override
    public List<InfraestruturaVia> listarTodos() {
        return List.of();
    }

    @Override
    public List<InfraestruturaVia> listar() {
        return List.of();
    }

    @Override
    public void deleteById(String id) {

    }

}
