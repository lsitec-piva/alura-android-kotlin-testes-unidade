package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.junit.Assert.*
import org.junit.Test

class TestaUsuario {

    @Test
    fun retornaVerdadeiroSeOsDadosDoUsuarioEstaoCertos() {
        val usuarioValido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioValido.ehValido()

        assertTrue(resultado)
    }

    @Test
    fun retornaFalsoSeOEmailDoUsuarioEstiverErrado() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuarioInvalido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioInvalido.ehValido()

        assertFalse(resultado)
    }

    @Test
    fun retornaFalsoSeASenhaDoUsuarioEstiverErradaComMenosDe6Caracteres() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "fraca"
        )

        val resultado = usuarioInvalido.ehValido()

        assertFalse(resultado)
    }

}