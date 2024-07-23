package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Test
import java.math.BigDecimal

class ProdutoTests {

    @Test
    fun `deve retornar verdadeiro quando valor for valido`() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorValido = produtoValido.valorValido

        valorValido.shouldBeTrue()
    }

    @Test
    fun `deve retornar falso quando valor for maior que 100`() {
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        val valorValido = produtoInvalido.valorValido

        valorValido.shouldBeFalse()
    }

    @Test
    fun `deve retornar falso quando valor for menor ou igual a zero`() {
        val produtoComValorIgualAZero = Produto(
            nome = "Lichia",
            descricao = "Doce",
            valor = BigDecimal("0")
        )

        val produtoComValorMenorQueZero = Produto(
            nome = "Uva",
            descricao = "Thompson",
            valor = BigDecimal("-10.99")
        )

        val valorIgualAZeroEhValido = produtoComValorIgualAZero.valorValido
        val valorMenorQueZero = produtoComValorMenorQueZero.valorValido

        valorIgualAZeroEhValido.shouldBeFalse()
        valorMenorQueZero.shouldBeFalse()
    }

}