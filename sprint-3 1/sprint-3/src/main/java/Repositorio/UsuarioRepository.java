package Repositorio;

import Entidade.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository  implements  CrudRepository<Usuario>{
    private List<Usuario> usuarios = new ArrayList<>();


    @Override
    public void adicionar(Usuario object) {
        usuarios.add(object);

    }

    @Override
    public void remover(Usuario object) {
        usuarios.remove(object);

    }

    @Override
    public void atualizar(String id, Usuario object) {
        for(Usuario u: usuarios)
            if(u.getId().equals(id))
                u = object;

    }

    @Override
    public List<Usuario> listarTodos() {
        return List.of();
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    @Override
    public void deleteById(String id) {

    }

}
