package domain.listadedesejos;

import domain.produto.Produto;
import domain.produto.ProdutoID;
import domain.usuario.UsuarioID;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

public class ListaDeDesejosTest {
    @Test
    public void igualdadeEhBaseadaNoId() {
        UsuarioID usuario = new UsuarioID(1L);
        ListaDeDesejosID id = new ListaDeDesejosID(usuario, 1L);
        assertEquals(new ListaDeDesejos(id, NomeDaLista.peloNomeDe("abc")), new ListaDeDesejos(id, NomeDaLista.peloNomeDe("cba")));
    }

    @Test
    public void adicionaProdutoAListaDeProdutos() {
        UsuarioID usuario = new UsuarioID(1L);
        ListaDeDesejosID id = new ListaDeDesejosID(usuario, 1L);
        ListaDeDesejos listaDeDesejos = new ListaDeDesejos(id, NomeDaLista.peloNomeDe("abc"));
        listaDeDesejos.adicionarProduto(new Produto(new ProdutoID(1L)));

        assertThat(listaDeDesejos.produtos(), contains(new Produto(new ProdutoID(1L))));
    }

    @Test
    public void ignoraProdutosRepetidos() {
        UsuarioID usuario = new UsuarioID(1L);
        ListaDeDesejosID id = new ListaDeDesejosID(usuario, 1L);
        ListaDeDesejos listaDeDesejos = new ListaDeDesejos(id, NomeDaLista.peloNomeDe("abc"));
        listaDeDesejos.adicionarProduto(new Produto(new ProdutoID(1L)));
        listaDeDesejos.adicionarProduto(new Produto(new ProdutoID(1L)));
        listaDeDesejos.adicionarProduto(new Produto(new ProdutoID(1L)));

        assertThat(listaDeDesejos.produtos(), hasSize(1));
    }

    @Test
    public void removeProduto() {
        UsuarioID usuario = new UsuarioID(1L);
        ListaDeDesejosID id = new ListaDeDesejosID(usuario, 1L);
        ListaDeDesejos listaDeDesejos = new ListaDeDesejos(id, NomeDaLista.peloNomeDe("abc"));
        listaDeDesejos.adicionarProduto(new Produto(new ProdutoID(1L)));
        listaDeDesejos.removeProduto(new Produto(new ProdutoID(1L)));

        assertThat(listaDeDesejos.produtos(), hasSize(0));
    }
}