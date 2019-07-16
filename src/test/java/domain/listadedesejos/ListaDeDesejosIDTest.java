package domain.listadedesejos;

import domain.usuario.UsuarioID;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class ListaDeDesejosIDTest {
    @Test
    public void igualdadeEhBaseadaNoUsuarioIdENoNumero() {
        UsuarioID usuario = new UsuarioID(1L);
        ListaDeDesejosID subject = new ListaDeDesejosID(usuario, 1L);
        assertThat(subject, not(equalTo(new ListaDeDesejosID(usuario, 2L))));
        assertThat(subject, not(equalTo(new ListaDeDesejosID(new UsuarioID(2L), 1L))));
        assertThat(subject, equalTo(new ListaDeDesejosID(usuario, 1L)));
    }
}