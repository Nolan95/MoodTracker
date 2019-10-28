package com.example.moodtracker

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MoodViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_mood, parent, false)) {
    lateinit var leftFrameLayout : FrameLayout
    lateinit var rightFrameLayout: FrameLayout
    lateinit var imageButton: ImageButton
    lateinit var daysTextView: TextView


    init {
        leftFrameLayout = itemView.findViewById(R.id.left_frame_layout)
        rightFrameLayout = itemView.findViewById(R.id.right_frame_layout)
        daysTextView = itemView.findViewById(R.id.tv_days)
        imageButton = itemView.findViewById(R.id.btn_show_comment)
    }
}