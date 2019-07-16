package domain.listadedesejos;

import domain.usuario.UsuarioID;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FabricaDeListaDeDesejosTest {
    @Mock
    private RepositorioDeListaDeDesejos repositorioDeListaDeDesejos;
    private FabricaDeListaDeDesejos fabricaDeListaDeDesejos;
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void setUp() {
        fabricaDeListaDeDesejos = new FabricaDeListaDeDesejos(repositorioDeListaDeDesejos);
    }

    @Test
    public void naoCriaListaSeJaHouverUmaComOMesmoNome() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Lista já existe.");

        UsuarioID usuarioID = new UsuarioID(1L);
        NomeDaLista nomeDaLista = NomeDaLista.peloNomeDe("Minha Lista");

        when(repositorioDeListaDeDesejos.contemListaComNomeDe(usuarioID, nomeDaLista)).thenReturn(true);

        fabricaDeListaDeDesejos.criarListaDeDesejos(usuarioID, nomeDaLista);
    }

    @Test
    public void criaListaComIDIncremental() {
        UsuarioID usuarioID = new UsuarioID(1L);
        NomeDaLista nomeDaLista = NomeDaLista.peloNomeDe("Minha Lista");

        when(repositorioDeListaDeDesejos.contemListaComNomeDe(usuarioID, nomeDaLista)).thenReturn(false);
        when(repositorioDeListaDeDesejos.totalDeListasPor(usuarioID)).thenReturn(5);

        ListaDeDesejos listaDeDesejos = fabricaDeListaDeDesejos.criarListaDeDesejos(usuarioID, nomeDaLista);
        assertEquals(listaDeDesejos.getId(), new ListaDeDesejosID(usuarioID, 6L));
        assertEquals(listaDeDesejos.produtos(), emptyList());
        assertEquals(listaDeDesejos.nome(), nomeDaLista);
    }
}