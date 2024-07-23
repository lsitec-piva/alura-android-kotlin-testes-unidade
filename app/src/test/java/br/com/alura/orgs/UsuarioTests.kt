package br.com.alura.orgs

import br.com.alura.orgs.model.Usuario
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test

class UsuarioTests {

    @Test
    fun `deve retornar verdadeiro se os dados do usuario estao certos`() {
        val usuarioValido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioValido.ehValido()

        resultado.shouldBeTrue()
    }

    @Test
    fun `deve retornar falso se o email do usuario estiver errado`() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuarioInvalido.com",
            senha = "senhaforte123"
        )

        val resultado = usuarioInvalido.ehValido()

        resultado.shouldBeFalse()
    }

    @Test
    fun `deve retornar falso se a senha do usuario estiver errada com menos de 6 caracteres`() {
        val usuarioInvalido = Usuario(
            id = "usuario",
            email = "usuario@valido.com",
            senha = "fraca"
        )

        val resultado = usuarioInvalido.ehValido()

        resultado.shouldBeFalse()
    }

}