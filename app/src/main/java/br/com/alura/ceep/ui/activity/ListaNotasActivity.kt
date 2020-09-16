package br.com.alura.ceep.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.ceep.R
import br.com.alura.ceep.modelo.Nota
import br.com.alura.ceep.ui.adapter.ListaNotasAdapter
import kotlinx.android.synthetic.main.activity_lista_notas.*

class ListaNotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_notas)
        val recyclerView = activity_lista_notas_recycler_view
        recyclerView.adapter = ListaNotasAdapter(
            context = this, listOf(
                Nota(
                    titulo = "título teste",
                    descricao = "descrição teste"
                ),Nota(
                    titulo = "título teste 2",
                    descricao = "descrição teste 2"
                ),Nota(
                    titulo = "título teste 3",
                    descricao = "descrição teste 3"
                ),
            )
        )
    }
}