package br.com.alura.orgs

import br.com.alura.orgs.model.Produto
import org.junit.Assert.*
import org.junit.Test
import java.math.BigDecimal

class TestaProduto {

    @Test
    fun aoCriarUmProdutoComOValorCertoDeveriaSerValido() {
        val produtoValido = Produto(
            nome = "Banana",
            descricao = "Banana prata",
            valor = BigDecimal("6.99")
        )

        val valorValido = produtoValido.valorValido

        assertTrue(valorValido)
    }

    @Test
    fun seOValorForMaiorQueCemReaisDeveDarErro() {
        val produtoInvalido = Produto(
            nome = "Carambola",
            descricao = "Amarela",
            valor = BigDecimal("105.99")
        )

        val valorValido = produtoInvalido.valorValido

        assertFalse(valorValido)
    }

    @Test
    fun quandoOValorForMenorOuIgualAZeroValorValidoDeveSerFalso() {
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

        assertFalse(valorIgualAZeroEhValido)
        assertFalse(valorMenorQueZero)
    }

}