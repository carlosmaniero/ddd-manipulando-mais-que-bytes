package domain.listadedesejos;

import java.util.Objects;

public class NomeDaLista {
    private final String nome;


    private NomeDaLista(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static NomeDaLista peloNomeDe(String nome) {
        if (nome.length() < 3 || nome.length() > 30) {
            throw new IllegalArgumentException("O nome deve conter no mínimo 3 e no máximo 30 caracteres.");
        }

        return new NomeDaLista(nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NomeDaLista that = (NomeDaLista) o;

        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}
