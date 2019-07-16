package domain.listadedesejos;

import domain.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListaDeDesejos {
    private final ListaDeDesejosID id;
    private final List<Produto> produtos;
    private NomeDaLista nome;

    ListaDeDesejos(ListaDeDesejosID id, NomeDaLista nome) {
        this.id = id;
        this.nome = nome;
        produtos = new ArrayList<>();
    }


    public ListaDeDesejosID getId() {
        return id;
    }

    public NomeDaLista nome() {
        return nome;
    }

    public void renomearLista(NomeDaLista nome) {
        this.nome = nome;
    }

    public void adicionarProduto(Produto produto) {
        if (produtos.contains(produto)) {
            return;
        }
        produtos.add(produto);
    }

    public List<Produto> produtos() {
        return new ArrayList<>(produtos);
    }

    public void removeProduto(Produto produto) {
        produtos.remove(produto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaDeDesejos that = (ListaDeDesejos) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
