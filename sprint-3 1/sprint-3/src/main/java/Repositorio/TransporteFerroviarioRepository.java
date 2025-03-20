package Repositorio;

import Entidade.TransporteFerroviario;

import java.util.ArrayList;
import java.util.List;

public class TransporteFerroviarioRepository implements CrudRepository<TransporteFerroviario>{
    private List<TransporteFerroviario> transportes = new ArrayList<>();


    @Override
    public void adicionar(TransporteFerroviario object) {
        transportes.add(object);

    }

    @Override
    public void remover(TransporteFerroviario object) {
        transportes.remove(object);

    }

    @Override
    public void atualizar(String id, TransporteFerroviario object) {
        for(TransporteFerroviario t : transportes)
            if(t.getId().equals(id))
                t = object;


    }

    @Override
    public List<TransporteFerroviario> listarTodos() {
        return List.of();
    }

    @Override
    public List<TransporteFerroviario> listar() {
        return transportes;
    }

    @Override
    public void deleteById(String id) {

    }


}
