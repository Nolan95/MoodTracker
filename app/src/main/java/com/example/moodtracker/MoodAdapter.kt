package com.example.moodtracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.data.Mood

class MoodAdapter(private var context:Context,
                  private var moods:MutableList<Mood>) : RecyclerView.Adapter<MoodViewHolder>()  {

    private var constant = Constants()


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MoodViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MoodViewHolder(inflater, parent)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        when (position) {
            1 -> holder.description.setText(R.string.yesterday)

            0 -> holder.description.setText(R.string.today)
            else -> {
                val daysAgoText = "$position" + " " + context.getString(R.string.days_ago)
                holder.description.setText(daysAgoText)
            }
        }

        val mood = moods.get(position)
        holder.constraintLayout.setBackgroundResource(constant.moodColor[mood.mMood])

        //** if there's a comment, show the icon and a toast on click*
        val comment = mood.mComment

        if (!comment.isEmpty()) {
            holder.imageView.setVisibility(View.VISIBLE)
            holder.imageView.setOnClickListener(){
                Toast.makeText(context, comment, Toast.LENGTH_LONG).show()
            }
        } else {
            holder.imageView.setVisibility(View.INVISIBLE)
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = moods.size


}