package br.com.alura.ceep.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import br.com.alura.ceep.modelo.Nota
import br.com.alura.ceep.ui.adapter.ListaNotasAdapter
import kotlinx.android.synthetic.main.activity_lista_notas.*

class ListaNotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_notas)
        NotaDAO().salva(Nota(
            titulo = "teste",
            descricao = "teste"
        ))
        activity_lista_notas_fab.setOnClickListener {
            val intent = Intent(this, FormularioNotaActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val dao = NotaDAO()
        val recyclerView = activity_lista_notas_recycler_view
        recyclerView.adapter = ListaNotasAdapter(
            context = this, dao.todas()
        ) { posicao ->
            val intent = Intent(this, DetalhesNotaActivity::class.java)
            intent.putExtra("posicaoNota", posicao)
            startActivity(intent)
        }
    }
}