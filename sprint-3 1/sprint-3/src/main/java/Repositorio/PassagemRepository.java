package Repositorio;

import Entidade.Passagem;

import java.util.ArrayList;
import java.util.List;

public class PassagemRepository implements CrudRepository<Passagem>{
    private List<Passagem> passagens = new ArrayList<>();

    @Override
    public void adicionar(Passagem object) {
        passagens.add(object);

    }

    @Override
    public void remover(Passagem object) {
        passagens.remove(object);

    }

    @Override
    public void atualizar(String id, Passagem object) {
        for(Passagem p : passagens)
            if(p.getId().equals(id))
                p = object;

    }

    @Override
    public List<Passagem> listarTodos() {
        return List.of();
    }

    @Override
    public List<Passagem> listar() {
        return passagens;
    }

    @Override
    public void deleteById(String id) {

    }


}
