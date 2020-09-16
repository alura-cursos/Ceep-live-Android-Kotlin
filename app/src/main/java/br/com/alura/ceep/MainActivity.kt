package br.com.alura.ceep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val titulo = activity_main_titulo
        titulo.text = "Meu primeiro título"
        val descricao = activity_main_descricao
        descricao.text = "Minha primeira descrição"
    }
}