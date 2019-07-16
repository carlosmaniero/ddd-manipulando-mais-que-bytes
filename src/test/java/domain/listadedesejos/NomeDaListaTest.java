package domain.listadedesejos;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class NomeDaListaTest {
    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionCasoNomeSejaMenorQue3Caracteres() {
        NomeDaLista.peloNomeDe("ab");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionCasoNomeSejaMaiorQue30Caracteres() {
        NomeDaLista.peloNomeDe("Nome com mais de 31 caracteres.");
    }

    @Test
    public void criaCom30Caracters() {
        String nome = "Nome de exatos 30 caracteres.";
        assertEquals(NomeDaLista.peloNomeDe(nome).toString(), nome);
    }

    @Test
    public void equals() {
        String nome = "Nome de exatos 30 caracteres.";
        assertEquals(NomeDaLista.peloNomeDe(nome), NomeDaLista.peloNomeDe(nome));
        assertThat(NomeDaLista.peloNomeDe(nome), not(equalTo(NomeDaLista.peloNomeDe("bla"))));
    }
}