package br.com.alura.ceep.dao

import br.com.alura.ceep.model.Nota

class NotaDAO {

    fun todas(): List<Nota> {
        return notas
    }

    fun salva(vararg notas: Nota) {
        Companion.notas.addAll(notas)
    }

    fun buscaNotaPor(posicao: Int): Nota {
        return notas[posicao]
    }

    fun altera(nota: Nota, posicao: Int) {
        notas[posicao] = nota
    }

    fun remove(posicao: Int) {
        notas.removeAt(posicao)
    }

    companion object {
        private val notas = mutableListOf<Nota>()
    }

}