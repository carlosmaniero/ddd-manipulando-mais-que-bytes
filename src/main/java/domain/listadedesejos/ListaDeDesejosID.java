package domain.listadedesejos;

import domain.usuario.UsuarioID;

public class ListaDeDesejosID {
    private final UsuarioID usuarioID;

    public ListaDeDesejosID(UsuarioID usuarioID, Long numero) {
        this.usuarioID = usuarioID;
        this.numero = numero;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public Long getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaDeDesejosID that = (ListaDeDesejosID) o;

        if (!getUsuarioID().equals(that.getUsuarioID())) return false;
        return getNumero().equals(that.getNumero());
    }

    @Override
    public int hashCode() {
        int result = getUsuarioID().hashCode();
        result = 31 * result + getNumero().hashCode();
        return result;
    }

    private final Long numero;
}
