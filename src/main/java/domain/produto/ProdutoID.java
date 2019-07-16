package domain.produto;

public class ProdutoID {
    private final long id;

    public ProdutoID(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdutoID usuarioID = (ProdutoID) o;
        return getId() == usuarioID.getId();
    }

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }
}
