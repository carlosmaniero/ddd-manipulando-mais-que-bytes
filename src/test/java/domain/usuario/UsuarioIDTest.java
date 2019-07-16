package domain.usuario;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UsuarioIDTest {
    @Test
    public void igualdadaEhBaseadaNoID() {
        UsuarioID subject = new UsuarioID(1L);
        assertThat(subject, not(equalTo(new UsuarioID(2L))));
        assertThat(subject, equalTo(new UsuarioID(1L)));
    }
}