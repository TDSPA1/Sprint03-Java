package Repositorio;

import Entidade.AssistenteVirtual;
import com.sun.jdi.PrimitiveValue;

import java.util.ArrayList;
import java.util.List;

public class AssistenteVirtualRepository implements CrudRepository<AssistenteVirtual>{
    private List<AssistenteVirtual> assistentes = new ArrayList<>();


    @Override
    public void adicionar(AssistenteVirtual object) {
        assistentes.add(object);

    }

    @Override
    public void remover(AssistenteVirtual object) {
        assistentes.remove(object);

    }

    @Override
    public void atualizar(String id, AssistenteVirtual object) {

    }

    @Override
    public List<AssistenteVirtual> listarTodos() {
        return List.of();
    }

    @Override
    public List<AssistenteVirtual> listar() {
        return List.of();
    }

    @Override
    public void deleteById(String id) {

    }


}
