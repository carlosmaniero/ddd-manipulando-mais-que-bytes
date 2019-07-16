package domain.usuario;

public class UsuarioID {
    private final long id;

    public UsuarioID(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioID usuarioID = (UsuarioID) o;
        return getId() == usuarioID.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
