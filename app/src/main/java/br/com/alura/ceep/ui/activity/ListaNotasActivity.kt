package br.com.alura.ceep.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import br.com.alura.ceep.ui.adapter.ListaNotasAdapter
import kotlinx.android.synthetic.main.activity_main.*

class ListaNotasActivity : AppCompatActivity() {

    private val dao by lazy {
        NotaDAO()
    }
    private val adapter by lazy {
        ListaNotasAdapter(
            this,
            dao.todas(),
            this::vaiParaDetalhesNota
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configuraRecyclerView()
        configuraFAB()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    private fun configuraRecyclerView() {
        activity_main_recyclerview.adapter = adapter
    }

    private fun vaiParaDetalhesNota(posicao: Int) {
        val intent = Intent(this, DetalhesNotaActivity::class.java)
        intent.putExtra(POSICAO_NOTA, posicao)
        startActivity(intent)
    }

    private fun configuraFAB() {
        activity_main_fab.setOnClickListener {
            val intent = Intent(this, FormularioNotaActivity::class.java)
            startActivity(intent)
        }
    }
}