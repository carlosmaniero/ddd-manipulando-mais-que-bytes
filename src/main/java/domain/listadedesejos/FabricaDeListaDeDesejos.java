package domain.listadedesejos;

import domain.usuario.UsuarioID;

public class FabricaDeListaDeDesejos {
    private final RepositorioDeListaDeDesejos repositorioDeListaDeDesejos;

    public FabricaDeListaDeDesejos(RepositorioDeListaDeDesejos repositorioDeListaDeDesejos) {
        this.repositorioDeListaDeDesejos = repositorioDeListaDeDesejos;
    }

    public ListaDeDesejos criarListaDeDesejos(UsuarioID usuarioID, NomeDaLista nomeDaLista) {
        if (repositorioDeListaDeDesejos.contemListaComNomeDe(usuarioID, nomeDaLista)) {
            throw new IllegalArgumentException("Lista já existe.");
        }

        return new ListaDeDesejos(proximoID(usuarioID), nomeDaLista);
    }

    private ListaDeDesejosID proximoID(UsuarioID usuarioID) {
        int totalDeListasDoUsuario = repositorioDeListaDeDesejos.totalDeListasPor(usuarioID);
        return new ListaDeDesejosID(usuarioID, totalDeListasDoUsuario + 1L);
    }
}
