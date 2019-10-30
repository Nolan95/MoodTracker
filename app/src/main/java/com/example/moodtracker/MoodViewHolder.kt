package com.example.moodtracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


class MoodViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_mood, parent, false)) {

    var imageView: ImageView = itemView.findViewById(R.id.btn_show_comment)
    var description: TextView = itemView.findViewById(R.id.description)
    var constraintLayout: ConstraintLayout = itemView.findViewById(R.id.item_constraint_layout)
}