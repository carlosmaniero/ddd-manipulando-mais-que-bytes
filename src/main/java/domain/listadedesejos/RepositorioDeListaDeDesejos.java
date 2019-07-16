package domain.listadedesejos;

import domain.usuario.UsuarioID;

public interface RepositorioDeListaDeDesejos {
    void salvarLista(ListaDeDesejos listaDeDesejos);
    ListaDeDesejos listaPor(ListaDeDesejosID listaDeDesejosID);
    int totalDeListasPor(UsuarioID usuarioID);
    boolean contemListaComNomeDe(UsuarioID usuarioID, NomeDaLista nomeDaLista);
}
