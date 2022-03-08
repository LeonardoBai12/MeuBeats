package io.lb.meubeats.headset_feature.presentation.headset

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import io.lb.meubeats.R
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.utils.formatCurrency

class HeadsetAdapter : RecyclerView.Adapter<HeadsetAdapter.ViewHolder>() {
    private var headsets = emptyList<Headset>()
    private var headsetsFull = emptyList<Headset>()
    lateinit var viewModel: HeadsetViewModel

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_headset, parent, false)
        viewModel = ViewModelProvider(parent.context as AppCompatActivity)[HeadsetViewModel::class.java]
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(headsets[position])

        if (viewModel.selectedPosition == position) {
            changeBackgrounColor(holder.itemView, R.color.primary_dark)
        } else {
            changeBackgrounColor(holder.itemView, R.color.dark_gray)
        }

        holder.itemView.setOnClickListener {
            viewModel.onEvent(HeadsetEvent.OnHeadsetSelected(position, headsets[position]))
            notifyDataSetChanged()
        }
    }

    private fun changeBackgrounColor(itemView: View, id: Int) {
        itemView.setBackgroundColor(
            itemView.context.getColor(id)
        )
    }

    override fun getItemCount(): Int {
        return headsets.size
    }

    fun updateList(headsets: List<Headset>) {
        this.headsets = headsets
        this.headsetsFull = headsets
        notifyDataSetChanged()
    }

    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(filter: CharSequence): FilterResults {
                var typedFilter = filter
                val results = FilterResults()

                if (typedFilter.isEmpty()) {
                    headsets = headsetsFull

                    results.count = headsetsFull.size
                    results.values = headsetsFull
                    return results
                }

                val filteredItems = ArrayList<Headset>()
                headsetsFull.forEach { data ->
                    typedFilter = typedFilter.toString().lowercase()

                    val name = data.name.lowercase()
                    if (name.contains(typedFilter)) {
                        filteredItems.add(data)
                    }
                }

                results.count = filteredItems.size
                results.values = filteredItems
                return results
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                headsets = results.values as List<Headset>
                notifyDataSetChanged()
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvHeadsetName: TextView = view.findViewById(R.id.tv_headset_name)
        private val tvHeadsetScore: TextView = view.findViewById(R.id.tv_headset_score)
        private val tvHeadsetReviews: TextView = view.findViewById(R.id.tv_headset_reviews)
        private val tvHeadsetPrice: TextView = view.findViewById(R.id.tv_headset_price)

        fun bind(headset: Headset) {
            tvHeadsetName.text = headset.name
            tvHeadsetScore.text = headset.averageScore.toString()
            tvHeadsetReviews.text = headset.reviews.toString().plus(" reviews")
            tvHeadsetPrice.text = headset.price.formatCurrency()
        }
    }
}