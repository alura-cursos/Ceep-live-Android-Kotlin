package br.com.alura.ceep.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import kotlinx.android.synthetic.main.activity_detalhes_nota.*

class DetalhesNotaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_nota)

        val extras = intent.extras
        if (extras != null && extras.containsKey("posicaoNota")) {
            val posicao = extras.getInt("posicaoNota")
            val notaDAO = NotaDAO()
            val notaEncontrada = notaDAO.buscaNota(posicao)
            activity_detalhes_produto_titulo.text = notaEncontrada.titulo
            activity_detalhes_produto_descricao.text = notaEncontrada.descricao
        }

    }
}