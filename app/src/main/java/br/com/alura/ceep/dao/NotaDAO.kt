package br.com.alura.ceep.dao

import br.com.alura.ceep.modelo.Nota

class NotaDAO {

    fun todas() : List<Nota> {
        return notas
    }

    fun salva(nota: Nota) {
        notas.add(nota)
    }

    fun buscaNota(posicao: Int): Nota = notas[posicao]

    companion object {
        private val notas: MutableList<Nota> = mutableListOf()
    }

}