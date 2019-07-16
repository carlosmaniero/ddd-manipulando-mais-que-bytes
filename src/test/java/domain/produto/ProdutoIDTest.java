package domain.produto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ProdutoIDTest {
    @Test
    public void igualdadaEhBaseadaNoID() {
        ProdutoID subject = new ProdutoID(1L);
        assertThat(subject, not(equalTo(new ProdutoID(2L))));
        assertThat(subject, equalTo(new ProdutoID(1L)));
    }
}