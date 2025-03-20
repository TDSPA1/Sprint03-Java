package Repositorio;

import Entidade.Reserva;

import java.util.ArrayList;
import java.util.List;


public class ReservaRepository implements CrudRepository<Reserva> {
    private List<Reserva> reservas = new ArrayList<>();
    @Override
    public void adicionar(Reserva object) {
        reservas.add(object);

    }

    @Override
    public void remover(Reserva object) {
        reservas.remove(object);

    }

    @Override
    public void atualizar(String id, Reserva object) {
        for(Reserva r:reservas)
            if(r.getId().equals(id))
                r = object;

    }

    @Override
    public List<Reserva> listarTodos() {
        return List.of();
    }

    @Override
    public List<Reserva> listar() {
        return reservas;
    }

    @Override
    public void deleteById(String id) {

    }


}
