package br.com.alura.ceep.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.ceep.R
import br.com.alura.ceep.modelo.Nota
import kotlinx.android.synthetic.main.nota_item.view.*

class ListaNotasAdapter(
    private val context: Context,
    private val notas: List<Nota>
) :
    RecyclerView.Adapter<ListaNotasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewCriada = LayoutInflater
            .from(context).inflate(
                R.layout.nota_item,
                parent,
                false
            )
        return ViewHolder(viewCriada)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nota = notas[position]
        holder.vincula(nota)
    }

    override fun getItemCount(): Int = notas.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun vincula(nota: Nota) {
            itemView.activity_main_titulo.text = nota.titulo
            itemView.activity_main_descricao.text = nota.descricao
        }

    }

}
