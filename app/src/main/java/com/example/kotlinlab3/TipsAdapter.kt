package com.example.kotlinlab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TipsAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipsAdapter.TipViewHolder>() {

    class TipViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDayNumber: TextView = view.findViewById(R.id.tvDayNumber)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val ivTipImage: ImageView = view.findViewById(R.id.ivTipImage)
        val tvShortDescription: TextView = view.findViewById(R.id.tvShortDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        val context = holder.itemView.context

        val dayString = context.getString(R.string.day_prefix) + tip.dayNumber
        holder.tvDayNumber.text = dayString

        holder.tvTitle.setText(tip.titleRes)
        holder.tvShortDescription.setText(tip.shortDescRes)
        holder.ivTipImage.setImageResource(tip.imageRes)

        holder.itemView.setOnClickListener {
            onItemClick(tip)
        }
    }

    override fun getItemCount(): Int {
        return tips.size
    }
}