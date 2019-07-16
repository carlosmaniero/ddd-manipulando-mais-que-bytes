package domain.produto;

import java.util.Objects;

public class Produto {
    private final ProdutoID id;

    public Produto(ProdutoID id) {
        this.id = id;
    }

    public ProdutoID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return Objects.equals(id, ((Produto) o).id);
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
