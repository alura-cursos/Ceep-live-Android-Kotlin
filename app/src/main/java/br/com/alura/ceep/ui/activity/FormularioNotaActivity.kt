package br.com.alura.ceep.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import br.com.alura.ceep.model.Nota
import kotlinx.android.synthetic.main.activity_formulario_nota.*

class FormularioNotaActivity : AppCompatActivity() {

    private val posicaoNota: Int? by lazy {
        val extras = intent.extras
        if (extras != null && extras.containsKey(POSICAO_NOTA)) {
            return@lazy extras.getInt(POSICAO_NOTA)
        }
        return@lazy null
    }
    private val dao by lazy {
        NotaDAO()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_nota)
        configuraBotaoSalvar()
    }

    override fun onResume() {
        super.onResume()
        buscaNota()
    }

    private fun configuraBotaoSalvar() {
        activity_formulario_botao_salvar.setOnClickListener {
            val nota = criaNota()
            salva(nota)
        }
    }

    private fun criaNota(): Nota {
        val titulo = activity_formulario_titulo.text.toString()
        val descricao = activity_formulario_descricao.text.toString()
        return Nota(titulo, descricao)
    }

    private fun salva(nota: Nota) {
        posicaoNota?.let { posicao ->
            dao.altera(nota, posicao)
        } ?: dao.salva(nota)
        finish()
    }

    private fun buscaNota() {
        posicaoNota?.let { posicao ->
            val nota = dao.buscaNotaPor(posicao)
            activity_formulario_titulo.setText(nota.titulo)
            activity_formulario_descricao.setText(nota.descricao)
        }
    }

}