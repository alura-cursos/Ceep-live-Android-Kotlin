package br.com.alura.ceep.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.alura.ceep.R
import br.com.alura.ceep.dao.NotaDAO
import br.com.alura.ceep.modelo.Nota
import kotlinx.android.synthetic.main.activity_formulario_nota.*

class FormularioNotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_nota)

        activity_formulario_nota_botao_salvar.setOnClickListener {
            val titulo = activity_formulario_nota_titulo.text.toString()
            val descricao = activity_formulario_nota_descricao.text.toString()
            val nota = Nota(titulo, descricao)
            val dao = NotaDAO()
            dao.salva(nota)
            finish()
        }

    }
}