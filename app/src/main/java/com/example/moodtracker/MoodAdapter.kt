package com.example.moodtracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MoodAdapter(private var context:Context,
                  private var moods:ArrayList<Int>,
                  private var comments:ArrayList<String>) : RecyclerView.Adapter<MoodViewHolder>()  {

    private lateinit var constant: Constants


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MoodViewHolder(inflater, parent)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        when (position) {
            1 -> holder.daysTextView.setText(R.string.yesterday)

            0 -> holder.daysTextView.setText(R.string.today)
            else -> {
                val daysAgoText = "$position" + " " + context.getString(R.string.days_ago)
                holder.daysTextView.setText(daysAgoText)
            }
        }

        val mood = moods.get(position)
        val leftLayoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT)
        val rightLayoutParams = LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT)
        val weight: Float
        when (mood) {
            0 -> weight = 0.2f
            1 -> weight = 0.4f
            2 -> weight = 0.6f
            3 -> weight = 0.8f
            4 -> weight = 1.0f
            else -> weight = 0.8f
        }
        leftLayoutParams.weight = weight
        rightLayoutParams.weight = 1.0f - weight
        holder.leftFrameLayout.setLayoutParams(leftLayoutParams)
        holder.rightFrameLayout.setLayoutParams(rightLayoutParams)
        holder.leftFrameLayout.setBackgroundResource(constant.moodColor[mood])

        //** if there's a comment, show the icon and a toast on click*
        val comment = comments.get(position)

        if (!comment.isEmpty()) {
            holder.imageButton.setVisibility(View.VISIBLE)
            holder.imageButton.setOnClickListener(){
                Toast.makeText(context, comment, Toast.LENGTH_LONG).show()
            }
        } else {
            holder.imageButton.setVisibility(View.INVISIBLE)
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = moods.size


}