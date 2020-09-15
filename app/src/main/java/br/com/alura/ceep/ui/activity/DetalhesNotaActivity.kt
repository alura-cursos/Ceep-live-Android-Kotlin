package br.com.alura.ceep.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import kotlinx.android.synthetic.main.activity_detalhes_nota.*

class DetalhesNotaActivity : AppCompatActivity() {

    private val posicaoNota: Int? by lazy {
        val extras = intent.extras
        if (extras != null && extras.containsKey(POSICAO_NOTA)) {
            return@lazy extras.getInt(POSICAO_NOTA)
        }
        return@lazy null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_nota)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detalhes_nota, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        super.onResume()
        buscaNota()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_detalhes_nota_alterar -> vaiParaFormulario()
            R.id.menu_detalhes_nota_remover -> remove()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun remove() {
        val notaDAO = NotaDAO()
        posicaoNota?.let {
            notaDAO.remove(it)
            finish()
        }
    }

    private fun vaiParaFormulario() {
        val intent = Intent(this, FormularioNotaActivity::class.java)
        intent.putExtra(POSICAO_NOTA, posicaoNota)
        startActivity(intent)
    }

    private fun buscaNota() {
        posicaoNota?.let { posicao ->
            val notaDAO = NotaDAO()
            val nota = notaDAO.buscaNotaPor(posicao)
            activity_detalhes_nota_titulo.text = nota.titulo
            activity_detalhes_nota_descricao.text = nota.descricao
        } ?: finish()
    }
}