package Repositorio;

import Entidade.Notificacao;

import java.util.ArrayList;
import java.util.List;

public class NotificacaoRepository implements CrudRepository<Notificacao> {
    private List<Notificacao> notificacoes = new ArrayList<>();

    @Override
    public void adicionar(Notificacao object) {
        notificacoes.add(object);


    }

    @Override
    public void remover(Notificacao object) {
        notificacoes.remove(object);

    }

    @Override
    public void atualizar(String id, Notificacao object) {
        for(Notificacao n : notificacoes)
            if(n.getId().equals(id))
                n = object;

    }

    @Override
    public List<Notificacao> listarTodos() {
        return List.of();
    }

    @Override
    public List<Notificacao> listar() {
        return notificacoes;
    }

    @Override
    public void deleteById(String id) {

    }

}
