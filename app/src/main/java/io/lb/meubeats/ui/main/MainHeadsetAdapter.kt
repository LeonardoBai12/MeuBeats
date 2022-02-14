package io.lb.meubeats.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.lb.meubeats.R
import io.lb.meubeats.model.headset.Headset
import io.lb.meubeats.utils.DoubleHelper

class MainHeadsetAdapter : RecyclerView.Adapter<MainHeadsetAdapter.ViewHolder>() {
    private var headsets = arrayListOf<Headset>()
    private var headsetsFull = arrayListOf<Headset>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_headset, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(headsets[position])
    }

    override fun getItemCount(): Int {
        return headsets.size
    }

    fun updateList(headsets: ArrayList<Headset>) {
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
                headsets = results.values as ArrayList<Headset>
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
            tvHeadsetReviews.text = headset.reviews.toString()
            tvHeadsetPrice.text = DoubleHelper.formatCurrency(headset.price)
        }
    }
}