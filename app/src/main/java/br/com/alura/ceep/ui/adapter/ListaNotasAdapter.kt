package br.com.alura.ceep.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.R
import br.com.alura.ceep.model.Nota
import kotlinx.android.synthetic.main.nota_item.view.*

class ListaNotasAdapter(
    private val context: Context,
    private val notas: List<Nota>,
    val noItemClicado: (posicao: Int) -> Unit
) : RecyclerView.Adapter<ListaNotasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.nota_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nota = notas[position]
        holder.vincula(nota)
    }

    override fun getItemCount(): Int = notas.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var nota: Nota

        init {
            itemView.setOnClickListener {
                noItemClicado(adapterPosition)
            }
        }

        fun vincula(nota: Nota) {
            this.nota = nota
            itemView.nota_item_titulo.text = nota.titulo
            itemView.nota_item_descricao.text = nota.descricao
        }

    }

}
